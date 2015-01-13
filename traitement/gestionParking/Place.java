package gestionParking;

import véhicule.Vehicule;

public class Place {
	int numero;
	boolean estOccupée;
	String typePlace;
	Vehicule vehicule;

	public boolean getEstOccupée()
	{
		return this.estOccupée;
	}
	
	public String getType()
	{
		return typePlace;
	}

	public void setVehicule(Vehicule vehicule2) {
		vehicule = vehicule2;
		
	}

	public Vehicule getVehicule() {
		return vehicule;
	}
}


