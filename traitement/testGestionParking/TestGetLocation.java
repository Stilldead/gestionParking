package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;
import org.junit.Test;

import vehicule.Vehicule;

public class TestGetLocation {

	@Test
	public final void testGetLocation1() throws Exception 
	{
		Parking pk = new Parking(10);
		pk.intialiserListe();
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 5);
		assertEquals(5, pk.getLocation("xx xxx xx"));
	}
	
	@Test
	public final void testGetLocation2() throws Exception 
	{
		Parking pk = new Parking(10);
		pk.intialiserListe();
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 5);
		assertEquals(-1, pk.getLocation("xx xyx xx"));
	}

}
