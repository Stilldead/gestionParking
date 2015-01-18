package testGestionParking;

import static org.junit.Assert.*;

import org.junit.Test;

import vehicule.Vehicule;
import gestionParking.Parking;
import gestionParking.Place;

public class TestPark {

	@Test
	public void testPark1() throws Exception {
		Parking pk = new Parking(10);
		pk.initialiserListe();
		assertEquals(true, pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 5));	}
	
	@Test
	public void testPark2() throws Exception {
		Parking pk = new Parking(10);
		pk.initialiserListe();
		pk.getListePlace().get(9).setType("Transporteur");
		assertEquals(false, pk.park(new Vehicule("BMW", "Dupont", "Transporteur", "xx xxx xx"), 5));
		}
	
	@Test
	public void testPark3() throws Exception{
		Parking pk = new Parking(10);
		pk.initialiserListe();
		assertEquals(false, pk.park(new Vehicule("BMW", "Dupont", "Transporteur", "xx xxx xx"), 5));
		}
	
	@Test
	public void testPark4() throws Exception {
		Parking pk = new Parking(10);
		pk.initialiserListe();
		assertEquals(true, pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 11));
	}
}
