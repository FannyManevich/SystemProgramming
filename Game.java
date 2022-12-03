
public abstract class Game {
/* 
 * Fany Manevich 206116725
 * 
*/
public char[][] gameBoard;
public Coordinates[] coordinates;

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


public Game()
{
    this.gameBoard = new char[3][3];
    this.coordinates = new Coordinates[9];
}

//--------Fix---------
public input getTurn()
{
    input userInput = input.O;
    return userInput;
}
//Printing the game board
public void printBoard(char[][] gameBoard){
    for(int i = 0;i <= 2;i ++)
    {
        for(int j = 0; j <= 2; j ++)
        {
            System.out.println(gameBoard[i][j] + " ,");
        }
        System.out.println();

    }
}

//returns coordinates of empty cells
public Coordinates[] getFreeCells(char[][] gameBoard)
{
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

}