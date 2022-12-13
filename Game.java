/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public abstract class Game {

public char[][] gameBoard;
public Coordinates[] coordinates;
public input playerT;

//----------------
public Game(){
    this.gameBoard = new char[3][3];
    this.coordinates = new Coordinates[9];
}

//------Get&Set-----
public char[][] getGameBoard() {
    return gameBoard;
}
public void setGameBoard(char[][] gameBoard) {
    this.gameBoard = gameBoard;
}

public Coordinates[] getCoordinates() {
    return coordinates;
}

public void setCoordinates(Coordinates[] coordinates) {
    this.coordinates = coordinates;
}

//Type of player
public input getTurn(){
    return playerT;
}

//Printing the game board
public void printBoard(){
    for(int i = 0;i <= 2;i ++)
    {
        System.out.println("-----------");
        for(int j = 0; j <= 2; j ++)
        {
            System.out.println("| " + gameBoard[i][j] + " |");
        }

    }
}

//returns coordinates of empty cells
public Coordinates[] getFreeCells(){
    int c = 0;

    for(int i = 0;i <= 2;i ++)
    {
        for(int j = 0; j <= 2; j ++)
        {
            if(gameBoard[i][j] == ' ')
            {
                coordinates[c].setX(i);
                coordinates[c].setY(j);
                c ++;
            }
        }
    }

    return coordinates;
}
//Checks if the board is full
public boolean CheckFull(){
    for (int i = 0; i < 3; i ++) {
        for (int j = 0; j < 3; j ++) {
            if(gameBoard[i][j] == ' ')//If there is an empty cell return false
                return false;
        }
    }
    return true; 
}
//Sets the cell with the coordinates given to update the players turn
public void setCell(int x, int y, input playerT){
    gameBoard[x][y] = playerT;
}
}