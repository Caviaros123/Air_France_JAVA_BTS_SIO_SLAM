package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient {
	//instanciation de la classe BDD 
	private static Bdd uneBdd = new Bdd ("localhost:8889","orange_Event_LM_23","root","root");
	
	public static void insertClient(Client unClient)
	{
		String requete ="insert into client values (null, '"
				+ unClient.getNom() + "','" + unClient.getPrenom() + "','"
				+ unClient.getEmail()+ "','" + unClient.getAdresse() + "','"
				+ unClient.getTel() + "'); ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution  : " + requete);
		}
	}
	
	public static ArrayList<Client> selectAllClients (String mot)
	{
		String requete=""; 
		if (mot.equals("")) {
			requete ="select * from client ;" ;
		}else {
			requete ="select * from client where nom like '%"
					+ mot + "%' or prenom like '%"
					+ mot + "%' or adresse like '%"
					+ mot + "%' or email like '%"
					+ mot + "%' or tel like '%"
					+ mot + "%' ; "; 
		}
		ArrayList<Client> lesClients = new ArrayList<Client>(); 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//parcourir les resultats et construire des objets clients
			while(desResultats.next()) {
				Client unClient = new Client(
						desResultats.getInt("idclient"),
						desResultats.getString("nom"), 
						desResultats.getString("prenom"),
						desResultats.getString("email"),
						desResultats.getString("adresse"),
						desResultats.getString("tel")
						);
				//on l'ajoute dans l'ArrayList
				lesClients.add(unClient); 
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution  : " + requete);
		}
		return lesClients; 
	}
	public static void deleteClient(int idclient)
	{
		String requete ="delete from client where idclient = " + idclient + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution  : " + requete);
		}
	}
	public static void updateClient(Client unClient)
	{
		String requete ="update client set nom = '"
				+ unClient.getNom() + "', prenom = '" + unClient.getPrenom() + "', email='"
				+ unClient.getEmail()+ "', adresse='" + unClient.getAdresse() + "', tel='"
				+ unClient.getTel() + "' where idclient = "+unClient.getIdclient()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution  : " + requete);
		}
	}
	public static Client selectWhereClient (int idclient)
	{
		Client unClient = null;
		String requete ="select * from client where idclient = "+idclient+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete); 
		 
			if(unResultat.next()) {
				 unClient = new Client(
						unResultat.getInt("idclient"),
						unResultat.getString("nom"), 
						unResultat.getString("prenom"),
						unResultat.getString("email"),
						unResultat.getString("adresse"),
						unResultat.getString("tel")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution  : " + requete);
		}
		return unClient ;
	}
	public static Client selectWhereClient (String email)
	{
		Client unClient = null;
		String requete ="select * from client where email ='"+email+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete); 
		 
			if(unResultat.next()) {
				 unClient = new Client(
						unResultat.getInt("idclient"),
						unResultat.getString("nom"), 
						unResultat.getString("prenom"),
						unResultat.getString("email"),
						unResultat.getString("adresse"),
						unResultat.getString("tel")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution  : " + requete);
		}
		return unClient ;
	}
}





















