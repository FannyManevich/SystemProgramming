/*
 * Cindy Zilberman - 316268150
 * Fany Manevich - 206116725
 */
public abstract class Wehicle implements Runnable {
	protected static int WEHICLE_ID = 1000;
	protected int id;
	protected WehicleWasher ww;
	protected double lamdaArrival;
	protected double lamdaWashing;
	protected  boolean isCleaned;
	
	
	public int getId() {
		return id;
	}
	
	public int nextTime(double lamda) {
		double x = Math.random();
		double next = -(Math.log(x)/lamda);
        return (int)next;
	}

	public void setIsCleaned() {
		isCleaned = true;
	}

	public void run() {
		try {
			Thread.sleep(nextTime(this.lamdaArrival)*1000); // arrival
			ww.addToWaitingList(this);
			while(!this.isCleaned) {
				if(!(ww.isWasherAvailable() && ww.getWaitingList().get(0).getId() == this.id)) {
					synchronized (ww) {
						ww.wait();
					}
				} else {
					ww.removeFromWaitingList();
					ww.addToWashing(this);
					Thread.sleep(nextTime(lamdaWashing) * 1000); // washing
					ww.removeFromWashingList(this);
					synchronized (ww) {
						ww.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
