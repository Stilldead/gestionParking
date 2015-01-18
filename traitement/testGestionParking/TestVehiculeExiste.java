package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;
import org.junit.Test;

import vehicule.Vehicule;

public class TestVehiculeExiste {

	@Test
	public void testVehiculeExiste1() throws Exception {
		Parking pk = new Parking(10);
		pk.intialiserListe();
		Vehicule vehicule = new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx");
		pk.park(vehicule, 8);
		assertEquals(true, pk.vehiculeExiste(vehicule));
	}
	
	@Test
	public void testVehiculeExiste2() throws Exception {
		Parking pk = new Parking(10);
		pk.intialiserListe();
		Vehicule vehicule1 = new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx");
		Vehicule vehicule2 = new Vehicule("BMW", "Toto", "Particulier", "xx xyx xx");
		pk.park(vehicule1, 8);
		assertEquals(false, pk.vehiculeExiste(vehicule2));
	}

}
