import java.util.ArrayList;


/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public abstract class Game {

	private Input[][] gameBoard;
	private Input playerT;

//----------------
	public Game() {
		this.playerT = Input.O;
		this.gameBoard = new Input[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = Input.EMPTY;
			}
		}
	}

//------Get&Set-----
	public Input[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Input[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

//Type of player
	public synchronized Input getTurn() {
		return playerT;
	}

//Printing the game board
	public void printBoard() {
		System.out.println("Player (" + playerT +")'s turn");
		System.out.println("-----------");
		for (int i = 0; i <= 2; i++) {

			for (int j = 0; j <= 2; j++) {
				System.out.print("| " + gameBoard[i][j]);
			}
			System.out.println("|");
			System.out.println("-----------");
		}
		
		System.out.println("");

	}

//returns coordinates of empty cells
	public Coordinate[] getFreeCells() {
		ArrayList<Coordinate> freeCells = new ArrayList<Coordinate>();

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (gameBoard[i][j] == Input.EMPTY) {
					Coordinate c = new Coordinate(i, j);
					freeCells.add(c);
				}
			}
		}
		return (Coordinate[]) freeCells.toArray(new Coordinate[freeCells.size()]);
	}

//Checks if the board is full
	public synchronized boolean CheckFull() {
		if ( this.getFreeCells().length == 0) {
			System.out.println("Board is full");
			return true;
		}
		return false;
	}

//Sets the cell with the coordinates given to update the players turn
	public synchronized void setCell(int x, int y, Input playerT) {
		gameBoard[x][y] = playerT;
		if (playerT == Input.O) {
			this.playerT = Input.X;
		} else {
			this.playerT = Input.O;
		}
	}

	public synchronized boolean win(Input player) {
		// Check rows and columns
		for (int i = 0; i < 3; i++) {
			int currentRow = 0;
			int currentCol = 0;
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == player) {
					currentRow++;
				}
				if (gameBoard[j][i] == player) {
					currentCol++;
				}
			}
			if (currentRow == 3 || currentCol == 3) {
				return true;
			}
		}
		
		// Check diagonals
		if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
			return true;
		}
		
		if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
			return true;
		}
		
		return false;
		
	}
}