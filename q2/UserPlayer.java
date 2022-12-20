import java.util.Scanner;

/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public class UserPlayer implements Runnable {
	private Input userSymbol;
	private Game game;
	private Input notMySymbol;

	public UserPlayer(Game g, Input userSymbol) {
		this.game = g;
		this.userSymbol = userSymbol;

		if (this.userSymbol == Input.O) {
			this.notMySymbol = Input.X;
		} else {
			this.notMySymbol = Input.O;
		}
	}

	public void run() {
		
		Scanner inputc = new Scanner(System.in);


		int x, y;

		while (true) {
			
			sleep();
			
			if (game.CheckFull()) {
				System.out.println("Board is full");
				return;
			}
			
			if (game.win(userSymbol)) {
				System.out.println("We won!");
				return;
			}
			
			if (game.win(notMySymbol)) {
				return;
			}
			
			game.printBoard();
			

			System.out.print ("Please enter cell x coordinates: ");
			x = inputc.nextInt();

			System.out.println();
			
			System.out.println("Please enter cell y coordinates: ");
			y = inputc.nextInt();

			boolean found = false;
			for (Coordinate c : game.getFreeCells()) {
				if (c.getX() == x && c.getY() == y) {
					found = true;
				}
			}

			if (!found) {
				System.out.println("Coordinate (" + x + "," + y + ") is already in use");
				continue;
			}

			game.setCell(x, y, userSymbol);
			synchronized(game) {
				game.notify();
			}

		}
	}
	
	private void sleep() {
		try {
			synchronized(this.game) {
				if (game.getTurn() == userSymbol) {
					return;
				}
				this.game.wait(500);
			}
		} catch (InterruptedException e) {
		}
	}
}