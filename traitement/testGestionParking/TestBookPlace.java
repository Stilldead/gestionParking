package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;
import org.junit.Test;

import vehicule.Vehicule;

public class TestBookPlace {

	@Test
	public final void testBookPlace1() throws Exception 
	{
		Parking pk = new Parking(1);
		pk.intialiserListe();
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 0);
		assertEquals(null, pk.bookPlace());
	}

}
