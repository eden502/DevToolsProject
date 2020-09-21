package pkg;

import java.time.LocalDateTime;
import java.util.Date;

public class Flight {
	
	
	private int fltNum;
	private String company;
	private String fltCode;
	private String APDest;// Airport Destination
	private String APOrigin;
	private String CTDest;// City Destination
	private String CTOrigin;
	private String CDest; //Country Destination
	private String COrigin;
	private double flightLength;
	private Date flightTime;
	public enum flightClass {Arrival, Departure};
	private flightClass type;
	
	
	public Flight(String code,int fltNum, String company, String APDest, String APOrigin, String CTDest, String CTOrigin, String CDest, String COrigin, Date flightTime) {
		this.fltNum = fltNum;
		this.company = company;
		this.APDest = APDest;
		this.APOrigin = APOrigin;
		this.CTDest = CTDest;
		this.CTOrigin = CTOrigin;
		this.CDest = CDest;
		this.COrigin = COrigin;
		this.flightTime = flightTime;
		if(COrigin.toUpperCase().equals("ISRAEL")) {
			type = flightClass.Departure;
		}else {
			type = flightClass.Arrival;
		}
		
		
	}
	public flightClass getType() {
		return type;
	}
	public Date getTime() {
		return flightTime;
	}
	public String getCOrigin() {
		return COrigin;
	}
	
	public String toString() {	
		
		return "|Flight num: "+fltNum+"||Carrier: "+company+"||Destination: "+APDest+","+CTDest+","+CDest+"||\n|Origin: "+APOrigin+","+CTOrigin+","+COrigin+"||\n|Time: "+flightTime; 
	}
	public int getNum() {
		return this.fltNum;
	}
	
	

}
