/**
 * @author nivedita
 */

/**
 * The BowlingGame class represents a single bowling game. <br>
 * Each game has 10 frames by default, but 2 bonus frames are awarded if last
 * frame was a strike/spare. So, a game can have a maximum of 12 frames and a
 * minimum of 10.
 */

public class BowlingGame {

	/**
	 * Represents an empty roll in a frame
	 */
	public static final int EMPTY = -1;

	/**
	 * in 10 - pin bowling last frame is 10
	 */
	public static final int LAST_FRAME = 10;

	/**
	 * used when frame 10 was a strike/spare
	 */
	public static final int BONUS_FRAME_1 = 11;

	/**
	 * used when frame 10 and frame 11 were strike
	 */
	public static final int BONUS_FRAME_2 = 12;
	public static final int MAX_FRAMES = 12;
	public static final int MAX_PINS_ROLLED = 10;
	public static final int STRIKE_BONUS = 2;
	public static final int SPARE_BONUS = 1;

	public Frame[] frames;

	/**
	 * Keeps track of the attempt (0 - 11). <br>
	 * current frame = attempt + 1
	 */
	private int attempt;

	/**
	 * Default constructor to initialize the instance variables
	 */
	public BowlingGame() {

		this.attempt = 0;
		this.frames = new Frame[MAX_FRAMES];

		// initialize the frames
		for (int i = 0; i < frames.length; i++) {

			this.frames[i] = new Frame();
		}
	}

	/**
	 * 
	 * @param pins - the no. of pins rolled in this roll
	 */
	public void roll(int pins) {

		// game in progress
		if (!isFinished()) {

			// number of pins rolled is valid
			if (pins <= 10) {

				// the no. of pins rolled is valid for the current attempt
				if (isValidRoll(pins, attempt)) {

					// points are calculated only up to the last frame, not for bonus frames
					if (attempt <= LAST_FRAME - 1) {

						frames[attempt].addToTemp(pins);
					}

					// the frame before prev gets bonus points from this roll (as strike gets bonus
					// from 2 subsequent rolls)
					if (attempt - 2 >= 0 && frames[attempt - 2].getBonus() > 0) {

						// add bonus points to temp
						frames[attempt - 2].addToTemp(pins);

						// decrease bonus count
						frames[attempt - 2].decreaseBonus();

						// not more bonus for attempt - 2, so calculate final score
						if (frames[attempt - 2].getBonus() == 0) {

							// if there a frame before attempt - 2
							if (attempt - 3 >= 0) {

								// add points from prev frame to its points
								frames[attempt - 2]
										.setPoints(frames[attempt - 3].getPoints() + frames[attempt - 2].getTemp());
							}
							// this is the first frame
							else {
								frames[attempt - 2].setPoints(frames[attempt - 2].getTemp());
							}
						}
					}

					// prev frame gets bonus points from this roll
					if (attempt - 1 >= 0 && frames[attempt - 1].getBonus() > 0) {

						// add bonus points to temp
						frames[attempt - 1].addToTemp(pins);

						// decrease bonus count
						frames[attempt - 1].decreaseBonus();

						// the score for attempt - 1 is now complete
						if (frames[attempt - 1].getBonus() == 0) {

							// if there a frame before attempt - 1
							if (attempt - 2 >= 0) {

								// add points from prev frame to its points
								frames[attempt - 1]
										.setPoints(frames[attempt - 2].getPoints() + frames[attempt - 1].getTemp());
							}
							// this is the first frame
							else {
								frames[attempt - 1].setPoints(frames[attempt - 1].getTemp());
							}
						}
					}

					// first roll of the frame
					if (frames[attempt].getFirstRoll() == EMPTY) {

						frames[attempt].setFirstRoll(pins);

						// strike
						if (isStrike(attempt)) {

							frames[attempt].setBonus(STRIKE_BONUS);
							frames[attempt].setStrike(true);

							attempt++;
							return;
						}

						// EDGE CASE: if last frame was spare, only first bonusroll is enough
						if (attempt == BONUS_FRAME_1 - 1 && isSpare(LAST_FRAME - 1)) {

							attempt++;
							return;
						}

						// EDGE CASE: last attempt was strike, and next was also strike, one more frame
						// required
						if (attempt == BONUS_FRAME_2 - 1 && isStrike(LAST_FRAME - 1) && isStrike(BONUS_FRAME_1 - 1)) {
							attempt++;
						}
					}
					// second roll
					else {

						frames[attempt].setSecondRoll(pins);

						// spare
						if (isSpare(attempt)) {

							frames[attempt].setBonus(SPARE_BONUS);
							frames[attempt].setSpare(true);
						}
						// open frame
						else {
							// add the score to previous score
							if (attempt - 1 >= 0) {
								frames[attempt].setPoints(frames[attempt - 1].getPoints() + frames[attempt].getTemp());
							}
							// this is the first frame
							else {
								frames[attempt].setPoints(frames[attempt].getTemp());
							}
						}
						// move to next frame, since this was the second roll
						attempt++;
						return;
					}
				} else {
					System.out.println("INVALID ROLL: The number of pins rolled is invalid for this attempt");
				}
			} else {
				System.out.println("INVALID ROLL: Cannot knock more than 10 pins");
			}
		} else {
			System.out.println("GAME OVER!!");
		}
	}

	public boolean isValidRoll(int pins, int attempt) {

		if (frames[attempt].getFirstRoll() == EMPTY) {

			if (pins <= MAX_PINS_ROLLED)
				return true;
			else
				return false;

		} else {

			if (frames[attempt].getFirstRoll() + pins <= MAX_PINS_ROLLED) {
				return true;
			} else {
				return false;
			}
		}
	}

	public int getScore() {

		int ptr = EMPTY;
		
		// find the last frame with not - zero score
		for (int i = frames.length - 1; i >= 0; i--) {

			if (frames[i].getPoints() > 0) {
				ptr = i;
				break;
			}
		}

		if (ptr == EMPTY)
			return 0;
		else
			return frames[ptr].getPoints();
	}

	public boolean isFinished() {

		if (attempt <= LAST_FRAME - 1) {
			
			return false;
		} 
		// EDGE CASES: when last rolls are strike/spare
		else if (attempt == BONUS_FRAME_1 - 1) {

			if (isStrike(LAST_FRAME - 1) || isSpare(LAST_FRAME - 1)) {
				return false;
			}
			// game has ended
			else {
				return true;
			}

		} else if (attempt == BONUS_FRAME_2 - 1) {

			// strike
			if (isStrike(LAST_FRAME - 1) && frames[LAST_FRAME - 1].getBonus() > 0) {
				return false;
			}
			// spare
			else {
				return true;
			}
		} else {
			return true;
		}
	}

	/**
	 * checks if the attempt was a strike based on the pins rolled
	 * 
	 * @param attempt - attempt to check
	 * @return - true, if it is a strike, else return false
	 */
	public boolean isStrike(int attempt) {

		// check if first roll was strike
		return frames[attempt].getFirstRoll() == 10;
	}

	/**
	 * checks if the attempt was a spare based on the pins rolled
	 * 
	 * @param attempt - attempt to check
	 * @return - true, if it is a spare, else return false
	 */
	public boolean isSpare(int attempt) {

		// check if sum of both rolls is 10
		return (frames[attempt].getFirstRoll() + frames[attempt].getSecondRoll()) == 10;
	}
}
