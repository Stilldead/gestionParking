package fichier;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LecteurFichier {
	public String getMessage(String idMessage)
	{
		String chaine="";
		String fichier ="fichiertexte.txt";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				for (int i = 0; ligne.length() < i; ++i)
				{
					String id;
					if(ligne.charAt(i) == (' ') && ligne.charAt(i+1) == ('=') && ligne.charAt(i+2) == (' '))
					{
						return getMessage(i+3, ligne);						
					}
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}	
		return null;
	}
	
	private String getMessage(int index, String string)
	{
		String message ="";
		for (int i = index; string.length() <i; ++i)
		{
			message += string.charAt(i);
		}
		return message;
	}
	
}
