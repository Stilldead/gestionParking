package testGestionParking;

import static org.junit.Assert.*;

import org.junit.Test;

import véhicule.Vehicule;
import gestionParking.Parking;
import gestionParking.Place;

public class TestParking {

	@Test
	public void testPark1() throws Exception {
		Parking pk = new Parking(10);
		pk.intialiserListe();
		assertEquals(true, pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 5));
	}
	
	@Test
	public void testPark2() throws Exception {
		Parking pk = new Parking(10);
		pk.intialiserListe();
		pk.getListePlace().get(9).setType("Transporteur");
		assertEquals(false, pk.park(new Vehicule("BMW", "Dupont", "Transporteur", "xx xxx xx"), 5));
	}
	
	@Test
	public void testPark3() throws Exception{
		Parking pk = new Parking(10);
		pk.intialiserListe();
		assertEquals(false, pk.park(new Vehicule("BMW", "Dupont", "Transporteur", "xx xxx xx"), 5));
	}


	public final void testFindByType() throws Exception 
	{
        
	}
}
