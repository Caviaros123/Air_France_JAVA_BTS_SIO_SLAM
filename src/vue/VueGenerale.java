package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.OrangeEvent;
import controleur.Technicien;

public class VueGenerale extends JFrame implements ActionListener {
	private JPanel panelMenu = new JPanel();

	private JButton btProfil = new JButton("Profil");
	private JButton btClients = new JButton("Clients");
	private JButton btAeroports = new JButton("Aeroports");
	private JButton btAvions = new JButton("Avions");
	private JButton btPilotes = new JButton("Pilotes");
	private JButton btVols = new JButton("Vols");
	private JButton btQuitter = new JButton("Quitter");

	// liste des panels d'administration
	private PanelClients unPanelClient = new PanelClients();
	private PanelTechniciens unPanelTechnicien = new PanelTechniciens();
	private PanelInterventions unPanelIntervention = new PanelInterventions();
	private PanelProfil unPanelProfil;
	

	public VueGenerale(Technicien unTechnicien) {
		this.unPanelProfil = new PanelProfil(unTechnicien);

		this.setTitle("Logiciel de gestion Air France");
		this.setBounds(100, 100, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(246, 172, 34));
		this.setLayout(null);

		// construction du Panel Menu
		this.panelMenu.setBackground(new Color(246, 172, 34));
		this.panelMenu.setBounds(40, 10, 800, 30);
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btAeroports);
		this.panelMenu.add(this.btAvions);
		this.panelMenu.add(this.btPilotes);
		this.panelMenu.add(this.btAvions);
		this.panelMenu.add(this.btVols);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu);

		// rendre les boutons ecoutables
		this.btQuitter.addActionListener(this);
		this.btProfil.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btAeroports.addActionListener(this);
		this.btAvions.addActionListener(this);
		this.btPilotes.addActionListener(this);
		this.btVols.addActionListener(this);

		// ajout des panels dans la fenetre
		this.add(this.unPanelClient);
		this.add(this.unPanelTechnicien);
		this.add(this.unPanelIntervention);
		this.add(this.unPanelProfil);

		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter) {
			int retour = JOptionPane.showConfirmDialog(this,
					"Voulez-Vous quitter l'application ?", "Quitter l'application",
					JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				OrangeEvent.rendreVisibleVueGenerale(false, null);
				OrangeEvent.rendreVisibleVueConnexion(true);
			}
		} else if (e.getSource() == this.btClients) {
			this.unPanelClient.setVisible(true);
			this.unPanelTechnicien.setVisible(false);
			this.unPanelIntervention.setVisible(false);
			this.unPanelProfil.setVisible(false);
		} else if (e.getSource() == this.btAeroports) {
			this.unPanelTechnicien.setVisible(true);
			this.unPanelClient.setVisible(false);
			this.unPanelIntervention.setVisible(false);
			this.unPanelProfil.setVisible(false);
		} else if (e.getSource() == this.btAvions) {
			this.unPanelTechnicien.setVisible(false);
			this.unPanelClient.setVisible(false);
			this.unPanelIntervention.setVisible(true);
			this.unPanelProfil.setVisible(false);
		} else if (e.getSource() == this.btProfil) {
			this.unPanelTechnicien.setVisible(false);
			this.unPanelClient.setVisible(false);
			this.unPanelIntervention.setVisible(false);
			this.unPanelProfil.setVisible(true);
		} else if (e.getSource() == this.btPilotes) {
			this.unPanelTechnicien.setVisible(false);
			this.unPanelClient.setVisible(false);
			this.unPanelIntervention.setVisible(false);
			this.unPanelProfil.setVisible(true);
		} else if (e.getSource() == this.btVols) {
			this.unPanelTechnicien.setVisible(false);
			this.unPanelClient.setVisible(false);
			this.unPanelIntervention.setVisible(false);
			this.unPanelProfil.setVisible(true);
		}
	}
}
