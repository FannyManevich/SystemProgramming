/*
 * Cindy Zilberman - 316268150
 * Fany Manevich - 206116725
 */
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter number of vehicles: ");
		int M = scan.nextInt();
		
		System.out.println("Please enter number of washing stations: ");
		int N = scan.nextInt();
		
		System.out.println("Please enter lamda1: ");
		double lamda1 = scan.nextDouble();
		
		System.out.println("Please enter lamda2: ");
		double lamda2 = scan.nextDouble();
		long startingTime = System.currentTimeMillis();
		WehicleWasher ww = new WehicleWasher(N, startingTime);
		Random rand = new Random();
		while(M > 0) {
			int rand2 = rand.nextInt(4);
			switch(rand2) {
				case 0:
					new Thread(new Car(ww, lamda1, lamda2)).start();
					break;
				case 1:
					new Thread(new MiniBus(ww, lamda1, lamda2)).start();
					break;
				case 2:
					new Thread(new SUV(ww, lamda1, lamda2)).start();
					break;
				case 3:
					new Thread(new Truck(ww, lamda1, lamda2)).start();
					break;
			}
			M--;
		}
	}

}
