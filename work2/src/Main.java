import java.util.Scanner;
/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
class Main{
    public static void main(String[] args){

        Scanner user = new Scanner(System.in); 

        //Asking the user to choose a game type
        System.out.println("Choose the amount of players: 1 or 2");
        int userName = user.nextInt();

        if(userName == 1){
            SelfPlayer p1 = new SelfPlayer();
            SelfPlayer p2 = new SelfPlayer();
            SelfGame gameS = new SelfGame(p1.mySymbol);
            //starting threads
            new Thread(p1).start();
            new Thread(p2).start();

        }else if(userName == 2){
                UserPlayer player1 = new UserPlayer();
                SelfPlayer player2 = new SelfPlayer();
                UserGame gameU = new UserGame();
                //starting threads
                new Thread(player1).start();
                new Thread(player2).start();

                }else System.out.println("Error you have to choose 1 or 2");
        user.close();

    }
}