import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class FinestraYellow extends JFrame {
	//ATTRIBUTI
		private JPanel contenitore, posti;
		private JButton prenota;
		private JLabel tot, titolo, totali, disponibili, esauriti, disp;
		
		
		AscoltaBottonePrenota ascolta;
		//METODI
		//COSTRUTTORE
		public FinestraYellow() {
			super();
			//FIRST SETTINGS
			this.setTitle("Yellow");
			Dimension size = new Dimension(300,300);
			this.setSize(size);
			//POSIZIONE LA FINESTRA AL CENTRO DELLO SCHERMO
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screenSize.width/2)-(this.getWidth()/2),(screenSize.height/2)-(this.getHeight()/2));
			this.setResizable(false);
			//CREO I PANNELLI
			contenitore=(JPanel)this.getContentPane();
			posti = new JPanel();
			titolo= new JLabel("Area Yellow");
			totali= new JLabel("Posti totali");
			tot= new JLabel("100");
			disponibili= new JLabel("Posti disponibili: ");
			esauriti= new JLabel("SOLD OUT!");
			prenota= new JButton("Prenota");
			disp= new JLabel();
			try {
				leggi("yellow.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			disponibili.setHorizontalAlignment(0);
			totali.setHorizontalAlignment(0);
			titolo.setHorizontalAlignment(0);
			esauriti.setHorizontalAlignment(0);
			//FONT
			Font fo = new Font("Segoe", Font.BOLD, 26);
			titolo.setForeground(Color.YELLOW);
			titolo.setFont(fo);
			esauriti.setFont(fo);
			esauriti.setForeground(Color.RED);
			//PANEL POSTI
			posti.setLayout(new GridLayout(2,2));
			posti.add(totali);
			posti.add(tot);
			posti.add(disponibili);
			posti.add(disp);
			//TOOLBAR
			/*JToolBar toolBar = new JToolBar();
			JButton t1=new JButton("About");
			JButton t2=new JButton("Esci"); 
			toolBar.add(t1);
			toolBar.add(t2);
			toolBar.setFloatable(false);*/
			//CREO L'ASCOLTATORE
			ascolta = new AscoltaBottonePrenota(this);
			//SETTO LAYOUT
			contenitore.setLayout(new GridLayout(3,1));
			contenitore.add(titolo);
			contenitore.add(posti);
			if(disp.getText().equals("0"))
				contenitore.add(esauriti);
			else
				contenitore.add(prenota);
				
			//AGGIUNGO I COMPONENTI ALL'ASCOLTATORE
			prenota.addActionListener(ascolta);
			
			//POSIZIONO I COMPONENTI NEI DIVERSI PANNELLI;
				//contenitore.add();
			
			//LAST SETTINGS
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void leggi(String nome) throws IOException{
			BufferedReader reader = new BufferedReader(new FileReader(nome));
		    String line = reader.readLine();
		    while(line!=null) {
		    	disp.setText(line);
		        line = reader.readLine();
		        
		    }
			reader.close();
		}
}
