/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
class Main{



    public static void main(String[] args){
        Scanner user = new Scanner(System.in); 
        
        //Creating a game
        SelfGame gameS = new SelfGame(null, null, null);
        UserGame gameU = new UserGame(null, null, null);
        SelfPlayer  p1 = new SelfPlayer('X');
        SelfPlayer  p2 = new SelfPlayer('O');

        //Asking the user to choose a game type
        System.out.println("Choose the amount of players: 1 or 2");
        int userName = user.nextInt();

        if(userName == 1){

        }else if(userName == 2){

        }else System.out.println("Error you have to choose 1 or 2");
        
        //starting threads
        new Thread(p1).start();
        new Thread(p2).start();
        


    }
}