package pkg;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import pkg.Flight.flightClass;

class Tester {
	static Flight f1;
	static Date d1;
	static Airport a1;
	
	@BeforeEach
	void build() throws Exception{
		 d1 = new Date(2020, 10, 10, 10, 10);
		 f1 = new Flight("TLV",1,"Elal","Newark","Natbag","New York","Lod","USA","Israel",d1);
		 a1 = new Airport("Natbag");
		 a1.addFlight(f1);
	}
	
	
	
	@org.junit.jupiter.api.Test
	void testFlightType() throws Exception{
		flightClass expected = flightClass.Departure;
		flightClass actual = f1.getType();
		assertEquals(expected, actual);
		
	}
	
	@org.junit.jupiter.api.Test
	void testAirport() throws Exception{
		int expected = 1;
		int actual = a1.getDepartures().size();
		assertEquals(expected, actual);
		
		
	}
	

}
