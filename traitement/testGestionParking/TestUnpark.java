package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;
import org.junit.Test;

import vehicule.Vehicule;

public class TestUnpark {
	@Test
	public void testUnPark1() throws Exception {
		Parking pk = new Parking(10);
		pk.initialiserListe();
		Vehicule vehicule = new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx");
		pk.park(vehicule, 5);
		assertEquals(vehicule, pk.unpark(5));
	}
	
	@Test
	public void testUnPark2() throws Exception {
		Parking pk = new Parking(10);
		pk.initialiserListe();
		Vehicule vehicule = new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx");
		pk.park(vehicule, 5);
		assertEquals(null, pk.unpark(4));
	}

}
