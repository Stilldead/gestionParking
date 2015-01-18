package vehicule;

import gestionParking.Constante;

public class Voiture extends Vehicule {
	public Voiture(String marqueV, String proprietaireV, String typeV, String numero_immat)
	{
		super(marqueV, proprietaireV, typeV, numero_immat);
		
		tarif = Constante.tarifVoiture;
	} 
}
