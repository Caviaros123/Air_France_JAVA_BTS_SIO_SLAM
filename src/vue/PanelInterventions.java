package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import controleur.C_Client;
import controleur.C_Intervention;
import controleur.C_Technicien;
import controleur.Client;
import controleur.Intervention;
import controleur.Technicien;

public class PanelInterventions extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	private JTextField txtDescription= new JTextField(); 
	private JTextField txtDateinter = new JTextField(); 
	private JTextField txtPrix = new JTextField(); 
	private JComboBox<String> cbxIdClient= new JComboBox<String>(); 
	private JComboBox<String> cbxIdTechnicien= new JComboBox<String>(); 
	
	public PanelInterventions()
	{
		super ("___ Gestion Interventions ___", "interventions.png"); 
		//construction du panelForm 
		this.panelForm.setBounds(20, 50, 250, 270);
		this.panelForm.setBackground(new Color (246, 172, 34));
		this.panelForm.setLayout(new GridLayout(6,2));
		
		this.panelForm.add(new JLabel("Description :")); 
		this.panelForm.add(this.txtDescription); 
		
		this.panelForm.add(new JLabel("Date Intervention :")); 
		this.panelForm.add(this.txtDateinter);
		
		this.panelForm.add(new JLabel("Prix Intervention :")); 
		this.panelForm.add(this.txtPrix);
		
		this.panelForm.add(new JLabel("Le Client :")); 
		this.panelForm.add(this.cbxIdClient);
		
		this.panelForm.add(new JLabel("Le technicien :")); 
		this.panelForm.add(this.cbxIdTechnicien);
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm); 
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		//remplir les CBX
		this.remplirCBX();
	}
	public void remplirCBX()
	{
		//on vide les CBX 
		this.cbxIdClient.removeAllItems();
		ArrayList<Client> lesClients = C_Client.listerClients(""); 
		for (Client unClient : lesClients)
		{
			this.cbxIdClient.addItem(unClient.getIdclient()+"-"+unClient.getNom());
		}
		
		this.cbxIdTechnicien.removeAllItems();
		ArrayList<Technicien> lesTechniciens = C_Technicien.listerTechniciens(); 
		for (Technicien unTechnicien : lesTechniciens)
		{
			this.cbxIdTechnicien.addItem(unTechnicien.getIdtechnicien()+"-"+unTechnicien.getNom());
		}
	}
	public void viderChamps ()
	{
		this.txtDescription.setText("");
		this.txtDateinter.setText("");
		this.txtPrix.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource()==this.btEnregistrer)
		{
			String description = this.txtDescription.getText(); 
			String dateinter = this.txtDateinter.getText(); 
			float prix = Float.parseFloat(this.txtPrix.getText()); 
			String chaine = this.cbxIdClient.getSelectedItem().toString(); 
			String tab [] = chaine.split("-"); 
			int idclient = Integer.parseInt(tab[0]);
			
			
			chaine = this.cbxIdTechnicien.getSelectedItem().toString(); 
			tab = chaine.split("-"); 
			int idtechnicien = Integer.parseInt(tab[0]);
		
			//instanciation de la classe Intervention 
			Intervention uneIntervention = new Intervention(description, dateinter, 
						prix, idclient, idtechnicien);
			//insertion dans la base de données 
			C_Intervention.insertIntervention(uneIntervention);
			JOptionPane.showMessageDialog(this, 
					"Intervention ajoutée dans la BDD avec succès.");
			this.viderChamps();
		}
	}
	
	

}
