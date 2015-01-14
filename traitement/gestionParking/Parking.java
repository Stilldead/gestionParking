package gestionParking;

import java.util.ArrayList;
import java.util.Scanner;

import exception.PlaceLibreException;
import exception.PlaceOccupeeException;
import exception.PlusAucunePlaceException;
import véhicule.Vehicule;

public class Parking {
	
	ArrayList<Place> listePlace = new ArrayList();

	public boolean vehiculeExiste(){
		
		
		return true;
		
	}
	
	public void intialiserListeTest()
	{
		listePlace.add(new Place());
	}
	
	public ArrayList<Place> getListePlace()
	{
		return listePlace;
	}
	

	public boolean park(Vehicule vehicule, int numero_place)
	{
		try	
		{
			if(listePlace.get(numero_place).getEstOccupee() || listePlace.get(numero_place).getType() != vehicule.getType())
			{
				int cpt = 0;
				for (int i = 0 ; listePlace.size()<=i ; ++i)
				{
					if (listePlace.get(i).getType() == "Transporteur" && !listePlace.get(i).getEstOccupee())
						cpt++;
				}
				if(cpt!=0)
					throw new PlaceOccupeeException("Mauvais type ou place déjà prise.");
			}
			
			listePlace.get(numero_place -1).setVehicule(vehicule);
		}
		catch(PlaceOccupeeException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

	public void etatParking () {
		for (int i = 0; i < listePlace.size(); ++i) {
			System.out.println("Place numero " + listePlace.get(i).getNumero() + " et de type " + listePlace.get(i).getType() + "." + "\n");
			if (listePlace.get(i).getEstOccupee()) {
				System.out.println("    La place est occupee par la voiture comportant les caracteristiques suivantes : " + "\n");
				System.out.println("    Plaque : " + 		listePlace.get(i).getVehicule().getNumeroImmatriculation() + 		
									"; marque : " + 		listePlace.get(i).getVehicule().getMarque() +
									"; Proprietaire : " + 	listePlace.get(i).getVehicule().getProprietaire() + "; type : " +
									 						listePlace.get(i).getVehicule().getType() + "\n");
			}
		}
	}
	
	public Place bookPlace () {
		try {
			for (int i = 0; i < listePlace.size(); ++i) {
				if (listePlace.get(i).getEstReservee() == false && listePlace.get(i).getEstOccupee() == false) {
					listePlace.get(i).setEstReservee(true);
					return listePlace.get(i);
				}
			}
			
			throw new PlusAucunePlaceException("");
		}
		
		catch(PlusAucunePlaceException e) {
			e.printStackTrace();
		} return null;
	}

	public Vehicule unpark(int numero_place){
		
		Vehicule vehicule = listePlace.get(numero_place).getVehicule();
		
		try {
	
			System.out.println("Selectionner la place de la voiture à unpark");
								
			if(numero_place == listePlace.size() && vehiculeExiste() && listePlace.get(numero_place).getEstOccupee()) 
				listePlace.get(numero_place).setVehicule(null);					
			
			throw new PlaceLibreException("La place est vide");	
							
		}			
		catch (PlaceLibreException e){
			
			e.printStackTrace();
		}
		return vehicule;
		
	}
	
	public boolean vehiculeExiste(Vehicule vehicule){
		
		for (int i =0 ;i < listePlace.size() ; ++i)
		{
		if(listePlace.get(i).getVehicule() == vehicule)
			return true;
		
		}
		return false;
	}

	public int getLocation (String plaque) {
		
		for (int i = 0; i < listePlace.size(); ++i) {
			if (listePlace.get(i).getVehicule().getNumeroImmatriculation() == plaque)
				return i;
		}
		return -1;
	}
		
	public Vehicule retirerVehicule(String numero_immatriculation){
		
		if (getLocation(numero_immatriculation) == -1)
			
			return null; 
		
		return unpark(getLocation(numero_immatriculation));	
	}
	
}
