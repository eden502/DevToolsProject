package pkg;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Airport AP = new Airport("TLV");
		int choice;
		do {
			showMenu();
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				String name, code, CTDest, CTOrigin, COrigin, CDest,APOrigin,APDest;
				int fltNum, month, day, year, time;
				System.out.println("Please enter carrier name: ");
				name = scan.next();
				System.out.println("Please enter flight number: ");
				fltNum = scan.nextInt();
				System.out.println("Please enter flight code: ");
				code = scan.next();
				System.out.println("Please enter country of origin: ");
				COrigin = scan.next();
				System.out.println("Please enter city of origin: ");
				CTOrigin = scan.next();
				System.out.println("Please enter departure airport:");
				APOrigin = scan.next();
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
				Flight flt = new Flight(code,fltNum, name, APDest, APOrigin, CTDest, CTOrigin, CDest, COrigin,fltDate);
				break;
			case 2:
				System.out.println("Please choose category:\n1: Departures.\n2: Arrivals\n0: Cancel.");
				int deleteChoice = scan.nextInt();
				if(deleteChoice==1) {
					System.out.println(AP.getDepartures().toString());
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;

			}
		} while (choice != 0);

		scan.close();
	}

	public static void showMenu() {
		System.out.println("Welcome to Natbag Flight Planner 2020");
		System.out.println("Please choose from the following: ");
		System.out.println("1: Add Flight");
		System.out.println("2: Remove Flight");
		System.out.println("3: Departures Schedule");
		System.out.println("4: Arrivals Schedule");
		System.out.println("5: Search Arrivals");
		System.out.println("6: Seartch Departures");
		System.out.println("7: Read From File");
		System.out.println("8: Write To File");
		System.out.println("0: Exit");
	}

	public static Date enterDatePrompt() {
		Scanner scan = new Scanner(System.in);
		int year, month, day, time;
		System.out.println("Please enter date: \nYear: ");
		year = scan.nextInt();
		System.out.println("Month: ");
		month = scan.nextInt();
		System.out.println("Day: ");
		day = scan.nextInt();
		System.out.println("Please enter time of flight in ZULU format (i.e 0700 for 7AM)");
		time = scan.nextInt();
		Date fltDate = new Date(year, month, day, time / 100, time % 100);
		return fltDate;
	}
}
