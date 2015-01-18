package gestionParking;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import exception.PlaceLibreException;
import exception.PlaceOccupeeException;
import exception.PlusAucunePlaceException;
import vehicule.Vehicule;

public class Parking {
	static int nombrePlace;
	static ArrayList<Place> listePlace = new ArrayList();
	static Parking INSTANCE = null;
	static int idFacture = 0;
	
	
	public static Parking getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new Parking(10);
		}
		return INSTANCE;
		
	}
	public Parking(int nbPlace)
	{
		nombrePlace = nbPlace;
	}
	
	public void initialiserListe()
	{
		for (int i = 0; i <= nombrePlace ; ++i)
		{
			listePlace.add(new Place(i, false, false, "Particulier", null));
		}
	}
	
	public ArrayList<Place> getListePlace()
	{
		return listePlace;
	}
	

	public boolean park(Vehicule vehicule, int numero_place)
	{
		if (listePlace.size() < numero_place)
			return false;
		try	
		{
			
			
			//Vérifie si la place est occupée et si c'est le bon type de place.
			if(listePlace.get(numero_place).getEstOccupee() || listePlace.get(numero_place).getType() != vehicule.getType())
			{
				int cpt = 0;
				//Si la place est occupée ou que ce n'est pas le bon type, cherche une place libre même chez les transporteurs.
				for (int i = 0 ; listePlace.size()<=i ; ++i)
				{
					if (listePlace.get(i).getType() == "Transporteur" && !(listePlace.get(i).getEstOccupee()))
						cpt++;
				}
				if (cpt!=0)
					throw new PlaceOccupeeException("Mauvais type ou place déjà prise.");
				
				return false;
			}
			//La place est libre et le vehicule est du bon type, on le place donc.
			listePlace.get(numero_place).setVehicule(vehicule);
			listePlace.get(numero_place).setEstOccupee(true);
			return true;			
			
		}
		catch(PlaceOccupeeException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

	public void etatParking () {
		for (int i = 0; i < listePlace.size(); ++i) {
			System.out.println("Place numero " + listePlace.get(i).getNumero() + " est de type " + listePlace.get(i).getType() + "." + "\n");
			if (listePlace.get(i).getEstOccupee()) {
				System.out.println("    La place est occupee par la voiture comportant les caracteristiques suivantes : " + "\n");
				System.out.println("    Plaque : " + 		listePlace.get(i).getVehicule().getNumeroImmatriculation() + 		
									"; marque : " + 		listePlace.get(i).getVehicule().getMarque() +
									"; Proprietaire : " + 	listePlace.get(i).getVehicule().getProprietaire() + "; type : " +
									 						listePlace.get(i).getVehicule().getType() + "\n");
			}
		}
	}
	
	public Place bookPlace (Vehicule vehicule) {
		try {
			if (vehicule.getType() == "Camion")
			{
				for (int i = 0;i <= listePlace.size() ; ++i) {
					
					if (listePlace.get(i).getEstReservee() == false && listePlace.get(i).getEstOccupee() == false) {
						listePlace.get(i).setEstReservee(true);
						listePlace.get(i).setVehicule(vehicule);
						return listePlace.get(0);
					}
				}
				throw new PlusAucunePlaceException("Plus aucune place Disponible.");
			}
			else
			{
				for (int i = 0;i <= listePlace.size() ; ++i) {
					
					if (listePlace.get(i).getEstReservee() == false && listePlace.get(i).getEstOccupee() == false && listePlace.get(i).getType() == "Particulier") {
						listePlace.get(i).setEstReservee(true);
						listePlace.get(i).setVehicule(vehicule);
						return listePlace.get(0);
					}
				}
				for (int i = 0;i <= listePlace.size() ; ++i) {
					
					if (listePlace.get(i).getEstReservee() == false && listePlace.get(i).getEstOccupee() == false && listePlace.get(i).getType() == "Transporteur") {
						listePlace.get(i).setEstReservee(true);
						listePlace.get(i).setVehicule(vehicule);
						return listePlace.get(0);
					}
				}
				throw new PlusAucunePlaceException("Plus aucune place Disponible.");
			}
		}
		
		catch(PlusAucunePlaceException e) {
			e.printStackTrace();
		}
		finally
		{
			return null;
		}
	}

	public Vehicule unpark(int numero_place){		
		Vehicule vehicule = listePlace.get(numero_place).getVehicule();
		try {
			if(vehiculeExiste(listePlace.get(numero_place).getVehicule()) && listePlace.get(numero_place).getEstOccupee()) 
			{
				listePlace.get(numero_place).setVehicule(null);
				facture(vehicule, numero_place);
				reorganiserPlaces (vehicule, numero_place);
				return vehicule;
			}
			else
				throw new PlaceLibreException("La place est vide");	
		}			
		catch (PlaceLibreException e){
			
			e.printStackTrace();
		}
		return null;
		
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
			if (listePlace.get(i).getVehicule() != null && listePlace.get(i).getVehicule().getNumeroImmatriculation() == plaque)
				return i;
		}
		return -1;
	}
		
	public Vehicule retirerVehicule(String numero_immatriculation){
		
		if (getLocation(numero_immatriculation) == -1)
			
			return null; 
		
		return unpark(getLocation(numero_immatriculation));	
	}
	
	public void reorganiserPlaces (Vehicule vehicule, int numero_place) {
		if(vehicule.getType() != "camion" && listePlace.get(numero_place).getType() == "particulier") {
			for (int i = 0; i < listePlace.size(); ++i) {
				if (listePlace.get(i).getType() == "transporteur" && listePlace.get(i).getVehicule().getType() != "camion") {
					park(listePlace.get(i).getVehicule(), numero_place);
					unpark(listePlace.get(i).getNumero());
				}
			}
		}
	}
	
	public void facture (Vehicule vehicule, int numero_place) {
		idFacture++;
		
		double facture = (Constante.tva / 100) * vehicule.getTarif() + vehicule.getTarif();
		
		try{
			File factureTexte = new File("facture/facture_" + Integer.toString(idFacture) + ".txt");
			factureTexte.createNewFile();
			FileWriter ffw = new FileWriter(factureTexte);
			ffw.write("Facture " + Integer.toString(idFacture) + "\n\n");
			ffw.write("Numero de place : " + Integer.toString(numero_place) + "\n");
			ffw.write("Type de place : " + listePlace.get(numero_place).getType() + "\n");
			ffw.write("Prix HT : " + Double.toString(vehicule.getTarif()) + "\n");
			ffw.write("Prix TTC : " + Double.toString(facture) + "\n\n");
			ffw.write("Nous vous remercions de votre visite! A bientot!");
			ffw.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
