package vehicule;

import gestionParking.Constante;

public class Camion extends Vehicule {
	public Camion(String marqueV, String proprietaireV, String typeV, String numero_immat)
	{
		super(marqueV, proprietaireV, typeV, numero_immat);
		
		tarif = Constante.tarifCamion;
	} 
}
