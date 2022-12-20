/*
 * Cindy Zilberman - 316268150
 * Fany Manevich - 206116725
 */
public class Car extends Wehicle{
	
	Car(WehicleWasher ww, double lamdaArrival, double lamdaWashing){
		id = WEHICLE_ID++;
		this.ww = ww;
		this.lamdaArrival = lamdaArrival;
		this.lamdaWashing = lamdaWashing;
		this.isCleaned = false;
	}
}











































//while(!)Thread.interrupted()) {
//try {
//	if(!isAvailable()) {
//		preDriving(); // prints truck next destination
//		while (getTimeLeft() != 0) {
//			Thread.sleep(washingTime);
//			setTimeLeft(TimeLeft() - 1);
//		}
//		handlePackages();
//	}
//	synchronized (this) {
//		wait();
//	}
//
//} catch (InterruptedException e) {
//	e.printStackTrace();
//}
//}