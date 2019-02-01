/**
 * @author nivedita
 */

/**
 * The frame class represents a single frame of the 10 - pin Bowling game score
 * board. <br>
 * Each frame has 2 rolls. <br>
 * The total points for the frame is calculated after all rolls (including bonus
 * rolls)
 */
public class Frame {

	/**
	 * number of pins knocked over in first roll of the frame (max = 10)
	 */
	private int firstRoll;

	/**
	 * Number of pins knocked over in second roll of the frame (max = 10). <br>
	 * The sum of firstRoll and secondRoll should be <= 10
	 */
	private int secondRoll;

	/**
	 * Instance variable to store the temp score for the frame
	 */
	private int temp;

	/**
	 * Instance variable to store the bonus rolls (for strike/spare) for the frame
	 */
	private int bonus;

	/**
	 * Instance variable to store the total points for the frame (including points
	 * from bonus rolls)
	 */
	private int points;

	/**
	 * Instance variable to denote if the frame was a Strike. <br>
	 * Strike : When all ten pins are knocked down with the first ball , the player
	 * is awarded ten pins, plus a bonus of whatever is scored with the next two
	 * rolls (not necessarily the next two frames).
	 * 
	 * To be used to display the score board.
	 */
	private boolean isStrike;

	/**
	 * Instance variable to denote if the frame was a Spare. <br>
	 * Spare : Awarded when a player uses both balls of a frame to clear all ten
	 * pins. A player achieving a spare is awarded ten pins, plus a bonus of
	 * whatever is scored with the next roll (not necessarily the next frame)
	 * 
	 * To be used to display the score board.
	 */
	private boolean isSpare;

	/**
	 * Default constructor to initialize the instance variables
	 */
	public Frame() {

		this.firstRoll = BowlingGame.EMPTY;
		this.secondRoll = BowlingGame.EMPTY;
		this.temp = 0;
		this.bonus = 0;
		this.points = 0;
		this.isSpare = false;
		this.isStrike = false;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the isStrike
	 */
	public boolean isStrike() {
		return isStrike;
	}

	/**
	 * A simple setter method
	 * 
	 * @param isStrike - the isStrike to set
	 */
	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the isSpare
	 */
	public boolean isSpare() {
		return isSpare;
	}

	/**
	 * A simple setter method
	 * 
	 * @param isSpare - the isSpare to set
	 */
	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the temp
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * Adds a number to temp and updates it's value
	 * 
	 * @param val - the value to add to temp
	 */
	public void addToTemp(int val) {
		this.temp += val;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the firstRoll
	 */
	public int getFirstRoll() {
		return firstRoll;
	}

	/**
	 * A simple setter method
	 * 
	 * @param firstRoll - the firstRoll to set
	 */
	public void setFirstRoll(int firstRoll) {
		this.firstRoll = firstRoll;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the secondRoll
	 */
	public int getSecondRoll() {
		return secondRoll;
	}

	/**
	 * A simple setter method
	 * 
	 * @param secondRoll - the secondRoll to set
	 */
	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * A simple setter method
	 * 
	 * @param bonus - the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * Decreases the bonus by 1
	 */
	public void decreaseBonus() {
		this.bonus--;
	}

	/**
	 * A simple getter method
	 * 
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * A simple setter method
	 * 
	 * @param points - the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
}
