package controleur;

import java.util.ArrayList;
import modele.ModeleIntervention;
 

public class C_Intervention {
	public static void insertIntervention (Intervention uneIntervention)
	{
		ModeleIntervention.insertIntervention(uneIntervention);
	}
	public static ArrayList<Intervention> listerInterventions ()
	{
		return  ModeleIntervention.selectAllInterventions();
	}
	public static void supprimerIntervention (int idIntervention )
	{
		ModeleIntervention.deleteIntervention(idIntervention);
	}
	public static void modifierIntervention (Intervention uneIntervention)
	{
		ModeleIntervention.updateIntervention(uneIntervention);
	}
	
}
