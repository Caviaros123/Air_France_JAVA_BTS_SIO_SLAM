package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	private Object donnees[][] ; 
	private String entetes [];
	
	public Tableau(Object[][] donnees, String[] entetes) {
		super();
		this.donnees = donnees;
		this.entetes = entetes;
	}
	
	public Object[][] getDonnees() {
		return donnees;
	}
	public void setDonnees(Object[][] donnees) {
		this.donnees = donnees;
		this.fireTableDataChanged();
	}
	public String[] getEntetes() {
		return entetes;
	}
	public void setEntetes(String[] entetes) {
		this.entetes = entetes;
	}

	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public int getColumnCount() {
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int numLigne, int numColonne) {
		return this.donnees[numLigne][numColonne];
	}

	@Override
	public String getColumnName(int numColonne) {
		return this.entetes[numColonne];
	}
	
	public void insererLigne (Object ligne[])
	{
		Object matrice [][] = new Object[this.getRowCount() +1][this.getColumnCount()];
		int i; 
		for (i=0; i < this.donnees.length ; i++)
		{
			matrice [i] = this.donnees[i];
		}
		matrice[this.donnees.length] = ligne; 
		
		this.donnees = matrice ; 
		this.fireTableDataChanged(); //mise a jour : actualisation
	}
	public void supprimerLigne (int numLigne)
	{
		Object matrice [][] = new Object[this.getRowCount() -1][this.getColumnCount()];
		int i; 
		int j = 0 ;
		for (i=0; i < this.donnees.length ; i++)
		{
			if (i != numLigne) {
				matrice [j] = this.donnees[i];
				j++; 
			}
		}
		
		this.donnees = matrice ; 
		this.fireTableDataChanged(); //mise a jour : actualisation
	}
	public void modifierLigne (int numLigne, Object ligne[])
	{
		Object matrice [][] = new Object[this.getRowCount()][this.getColumnCount()];
		int i; 
		for (i=0; i < this.donnees.length ; i++)
		{
			if (i != numLigne) {
				matrice [i] = this.donnees[i];
			} else {
				matrice[i] = ligne;
			}
		}
		
		this.donnees = matrice ; 
		this.fireTableDataChanged(); //mise a jour : actualisation
	}
}










