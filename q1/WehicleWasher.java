/*
 * Cindy Zilberman - 316268150
 * Fany Manevich - 206116725
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class WehicleWasher extends Thread{
	private long startingTime;
	private ArrayList<Wehicle> waitingList;
	private ArrayList<Wehicle> washing;
	
	private ArrayList<Car> cars;
	private ArrayList<SUV> suvs;
	private ArrayList<Truck> trucks;
	private ArrayList<MiniBus> minibuses;
	
	private int numberOfWashers;

	private int carCounter;
	private int suvCounter;
	private int miniBusCounter;
	private int truckCounter;
	private long carStartingWaitingTime;
	private long suvStartingWaitingTime;
	private long miniBusStartingWaitingTime;
	private long truckStartingWaitingTime;
	private long carTotalWaitingTime;
	private long suvTotalWaitingTime;
	private long miniBusTotalWaitingTime;
	private long truckTotalWaitingTime;
	FileWriter combined_file;
	PrintWriter pw;
	
	WehicleWasher(int N, long startingTimeInMs){
		startingTime = startingTimeInMs;
		waitingList = new ArrayList<>();
		washing = new ArrayList<>();		
		cars = new ArrayList<>();
		suvs = new ArrayList<>();
		trucks = new ArrayList<>();
		minibuses = new ArrayList<>();
		carCounter = 0;
		suvCounter = 0;
		miniBusCounter = 0;
		truckCounter = 0;
		numberOfWashers = N;
		
		try {
			 combined_file = new FileWriter("log.txt"); 
			 pw = new PrintWriter(combined_file);
		}
		catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
	public synchronized void addToWaitingList(Wehicle w) {
		System.out.println("----------------------------------------------------------------------------------");
		pw.print("----------------------------------------------------------------------------------" + '\n');
		System.out.println("Wehicle Arrived to the washing center");
		pw.print("Wehicle Arrived to the washing center"+ '\n');
		System.out.println("Time from start: " + ((System.currentTimeMillis() - this.startingTime)/1000) + " seconds");
		pw.print("Time from start: " + ((System.currentTimeMillis() - this.startingTime)/1000) + " seconds"+ '\n');
		System.out.println(w.getClass().getSimpleName() + " " + w.getId());
		pw.print(w.getClass().getSimpleName() + " " + w.getId()+ '\n');
		waitingList.add(w);
		if(w instanceof Car) {
			carCounter++;
			carStartingWaitingTime = System.currentTimeMillis();
		} else if(w instanceof SUV) {
			suvCounter++;
			suvStartingWaitingTime = System.currentTimeMillis();
		} else if(w instanceof Truck) {
			truckCounter++;
			truckStartingWaitingTime = System.currentTimeMillis();
		} else {
			miniBusCounter++;
			miniBusStartingWaitingTime = System.currentTimeMillis();
		}
	}
	
	public synchronized void removeFromWaitingList() {
		Wehicle removedWehicle = waitingList.remove(0);
	}
	
	public synchronized void addToWashing(Wehicle w) {
		washing.add(w);
		System.out.println("----------------------------------------------------------------------------------");
		pw.print("----------------------------------------------------------------------------------" + '\n');
		System.out.println("Wehicle enter to washing machine");
		pw.print("Wehicle enter to washing machine" + '\n');
		System.out.println("Time from start: " + ((System.currentTimeMillis() - this.startingTime)/1000) + " seconds");
		pw.print("Time from start: " + ((System.currentTimeMillis() - this.startingTime)/1000) + " seconds" + '\n');
		System.out.println(w.getClass().getSimpleName() + " " + w.getId());
		pw.print(w.getClass().getSimpleName() + " " + w.getId() + '\n');
		if(w instanceof Car)
			carTotalWaitingTime += ((System.currentTimeMillis() - this.carStartingWaitingTime)/1000);
		else if(w instanceof SUV)
			suvTotalWaitingTime += ((System.currentTimeMillis() - this.suvStartingWaitingTime)/1000);
		else if(w instanceof Truck)
			truckTotalWaitingTime += ((System.currentTimeMillis() - this.truckStartingWaitingTime)/1000);
		else
			miniBusTotalWaitingTime += ((System.currentTimeMillis() - this.miniBusStartingWaitingTime)/1000);
	}
	
	public synchronized void removeFromWashingList(Wehicle w) {
		for(int i = 0; i < washing.size(); i++) {
			if(washing.get(i).getId() == w.getId()) {
				addToRelevantWehicleList(washing.remove(i));
				System.out.println("----------------------------------------------------------------------------------");
				pw.print("----------------------------------------------------------------------------------" + '\n');
				System.out.println("Washing done, good bye");
				pw.print("Washing done, good bye" + '\n');
				System.out.println("Time from start: " + ((System.currentTimeMillis()- this.startingTime)/1000) + " seconds");
				pw.print("Time from start: " + ((System.currentTimeMillis()- this.startingTime)/1000) + " seconds" + '\n');
				System.out.println(w.getClass().getSimpleName() + " " + w.getId());
				pw.print(w.getClass().getSimpleName() + " " + w.getId() + '\n');
				w.setIsCleaned();
				break;
			}
		}
		addToRelevantWehicleList(w);
		if(washing.size() == 0 && waitingList.size() == 0) {
			printAvgWaitingTimePerWehicle();
		}
	}
	private void addToRelevantWehicleList(Wehicle w) {
		if(w instanceof Car)
			cars.add((Car)w);
		else if(w instanceof SUV)
			suvs.add((SUV)w);
		else if(w instanceof Truck)
			trucks.add((Truck)w);
		else
			minibuses.add((MiniBus)w);
	}
	
	public synchronized boolean isWasherAvailable() {
		return washing.size()<numberOfWashers;
	}
	
	public synchronized ArrayList<Wehicle> getWaitingList() {
		return this.waitingList;
	}

	public void printAvgWaitingTimePerWehicle() {
		System.out.println("----------------------------------------------------------------------------------");
		pw.print("----------------------------------------------------------------------------------" + '\n');
		if(carCounter > 0) {
			System.out.println("Car average time is: " + (carTotalWaitingTime/carCounter));
			pw.print("Car average time is: " + (carTotalWaitingTime/carCounter) + '\n');
		}
		else {
			System.out.println("0 Cars washed today");
			pw.print("0 Cars washed today" + '\n');
		}
		if(suvCounter > 0) {
			System.out.println("SUV average time is: " + (suvTotalWaitingTime/suvCounter));
			pw.print("SUV average time is: " + (suvTotalWaitingTime/suvCounter) + '\n');
		}
		else {
			System.out.println("0 SUV washed today");
			pw.print("0 SUV washed today" + '\n');
		}
		if(truckCounter > 0) {
			System.out.println("Truck average time is: " + (truckTotalWaitingTime/truckCounter));
			pw.print("Truck average time is: " + (truckTotalWaitingTime/truckCounter) + '\n');
		}
		else {
			System.out.println("0 Truck washed today");
			pw.print("0 Truck washed today" + '\n');
		}
		if(miniBusCounter > 0) {
			System.out.println("Mini bus average time is: " + (miniBusTotalWaitingTime/miniBusCounter));
			pw.print("Mini bus average time is: " + (miniBusTotalWaitingTime/miniBusCounter) + '\n');
		}
		else {
			System.out.println("0 Mini bus washed today");
			pw.print("0 Mini bus washed today" + '\n');
		}
		pw.close();
	}
}
