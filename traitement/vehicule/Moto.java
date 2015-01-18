package vehicule;

import gestionParking.Constante;

public class Moto extends Vehicule {
	public Moto(String marqueV, String proprietaireV, String typeV, String numero_immat)
	{
		super(marqueV, proprietaireV, typeV, numero_immat);
		
		tarif = Constante.tarifMoto;
	} 
}
