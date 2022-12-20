/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public abstract class Game {

public input[][] gameBoard;
public Coordinates[] coordinates;
public input playerT;

//----------------
public Game(){
    this.gameBoard = new input[3][3];
    this.coordinates = new Coordinates[9];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            gameBoard[i][j] = input.EMPTY;
        }
    }
}

//------Get&Set-----
public input[][] getGameBoard() {
    return gameBoard;
}
public void setGameBoard(input[][] gameBoard) {
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
            if(gameBoard[i][j] == input.EMPTY)
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
            if(gameBoard[i][j] == input.EMPTY)//If there is an empty cell return false
                return false;
        }
    }
    return true; 
}
//Sets the cell with the coordinates given to update the players turn
public void setCell(int x, int y, input playerT){
    gameBoard[x][y] = playerT;
}

//Cheking if there is a winning row
public boolean winRow(int x,int y){
    input compare = gameBoard[x][y];

    for (int j = 0; j < 3; j ++) {
        if(compare != gameBoard[x][j] ){
            return false;
        }   
    }
    return true;
}
//Cheking if there is a winning colomn
public boolean winCol(int x,int y){
    input compare = gameBoard[x][y];

    for (int i = 0; i < 3; i ++) {
        if(compare != gameBoard[i][y] ){
            return false;
        }   
    }
    return true;
}
//Cheking if there is a winning strike on first daigonal
public boolean winDig1(int x,int y){
    input compare = gameBoard[x][y];

    for (int i = 0; i < 3; i ++) {
        if(compare != gameBoard[i][i]){
            return false;
        }
    }
    return true;
}
//Cheking if there is a winning strike on second daigonal
public boolean winDig2(int x,int y){
    input compare = gameBoard[x][y];

    if((compare == gameBoard[0][2]) && (compare == gameBoard[1][1])&& (compare == gameBoard[2][0])){
         return true;
    }

    return false;
}
//Checking if the new cell makes a strike
public boolean Win(int x,int y){
   
    //Checks cells that sit on the first daigonal
    if(x == y){
        if(winRow(x,y) && winCol(x,y) && winDig1(x,y)) 
            return true;
        //If its the middle cell check also the second daigonal
        if((x == 1 && y == 1) && (winDig2(x,y)))
            return true;
    }else if((x == 0 || y == 0) && (x == 2 || y == 2)){//Checks cells that sit on the second daigonal
        if(winRow(x,y) && winCol(x,y) && winDig2(x,y))
            return true;
    }else if(winRow(x,y) && winCol(x,y))//Checks cells that dont sit on the daigonals
            return true;
            
    return false;
    }
}