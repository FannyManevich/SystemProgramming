/*
 * Cindy Zilberman - 316268150
 * Fany Manevich - 206116725
 */
public class SUV extends Wehicle{
	SUV(WehicleWasher ww, double lamdaArrival, double lamdaWashing){
		id = WEHICLE_ID++;
		this.ww = ww;
		this.lamdaArrival = lamdaArrival;
		this.lamdaWashing = lamdaWashing;
		this.isCleaned = false;
	}
}