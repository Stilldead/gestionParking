package gestionParking;

import java.util.ArrayList;

import exception.PlaceOccupeeException;
import véhicule.Vehicule;

public class Parking {
	
	ArrayList<Place> listePlace = new ArrayList();

	public boolean vehiculeExiste(){
		
		
		return true;
		
	}

	public boolean park(Vehicule vehicule, int numero_place)
	{
		try	
		{
			if(listePlace.get(numero_place -1).getEstOccupée() || listePlace.get(numero_place -1).getType() != vehicule.getType())
				throw new PlaceOccupeeException("Mauvais type ou place déjà prise.");
			
						
			listePlace.get(numero_place -1).setVehicule(vehicule);
		}
		catch(PlaceOccupeeException e)
		{
			
		}
		return false;
		
	}
	
	public boolean vehiculeExiste(Vehicule vehicule){
		
		for (int i =0 ;i < listePlace.size() ; ++i)
		{
		if(listePlace.get(i).getVehicule() == vehicule)
			return true;
		
		}
		return false;
	}
	
}
