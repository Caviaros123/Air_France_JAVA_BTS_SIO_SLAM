package controleur;

import vue.VueConnexion;
import vue.VueGenerale;

public class OrangeEvent {
	
	private static VueConnexion uneVueConnexion; 
	private static VueGenerale uneVueGenerale ; 
	
	public static void main (String args[])
	{
		//instanciation de la vue connexion 
		uneVueConnexion = new VueConnexion(); 
		
	}
	
	public static void rendreVisibleVueConnexion (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
	public static void rendreVisibleVueGenerale (boolean action, Technicien unTechnicien)
	{
		if( unTechnicien == null)
		{
			uneVueGenerale.dispose();
		}else {
		uneVueGenerale = new VueGenerale(unTechnicien); 
		uneVueGenerale.setVisible(action);
		}
	}
}
