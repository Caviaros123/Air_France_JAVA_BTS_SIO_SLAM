package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.C_Technicien;
import controleur.Technicien;

public class PanelProfil extends PanelPrincipal implements ActionListener
{
	private JTextArea txtInfos = new JTextArea(); 
	private JButton btModifier = new JButton("Modifier"); 
	
	private JPanel panelForm = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtQualification = new JTextField(); 
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtTel = new JTextField(); 
	private int idtechnicien; 
	
	public PanelProfil(Technicien unTechnicien)
	{
		super ("___ Mon Profil ___", "profil.png"); 
		this.idtechnicien = unTechnicien.getIdtechnicien(); 
		
		this.txtInfos.setBounds(50, 60, 250, 200);
		this.txtInfos.setText(
			" __________ INFOS DU Technicien __________________\n"
			+ "Nom technicien : "+unTechnicien.getNom()+"\n\n"
			+ "Prénom : "+unTechnicien.getPrenom()+"\n\n"
			+ "Qualification : "+unTechnicien.getQualification()+"\n\n"
			+"Email technicien : "+unTechnicien.getEmail()+"\n\n"
			+ "Téléphone: "+unTechnicien.getTel()+"\n"
			);
		this.txtInfos.setBackground(new Color (246, 172, 34));
		this.add(this.txtInfos);
		
		this.btModifier.setBounds(100, 300, 100, 20);
		this.add(this.btModifier); 
		//construction du panelForm 
			this.panelForm.setBounds(380, 40, 250, 270);
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
			
			this.remplirChamps(unTechnicien);
			this.panelForm.setVisible(false);
			this.add(this.panelForm); 
				
		//rendre les boutons ecoutables 
		this.btModifier.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}
	
	public void remplirChamps (Technicien unTechnicien)
	{
		this.txtNom.setText(unTechnicien.getNom());
		this.txtPrenom.setText(unTechnicien.getPrenom());
		this.txtQualification.setText(unTechnicien.getQualification());
		this.txtTel.setText(unTechnicien.getTel());
		this.txtEmail.setText(unTechnicien.getEmail());
		this.txtMdp.setText("");
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
		if (e.getSource() == this.btModifier)
		{
			if (this.panelForm.isVisible()) {
				this.panelForm.setVisible(false);
			}else {
				this.panelForm.setVisible(true);
			}
		}
		else if (e.getSource() == this.btAnnuler)
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
			Technicien unTechnicien = new Technicien(this.idtechnicien,nom,prenom, email, mdp, tel,qualification);
			//update du technicien dans la base de données 
			C_Technicien.updateTechnicien(unTechnicien);
			
			JOptionPane.showMessageDialog(this, "Modification réussie du profil.");
			this.txtInfos.setText(
					" __________ INFOS DU Technicien __________________\n"
					+ "Nom technicien : "+unTechnicien.getNom()+"\n\n"
					+ "Prénom : "+unTechnicien.getPrenom()+"\n\n"
					+ "Qualification : "+unTechnicien.getQualification()+"\n\n"
					+"Email technicien : "+unTechnicien.getEmail()+"\n\n"
					+ "Téléphone: "+unTechnicien.getTel()+"\n"
					);
			this.remplirChamps(unTechnicien);
			
			this.panelForm.setVisible(false);
		}
		
	}
}
