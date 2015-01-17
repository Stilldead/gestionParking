package vehicule;

public class Vehicule {

	String marque, proprietaire, type, numero_immatriculation;
	
	public Vehicule(String marqueV, String proprietaireV, String typeV, String numero_immat)
	{
		marque = marqueV;
		proprietaire = proprietaireV;
		type = typeV;
		numero_immatriculation = numero_immat;
	} 
	
	public String getNumeroImmatriculation() {
		return numero_immatriculation;
	}
	
	public String getMarque() {
		return marque;
	}
	
	public String getProprietaire() {
		return proprietaire;
	}
	
	public String getType()
	{
		return type;
	}
}
