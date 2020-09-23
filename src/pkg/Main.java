package pkg;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import pkg.Flight.flightClass;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Airport AP = new Airport("TLV");
		Date d1 = new Date(2020, 9, 10, 10, 10);
		Date d2 = new Date(2020, 9, 10, 9, 10);
		Flight f1 = new Flight("TLV", 002, "Elal", "Shermetyevo", "Natbag", "Moscow", "Lod", "Russia", "Israel", d1);
		Flight f2 = new Flight("TLV", 001, "Elal", "afaf", "Natbag", "Moscow", "Lod", "Russia", "Israel", d2);
		AP.addFlight(f1);
		AP.addFlight(f2);
		System.out.println("Welcome to Natbag Flight Planner 2020");
		int choice = 0;
		
		do {
			showMenu();
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				
				String name, code, CTDest, CTOrigin, COrigin, CDest, APOrigin, APDest;
				int fltNum, month, day, year, time;
				System.out.println("Please enter carrier name: ");
				name = scan.next();
				System.out.println("Please enter flight number: ");
				fltNum = scan.nextInt();
				System.out.println("Please enter flight code(In letters): ");
				code = scan.next();
				System.out.println("Please enter country of origin: ");
				COrigin = scan.next();
				if(COrigin.toUpperCase()=="ISRAEL") {
					CTOrigin ="Tel Aviv";
					APOrigin = "Natbag";
				}else {
					System.out.println("Please enter city of origin: ");
					CTOrigin = scan.next();
					System.out.println("Please enter departure airport:");
					APOrigin = scan.next();
				}
				System.out.println("Please enter destination:\nCountry: ");
				CDest = scan.next();
				System.out.println("City: ");
				CTDest = scan.next();
				System.out.println("Airport: ");
				APDest = scan.next();

				Date fltDate = new Date();
				Date now = new Date(System.currentTimeMillis());
				do {
					fltDate = enterDatePrompt();
					if (fltDate.before(now)) {
						System.out.println("Please enter a valid date");
					}
				} while (fltDate.before(now));
				Flight flt = new Flight(code, fltNum, name, APDest, APOrigin, CTDest, CTOrigin, CDest, COrigin,
						fltDate);
				AP.addFlight(flt);
				
				break;
			case 2:
				System.out.println("Please choose category:\n1: Departures.\n2: Arrivals\n0: Cancel.");
				int deleteChoice = scan.nextInt();
				if (deleteChoice == 1) {
					System.out.println(AP.printDepartures());
					System.out.println("Please choose flight number to delete");
					AP.deleteDeparture(scan.nextInt());
				}
				if (deleteChoice == 2) {
					System.out.println(AP.printArrivals());
					System.out.println("Please choose flight number to delete");
					AP.deleteArrival(scan.nextInt());
				}

				break;
			case 3:
				System.out.println("Departures Schedule:\n" + AP.printDepartures());

				break;
			case 4:
				System.out.println("Arrivals Schedule:\n" + AP.printArrivals());
				break;
			case 5:
				System.out.println("Search by:\n1:Flight time\n2.Flight number\n3:Flight from");
				int searchChoice = scan.nextInt();
				if (searchChoice == 1) {
					System.out.println(AP.searchByTime(AP.getArrivals(), enterDatePrompt()));
				} else if (searchChoice == 2) {
					System.out.println("Please enter flight number:");
					System.out.println(AP.searchByFlightNumber(AP.getArrivals(), scan.nextInt()));
				} else {
					System.out.println("Please enter departure country:");
					System.out.println(AP.searchByCountry(AP.getArrivals(), scan.next()));
				}

				break;
			case 6:
				System.out.println("Search by:\n1:Flight time\n2.Flight number\n3:Flight from");
				searchChoice = scan.nextInt();
				if (searchChoice == 1) {
					System.out.println(AP.searchByTime(AP.getDepartures(), enterDatePrompt()));
				} else if (searchChoice == 2) {
					System.out.println("Please enter flight number:");
					System.out.println(AP.searchByFlightNumber(AP.getDepartures(), scan.nextInt()));
				} else {
					System.out.println("Please enter departure country:");
					System.out.println(AP.searchByCountry(AP.getDepartures(), scan.next()));
				}
				break;
			case 7:

				break;
			case 8:
				AP.exportToText();
				break;
			case 9:

				break;

			}
			
		} while (choice != 0);
		
		scan.close();
		
	}

	public static void showMenu() {

		System.out.println("Please choose from the following: ");
		System.out.println("1: Add Flight");
		System.out.println("2: Remove Flight");
		System.out.println("3: Departures Schedule");
		System.out.println("4: Arrivals Schedule");
		System.out.println("5: Search Arrivals");
		System.out.println("6: Search Departures");
		System.out.println("7: Read From File");
		System.out.println("8: Write To File");
		System.out.println("0: Exit");
	}

	public static Date enterDatePrompt() {
		Scanner scan = new Scanner(System.in);
		int year, month, day, hours,minutes;
		System.out.println("Please enter date: \nYear: ");
		year = scan.nextInt();
		System.out.println("Month: ");
		month = scan.nextInt();
		System.out.println("Day: ");
		day = scan.nextInt();
		System.out.println("Please enter flight hour");
		hours = scan.nextInt();
		System.out.println("Please enter flight minutes");
		minutes = scan.nextInt();
		Date fltDate = new Date(year, month-1, day, hours, minutes);
		return fltDate;
	}

}
