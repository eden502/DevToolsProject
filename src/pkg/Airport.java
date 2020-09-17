package pkg;

import java.util.Vector;

import pkg.Flight.flightClass;

public class Airport {
	
	private String name;
	private String city;
	private int numOfFlights;
	private final String airportCode = "TLV";
	private Vector arrivals;
	private Vector departures;
	
	
	
	
	
	
	
	public Airport(String code) {
		
		arrivals = new Vector();
		departures = new Vector();
		name = code;
	}
	
	public boolean addFlight(Flight newF) {	
		if(newF.getType().toString().equals("Arrivals")) {
			if(!arrivals.contains(newF)) {
				arrivals.add(newF);
				System.out.println("Flight added succesfuly");
				return true;
			}
		}
		if(newF.getType().toString().equals("Departures")) {
			if(!departures.contains(newF)) {
				departures.add(newF);
				System.out.println("Flight added succesfuly");
				return true;
			}
		}
		System.out.println("Flight already exists.");
		return false;
	}
	public Flight getFlight(int num) {
		
	}

	public Vector getDepartures() {
			
		return departures;
	}
 
}
