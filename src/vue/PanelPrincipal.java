package vue;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel 
{
	public PanelPrincipal (String titre, String image)
	{
		this.setBounds(50, 50, 800, 390);
		this.setBackground(new Color (246, 172, 34));
		this.setLayout(null);
		
		//placer un titre 
		JLabel lbTitre = new JLabel(titre); 
		lbTitre.setBounds(350, 10, 200, 20);
		this.add(lbTitre); 
		
		//logo du panel 
		ImageIcon uneImage = new ImageIcon ("src/images/"+image);
		JLabel lbImage= new JLabel(uneImage); 
		lbImage.setBounds(10, 10, 80, 80);
		this.add(lbImage); 
		
		this.setVisible(false);
	}
}
