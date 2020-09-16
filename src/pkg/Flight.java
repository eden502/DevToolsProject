package pkg;

import java.time.LocalDateTime;

public class Flight {
	
	
	private int tailNum;
	private String company;
	private String APDest;
	private String APOrigin;
	private String CTDest;
	private String CTOrigin;
	private String CDest;
	private String COrigin;
	private double flightLength;
	private LocalDateTime flightTime;
	public enum flightClass {Arrival, Departure};
	private flightClass type;
	
	
	public Flight(int tailNum, String company, String APDest, String APOrigin, String CTDest, String CTOrigin, String CDest, String COrigin, LocalDateTime flightTime, flightClass type) {
		this.tailNum = tailNum;
		this.company = company;
		this.APDest = APDest;
		this.APOrigin = APOrigin;
		this.CTDest = CTDest;
		this.CTOrigin = CTOrigin;
		this.CDest = CDest;
		this.COrigin = COrigin;
		this.flightTime = flightTime;
		this.type = type;
		
		
	}
	
	

}
