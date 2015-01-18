package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;

import org.junit.Test;

import vehicule.Vehicule;

public class TestRetirerVehicule {

	@Test
	public final void testRetirerVehicule1() throws Exception 
	{
		Parking pk = new Parking(10);
		pk.initialiserListe();
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 5);
		assertEquals(true, pk.retirerVehicule("xx xxx xx"));
	}
	
	@Test
	public final void testRetirerVehicule2() throws Exception 
	{
		Parking pk = new Parking(10);
		pk.initialiserListe();
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 5);
		assertEquals(null, pk.retirerVehicule("xx xyx xx"));
	}

}
