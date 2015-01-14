package testGestionParking;

import static org.junit.Assert.*;

import org.junit.Test;

import véhicule.Vehicule;
import gestionParking.Parking;

public class TestParking {

	@Test
	public void testPark1() {
		Parking pk = new Parking();
		assertEquals("false",pk.park(new Vehicule(), 5));
	}
	


	public final void testFindByType() throws Exception 
	{
        
	}
}
