package testGestionParking;

import static org.junit.Assert.*;
import gestionParking.Parking;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vehicule.Vehicule;

public class TestReorganiserPlace {
	
	@Test
	public final void testRetirerVehicule1() throws Exception 
	{
		Parking pk = new Parking(2);
		pk.intialiserListe();
		pk.getListePlace().get(1).setType("Transporteur");
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xxx xx"), 0);
		pk.park(new Vehicule("BMW", "Dupont", "Particulier", "xx xyx xx"), 1);
		assertEquals(pk.getListePlace().get(1).getEstOccupee() == false, pk.unpark(0));
	}

}
