package controleur;

public class Intervention {
	private int idinter ; 
	private String description , dateinter; 
	private float prix; 
	private int idclient, idtechnicien ;
	
	public Intervention(int idinter, String description, String dateinter, float prix, int idclient, int idtechnicien) {
		 
		this.idinter = idinter;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idclient = idclient;
		this.idtechnicien = idtechnicien;
	} 
	
	public Intervention( String description, String dateinter, float prix, int idclient, int idtechnicien) {
		 
		this.idinter = 0;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idclient = idclient;
		this.idtechnicien = idtechnicien;
	} 
	public Intervention() {
		this.idinter = 0;
		this.description = "";
		this.dateinter = "";
		this.prix = 0;
		this.idclient = 0;
		this.idtechnicien = 0;
	}

	public int getIdinter() {
		return idinter;
	}

	public void setIdinter(int idinter) {
		this.idinter = idinter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateinter() {
		return dateinter;
	}

	public void setDateinter(String dateinter) {
		this.dateinter = dateinter;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public int getIdtechnicien() {
		return idtechnicien;
	}

	public void setIdtechnicien(int idtechnicien) {
		this.idtechnicien = idtechnicien;
	} 
	
	
}
