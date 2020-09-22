package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;

import pkg.Flight.flightClass;

public class Airport {

	private String name;
	private String city;
	private int numOfFlights;
	private final String airportCode = "TLV";
	private Vector <Flight> arrivals;
	private Vector <Flight> departures;

	public Airport(String code) {

		arrivals = new Vector();
		departures = new Vector();
		name = code;
	}

	public boolean addFlight(Flight newF) {
		if (newF.getType()==flightClass.Arrival) {
			if (!arrivals.contains(newF)) {
				arrivals.add(newF);
				System.out.println("Arrival added succesfuly");
				sortByTime(arrivals);
				return true;
			}
		}
		if (newF.getType()==flightClass.Departure) {
			if (!departures.contains(newF)) {
				departures.add(newF);
				System.out.println("Departure added succesfuly");
				sortByTime(departures);
				return true;
			}
		}
		System.out.println("Flight already exists.");
		return false;
	}

	private void sortByTime(Vector<Flight> v1) {
		if (v1.size() >= 2) {
			for (int i = 0; i < v1.size()-1; i++) {
				if (v1.get(i + 1).getTime().before(v1.get(i).getTime())) {
					Flight temp = v1.get(i);
					v1.set(i, v1.get(i + 1));
					v1.set(i + 1, temp);
				}
			}
		}
	}


	public StringBuffer printDepartures() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < departures.size(); i++) {
			str.append((i + 1) + "." + departures.get(i)+"\n");
		}

		return str;
	}

	public void deleteDeparture(int nextInt) {
		try {
			departures.remove(nextInt - 1);
		} catch (Exception e) {
			System.out.println("Please use a number from the list");
		}

	}

	public void deleteArrival(int nextInt) {
		try {
			arrivals.remove(nextInt - 1);
		} catch (Exception e) {
			System.out.println("Please use a number from the list");
		}
	}

	public StringBuffer printArrivals() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < arrivals.size(); i++) {
			str.append((i + 1) + "." + arrivals.get(i)+"\n");
		}
		return str;
	}
	public Vector getArrivals() {
		return this.arrivals;
	}
	public Vector getDepartures() {
		return this.departures;
	}

	public String searchByTime(Vector <Flight> v1, Date date) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < v1.size(); i++) {
			if(v1.get(i).getTime().equals(date)) {
				str.append((i+1)+"."+v1.get(i)+"\n");
			}
		}
		
		return str+"";
	}

	public String searchByFlightNumber(Vector<Flight> v1, int num) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < v1.size(); i++) {
			if(v1.get(i).getNum()==num) {
				str.append((i+1)+"."+v1.get(i)+"\n");
			}
			
		}
		return str+"";
	}

	public String searchByCountry(Vector <Flight> v1, String ctry) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < v1.size(); i++) {
			if(v1.get(i).getCOrigin().equalsIgnoreCase(ctry)) {
				str.append((i+1)+"."+v1.get(i)+"\n");
			}
			
		}
		return str+"";
	}

	public void exportToText() {
		File f = new File ("NatbagExport.txt");
		try {
			PrintWriter pw = new PrintWriter(f);
			for (int i = 0; i < arrivals.size(); i++) {
				pw.write(arrivals.get(i).getExport()+"\n");
			}
			for (int i = 0; i < departures.size(); i++) {
				pw.write(departures.get(i).getExport()+"\n");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
