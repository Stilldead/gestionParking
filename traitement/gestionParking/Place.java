package gestionParking;

import exception.PlaceDisponibleException;
import véhicule.Vehicule;

public class Place {
	int numero;
	boolean estReservee;
	boolean estOccupee;
	String typePlace;
	Vehicule vehicule;

	public boolean getEstOccupee()
	{
		return this.estOccupee;
	}
	
	public String getType()
	{
		return typePlace;
	}

	public int getNumero(){
		
		return numero;
		
	}
	
	public void setVehicule(Vehicule vehicule2) {
		vehicule = vehicule2;
		
	}

	public Vehicule getVehicule() {
		return vehicule;
	}
		
	public void setEstReservee(boolean reserv){
		
		estReservee = reserv;
		
	}
	
	public void freePlace (Place place){
		
		try {
			
			if(place.estReservee){
				
				place.setEstReservee(false);
				
			}
			
			throw new PlaceDisponibleException("Place disponible");
			
		}
		catch (PlaceDisponibleException e){
			
			e.printStackTrace();
			
		}
	}

	public boolean getEstReservee() {
		return estReservee;
	}	
}
