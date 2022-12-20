import java.util.Scanner;
/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
class Main{
    public static void main(String[] args){

        Scanner user = new Scanner(System.in); 

        //Asking the user to choose a game type
        System.out.println("Choose the game version: 1 for automatic; 2 for interactive");
        int userName = user.nextInt();

        if(userName == 1){
            SelfGame game = new SelfGame();

            SelfPlayer p1 = new SelfPlayer(game, Input.O);
            SelfPlayer p2 = new SelfPlayer(game, Input.X);
            
                       
            //starting threads
            new Thread(p1).start();
            new Thread(p2).start();

        }else if(userName == 2){
            	UserGame game = new UserGame();

                UserPlayer player1 = new UserPlayer(game, Input.O);
                SelfPlayer player2 = new SelfPlayer(game, Input.X);
                //starting threads
                new Thread(player1).start();
                new Thread(player2).start();

                }else System.out.println("Error you have to choose 1 or 2");
    }
}