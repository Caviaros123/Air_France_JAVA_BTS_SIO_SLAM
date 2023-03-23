package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Client;
import controleur.C_Technicien;
import controleur.Client;
import controleur.Technicien;

public class PanelTechniciens extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtQualification = new JTextField(); 
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtTel = new JTextField(); 
	
	private JTable tableTechniciens ;
	
	public PanelTechniciens()
	{
		super ("___ Gestion Techniciens ____", "techniciens.png"); 
		//construction du panelForm 
		this.panelForm.setBounds(20, 100, 250, 270);
		this.panelForm.setBackground(new Color (246, 172, 34));
		this.panelForm.setLayout(new GridLayout(7,2));
		
		this.panelForm.add(new JLabel("Nom :")); 
		this.panelForm.add(this.txtNom); 
		
		this.panelForm.add(new JLabel("Prénom :")); 
		this.panelForm.add(this.txtPrenom);
		
		this.panelForm.add(new JLabel("Qualification :")); 
		this.panelForm.add(this.txtQualification);
		
		this.panelForm.add(new JLabel("Email :")); 
		this.panelForm.add(this.txtEmail);
		
		this.panelForm.add(new JLabel("MDP :")); 
		this.panelForm.add(this.txtMdp);
		
		this.panelForm.add(new JLabel("Téléphone :")); 
		this.panelForm.add(this.txtTel);
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm); 
		
		//construction de la table des clients 
		String entetes[] = {"ID Technicien","Nom","Prénom","Email","Téléphone","Qualification"};
		Object donnees [][] = this.obtenirDonnees(); 
		this.tableTechniciens = new JTable(donnees, entetes);
		JScrollPane uneScroll = new JScrollPane(this.tableTechniciens); 
		uneScroll.setBounds(330, 100, 440, 270);
		this.add(uneScroll); 
				
				
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}
	public Object [][] obtenirDonnees ()
	{
		ArrayList<Technicien> lesTechniciens = C_Technicien.listerTechniciens();
		Object [][] matrice = new Object[lesTechniciens.size()][6];
		int i =0;
		for (Technicien unTechnicien : lesTechniciens)
		{
			matrice[i][0] = unTechnicien.getIdtechnicien();
			matrice[i][1] = unTechnicien.getNom();
			matrice[i][2] = unTechnicien.getPrenom();
			matrice[i][3] = unTechnicien.getEmail();
			matrice[i][4] = unTechnicien.getTel();
			matrice[i][5] = unTechnicien.getQualification();
			i++ ;
		}
		return matrice; 
	}
	public void viderChamps ()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtQualification.setText("");
		this.txtTel.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource()==this.btEnregistrer)
		{
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String qualification = this.txtQualification.getText(); 
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
			String tel = this.txtTel.getText(); 
			//instanciation de la classe Technicien 
			Technicien unTechnicien = new Technicien(nom,prenom, email, mdp, tel,qualification);
			//insertion dans la base de données 
			C_Technicien.insertTechnicien(unTechnicien);
			JOptionPane.showMessageDialog(this, 
					"Technicien ajouté dans la BDD avec succès.");
			this.viderChamps();
		}
	}
}
