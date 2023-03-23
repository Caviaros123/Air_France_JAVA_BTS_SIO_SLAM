package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.C_Technicien;
import controleur.OrangeEvent;
import controleur.Technicien;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	
	private JPanel panelConnexion = new JPanel (); 
	
	public VueConnexion() {
		this.setTitle("Logiciel de gestion Air France");
		this.setBounds(100, 100, 600, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// get light blue color: https://www.w3schools.com/colors/colors_picker.asp
		this.getContentPane().setBackground(new Color(0, 153, 255));
		this.setLayout(null);
		
		//insertion de l'image LOGO dans la fenetre 
		ImageIcon uneImage = new ImageIcon("src/images/logo.png"); 
		JLabel lbImage = new JLabel(uneImage); 
		lbImage.setBounds(40, 40, 240, 220);
		this.add (lbImage); 
		
		//installation du panel connexion dans la fenetre 
		this.panelConnexion.setBounds(310, 80, 250, 160);
		this.panelConnexion.setBackground(new Color (246, 172, 34));
		this.panelConnexion.setLayout(new GridLayout(3,2));
		
		this.panelConnexion.add(new JLabel("Votre Email :")); 
		this.panelConnexion.add(this.txtEmail); 
		
		this.panelConnexion.add(new JLabel("Votre MDP :")); 
		this.panelConnexion.add(this.txtMdp); 
		
		this.panelConnexion.add(this.btAnnuler); 
		this.panelConnexion.add(this.btSeConnecter); 
		this.add(this.panelConnexion);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//rendre les txt ecoutables de frappe de touche 
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btAnnuler)
		 {
			 this.txtEmail.setText("");
			 this.txtMdp.setText("");
		 }
		 else if (e.getSource() == this.btSeConnecter)
		 {
			 this.traitement (); 
			 this.txtEmail.setText("");
			 this.txtMdp.setText("");
		 }
		
	}
	
	public void traitement ()
	{
		String email = this.txtEmail.getText(); 
		 String mdp = new String (this.txtMdp.getPassword()); 
		 
		 //On vérifie dans la BDD via le controleur 
		 Technicien unTechnicien = C_Technicien.selectWhereTechnicien(email, mdp); 
		 if (unTechnicien == null) {
			 JOptionPane.showMessageDialog(this, 
					 "Veuillez vérifier vos identifiants !");
		 }else {
			 JOptionPane.showMessageDialog(this, 
					 "Bienvenue " + unTechnicien.getNom() + "  " 
					 + unTechnicien.getPrenom());
			 //rendre invisible la vue connexion 
			 OrangeEvent.rendreVisibleVueConnexion(false);
			 //rendre visible la vue generale 
			 OrangeEvent.rendreVisibleVueGenerale(true, unTechnicien);
		 }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//frappe de touche (enter) 
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.traitement();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
