/**
 * @author nivedita
 */

public class Main {

	public static void main(String args[]) {

		BowlingGame game = new BowlingGame();

		System.out.println(game.getScore());
		System.out.println(game.isFinished());
		
		
		game.roll(0);
		
		
		for (int i = 0; i < 17 ; i++) {
			game.roll(0);
		}
		
		game.roll(10);
		game.roll(9);
		game.roll(1);

		// Score board
		for (int i = 0 ; i < game.frames.length; i++) {
			
			System.out.print(i+". ");
			System.out.print("[" + game.frames[i].getFirstRoll() + " , ");
			
			if (game.frames[i].isSpare())
				System.out.print("\\");
			else if (game.frames[i].isStrike())
				System.out.print("X");
			else 
				System.out.print(game.frames[i].getSecondRoll());

			System.out.print("] , Temp: " + game.frames[i].getTemp());
			System.out.print(", Points: " + game.frames[i].getPoints());
			System.out.println();
		}
		
		System.out.println(game.getScore());
		System.out.println(game.isFinished());
	}
}
