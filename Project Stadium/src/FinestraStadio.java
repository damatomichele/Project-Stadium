import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class FinestraStadio extends JFrame {
	//ATTRIBUTI
		private JPanel contenitore;
		private JButton yellow, blue, green, orange;
		AscoltaBottoneStadio ascolta;
		//METODI
		//COSTRUTTORE
		public FinestraStadio() {
			super();
			//FIRST SETTINGS
			this.setTitle("Booking Emirates Stadium Author: Damato");
			Dimension size = new Dimension(800,610);
			this.setSize(size);
			//POSIZIONE LA FINESTRA AL CENTRO DELLO SCHERMO
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screenSize.width/2)-(this.getWidth()/2),(screenSize.height/2)-(this.getHeight()/2));
			this.setResizable(false);
			//CREO I PANNELLI
			contenitore=(JPanel)this.getContentPane();
			//TOOLBAR
			/*JToolBar toolBar = new JToolBar();
			JButton t1=new JButton("About");
			JButton t2=new JButton("Esci"); 
			toolBar.add(t1);
			toolBar.add(t2);
			toolBar.setFloatable(false);*/
			//CREO L'ASCOLTATORE
			ascolta = new AscoltaBottoneStadio(this);
			//SETTO LAYOUT
			contenitore.setLayout(new GridLayout(2,2));
			//ICONE
			java.net.URL ye=getClass().getResource("img/yellow.jpg");
			java.net.URL b=getClass().getResource("img/blue.jpg");
			java.net.URL g=getClass().getResource("img/green.jpg");
			java.net.URL o=getClass().getResource("img/orange.jpg");
			ImageIcon giallo = new ImageIcon(ye);
			ImageIcon verde = new ImageIcon(g);
			ImageIcon blu = new ImageIcon(b);
			ImageIcon arancio = new ImageIcon(o);
			//CREO I COMPONENTI
			yellow = new JButton();
			green = new JButton();
			blue = new JButton();
			orange = new JButton();
			yellow.setIcon(giallo);
			green.setIcon(verde);
			orange.setIcon(arancio);
			blue.setIcon(blu);
			//SET ACTION COMMAND
			yellow.setActionCommand("yellow");
			orange.setActionCommand("orange");
			green.setActionCommand("green");
			blue.setActionCommand("blue");
			//AGGIUNGO I COMPONENTI ALL'ASCOLTATORE
			yellow.addActionListener(ascolta);
			orange.addActionListener(ascolta);
			green.addActionListener(ascolta);
			blue.addActionListener(ascolta);
			//POSIZIONO I COMPONENTI NEI DIVERSI PANNELLI;
			contenitore.add(yellow);
			contenitore.add(orange);
			contenitore.add(green);
			contenitore.add(blue);
			//LAST SETTINGS
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
