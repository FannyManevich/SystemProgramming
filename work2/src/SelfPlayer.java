import java.util.Random;

/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public class SelfPlayer implements Runnable{

    Random random = new Random();
    SelfGame game;
    input mySymbol;

    public void run()
    {
        int i, x, y;
        Coordinates[] coordinates;
        while(true){
            try {
                //Puts current thread to sleep
                Thread.currentThread();
                Thread.sleep(500);
                if(game.getTurn() == mySymbol ){
                    if(!game.CheckFull()){
                        //Will get the coordinates of the free cells
                        coordinates = game.getFreeCells();
                        i = random.nextInt(9);
                        //Gets the coordinates of the free cell chosen randomly
                        x = coordinates[i].getX();
                        y = coordinates[i].getY();
                        game.setCell(x, y, mySymbol);
                        if(game.Win(x,y))
                        {
                            System.out.println("The winner is player:" + mySymbol);
                            return;
                        }
                        notify();
                        game.printBoard();
                    }else{//If the board is full it will print a message and exit the game
                        System.out.println("Board is full");
                        return;
                    }

                }
                
            } catch (InterruptedException e) {
               return;
            }
    }
}
}