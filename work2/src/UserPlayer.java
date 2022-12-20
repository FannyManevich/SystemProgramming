import java.util.Scanner;
/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public class UserPlayer implements Runnable
{
    input userSymbol;
    UserGame game;
 
    public void run(){

        int x, y; 
        Scanner inputc = new Scanner(System.in); 
    
        while(true){
            if(game.getTurn() == userSymbol ){//Checks if its the users turn
                System.out.println("Please enter cell coordinates: x:");
                x = inputc.nextInt();

                System.out.println("Please enter cell coordinates: y:");
                y = inputc.nextInt();
                //Checks if the board is full
                if(!game.CheckFull()){

                    if(game.gameBoard[x][y] == input.EMPTY){//Checks if the cell is empty
                        game.setCell(x, y, userSymbol);
                        if(game.Win(x,y))
                        {
                            System.out.println("The winner is player:" + userSymbol);
                            return ;
                        }
                        notify();
                        game.printBoard();
                        inputc.close();
                    }else{
                        System.out.println("Error the cell is full.");
                    }  

                }else{//If the board is full it will print a message and exit the game
                    System.out.println("Board is full");
                    return;
                }
            }

       }
        
    }
}