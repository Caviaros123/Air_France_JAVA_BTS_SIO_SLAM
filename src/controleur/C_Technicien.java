package controleur;

import java.util.ArrayList;

import modele.ModeleTechnicien;


public class C_Technicien {
	public static void insertTechnicien (Technicien unTechnicien)
	{
		ModeleTechnicien.insertTechnicien(unTechnicien);
	}
	public static ArrayList<Technicien> listerTechniciens ()
	{
		return  ModeleTechnicien.selectAllTechniciens();
	}
	public static void deleteTechnicien (int idTechnicien )
	{
		ModeleTechnicien.deleteTechnicien(idTechnicien);
	}
	public static void updateTechnicien (Technicien unTechnicien)
	{
		ModeleTechnicien.updateTechnicien(unTechnicien);
	}
	public static Technicien selectWhereTechnicien (String email, String mdp)
	{
		return ModeleTechnicien.selectWhereTechnicien(email, mdp);
	}
	
 
}
