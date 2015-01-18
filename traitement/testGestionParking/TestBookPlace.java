package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;
import gestionParking.Place;

import org.junit.Test;

import vehicule.Vehicule;

public class TestBookPlace {

	@Test
	public final void testBookPlace1() throws Exception 
	{
		Parking pk = new Parking(1);
		pk.initialiserListe();
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 0);
		Vehicule vehicule = new Vehicule("BMW", "Toto", "Particulier", "xx xxy xx");
		assertEquals(null, pk.bookPlace(vehicule));
	}
	
}
