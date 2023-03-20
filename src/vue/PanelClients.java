package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import controleur.Tableau;

public class PanelClients extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtAdresse = new JTextField(); 
	private JTextField txtEmail = new JTextField(); 
	private JTextField txtTel = new JTextField(); 
	
	private JTable tableClients ; 
	private Tableau unTableau ; 
	
	private JPanel panelRecherche = new JPanel(); 
	private JTextField txtFiltre = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public PanelClients()
	{
		super ("___ Gestion Clients ___", "clients.jpeg"); 
		
		//construction du panelForm 
		this.panelForm.setBounds(20, 100, 250, 270);
		this.panelForm.setBackground(new Color (246, 172, 34));
		this.panelForm.setLayout(new GridLayout(6,2));
		
		this.panelForm.add(new JLabel("Nom :")); 
		this.panelForm.add(this.txtNom); 
		
		this.panelForm.add(new JLabel("Prénom :")); 
		this.panelForm.add(this.txtPrenom);
		
		this.panelForm.add(new JLabel("Adresse :")); 
		this.panelForm.add(this.txtAdresse);
		
		this.panelForm.add(new JLabel("Email :")); 
		this.panelForm.add(this.txtEmail);
		
		this.panelForm.add(new JLabel("Téléphone :")); 
		this.panelForm.add(this.txtTel);
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm);
		
		//construction de la table des clients 
		String entetes[] = {"ID Client","Nom","Prénom","Email","Téléphone","Adresse"};
		Object donnees [][] = this.obtenirDonnees("");
		this.unTableau = new Tableau (donnees, entetes);
		this.tableClients = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableClients); 
		uneScroll.setBounds(330, 100, 400, 270);
		this.add(uneScroll);
		
		//construction du Panel filtre
		this.panelRecherche.setBounds(360, 60, 350, 20);
		this.panelRecherche.setBackground(new Color (246, 172, 34));
		this.panelRecherche.setLayout(new GridLayout(1,3));
		this.panelRecherche.add(new JLabel("Filtrer les clients par :"));
		this.panelRecherche.add(this.txtFiltre); 
		this.panelRecherche.add(this.btFiltrer); 
		this.add(this.panelRecherche); 
		
		//suppression d'un client dans la table 
		this.tableClients.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 int numLigne; 
				 int idclient; 
				 if (e.getClickCount() >= 2)
				 {
					 //suppression de la ligne 
					 numLigne = tableClients.getSelectedRow(); 
					 idclient = Integer.parseInt(tableClients.getValueAt(numLigne, 0).toString());
					int retour = JOptionPane.showConfirmDialog(null, 
							"Voulez-vous supprimer ce client ?", "Suppression du client", 
							JOptionPane.YES_NO_OPTION);
					if (retour ==0) {
						C_Client.supprimerClient(idclient);
						unTableau.supprimerLigne(numLigne);
						JOptionPane.showMessageDialog(null, "Suppresssion réussie du client");
						viderChamps();
					}
				 }else if (e.getClickCount()==1)
				 {
					 numLigne = tableClients.getSelectedRow(); 
					 txtNom.setText(tableClients.getValueAt(numLigne, 1).toString());
					 txtPrenom.setText(tableClients.getValueAt(numLigne, 2).toString());
					 txtAdresse.setText(tableClients.getValueAt(numLigne, 3).toString());
					 txtEmail.setText(tableClients.getValueAt(numLigne, 4).toString());
					 txtTel.setText(tableClients.getValueAt(numLigne, 5).toString());
					 btEnregistrer.setText("Modifier");
				 }
				
			}
		});
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltrer.addActionListener(this);
	}
	
	public Object [][] obtenirDonnees (String mot)
	{
		ArrayList<Client> lesClients = C_Client.listerClients(mot); 
		Object [][] matrice = new Object[lesClients.size()][6];
		int i =0; 
		for (Client unClient : lesClients)
		{
			matrice[i][0] = unClient.getIdclient(); 
			matrice[i][1] = unClient.getNom(); 
			matrice[i][2] = unClient.getPrenom(); 
			matrice[i][3] = unClient.getEmail(); 
			matrice[i][4] = unClient.getTel();
			matrice[i][5] = unClient.getAdresse(); 
			i++ ;
		}
		return matrice; 
	}
	public void viderChamps ()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtTel.setText("");
		this.txtEmail.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource()==this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer"))
		{
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String adresse = this.txtAdresse.getText(); 
			String email = this.txtEmail.getText();
			String tel = this.txtTel.getText(); 
			//instanciation de la classe Client 
			Client unClient = new Client(nom,prenom, email, adresse, tel);
			//insertion dans la base de données 
			C_Client.insertClient(unClient);
			
			//récupérer l'id du client inséré 
			unClient = C_Client.selectWhereClient(email); 
			
			//actualiser l'affichage 
			Object ligne[] = {unClient.getIdclient(), nom, prenom, email, adresse, tel};
			this.unTableau.insererLigne(ligne);
			
			JOptionPane.showMessageDialog(this, 
					"Client ajouté dans la BDD avec succès.");
			this.viderChamps();
		}
		else if (e.getSource()==this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier"))
		{
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String adresse = this.txtAdresse.getText(); 
			String email = this.txtEmail.getText();
			String tel = this.txtTel.getText(); 
			int numLigne = tableClients.getSelectedRow(); 
			int idclient = Integer.parseInt(tableClients.getValueAt(numLigne, 0).toString());
			 
			//instanciation de la classe Client 
			Client unClient = new Client(idclient,nom,prenom, email, adresse, tel);
			//Update dans la base de données 
			C_Client.modifierClient(unClient);
			
			//actualiser l'affichage 
			Object ligne[] = {unClient.getIdclient(), nom, prenom, email, adresse, tel};
			this.unTableau.modifierLigne(numLigne, ligne);
			
			JOptionPane.showMessageDialog(this, 
					"Client modifié dans la BDD avec succès.");
			this.viderChamps();
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtFiltre.getText(); 
			Object donnees [][] = this.obtenirDonnees(mot);
			this.unTableau.setDonnees(donnees);
		}
	}
}




