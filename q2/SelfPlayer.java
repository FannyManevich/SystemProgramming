import java.util.Random;

/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public class SelfPlayer implements Runnable {

	Random random = new Random();
	Game game;
	Input mySymbol;
	Input notMySymbol;

	public SelfPlayer(Game g, Input mySymbol) {
		this.game = g;
		this.mySymbol = mySymbol;
		if (this.mySymbol == Input.O) {
			this.notMySymbol = Input.X;
		} else {
			this.notMySymbol = Input.O;
		}
	}

	public void run() {
		while (true) {
			if (game.win(mySymbol)) {
				System.out.println("Player " + mySymbol + " won!");
				return;
			}
			
			if (game.win(notMySymbol)) {
				return;
			}
			
			if (game.CheckFull()) {
				return;
			}

			sleep();
			
			if (game.getTurn() != mySymbol) {
				continue;
			}

			act();

		}
	}
	
	private void act() {
		Coordinate[] coordinates = game.getFreeCells();
		if (coordinates.length == 0) {
			return;
		}
		int i = random.nextInt(coordinates.length);
		int x = coordinates[i].getX();
		int y = coordinates[i].getY();
		game.setCell(x, y, mySymbol);
		synchronized(game) {
			game.printBoard();
			game.notify();
		}
	}

	private void sleep() {
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e1) {
		}
	}

}