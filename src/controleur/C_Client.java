package controleur;

import java.util.ArrayList;

import modele.ModeleClient;


public class C_Client {
	public static void insertClient (Client unClient)
	{
		ModeleClient.insertClient(unClient);
	}
	
	public static ArrayList<Client> listerClients (String mot )
	{
		return  ModeleClient.selectAllClients(mot);
	}
	
	public static void supprimerClient (int idclient)
	{
		ModeleClient.deleteClient(idclient);
	}
	
	public static void modifierClient (Client unClient)
	{
		ModeleClient.updateClient(unClient); 
	}
	
	public static Client selectWhereClient(String email)
	{
		return ModeleClient.selectWhereClient(email); 
	}
}
