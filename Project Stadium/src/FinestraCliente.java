import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




@SuppressWarnings("serial")
public class FinestraCliente extends JFrame {
	//ATTRIBUTI
		private JPanel contenitore, cliente;
		private JButton prenota;
		private JLabel nome,cognome;
		private JTextField namec,surname;
		public String color;
		
		
		AscoltaBottoneCliente ascolta;
		//METODI
		//COSTRUTTORE
		public FinestraCliente(String colore) {
			super();
			color=colore;
			//FIRST SETTINGS
			this.setTitle(colore+" Client");
			Dimension size = new Dimension(600,100);
			this.setSize(size);
			//POSIZIONE LA FINESTRA AL CENTRO DELLO SCHERMO
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screenSize.width/2)-(this.getWidth()/2),(screenSize.height/2)-(this.getHeight()/2));
			this.setResizable(false);
			//CREO I PANNELLI
			contenitore=(JPanel)this.getContentPane();
			cliente = new JPanel();
			
			nome= new JLabel("Nome: ");
			cognome= new JLabel("Cognome: ");
			namec = new JTextField();
			surname = new JTextField();
			prenota= new JButton("Invia");
			
			nome.setHorizontalAlignment(0);
			cognome.setHorizontalAlignment(0);
			
			//FONT
			Font fo = new Font("Segoe", Font.BOLD, 15);
			cognome.setFont(fo);
			nome.setFont(fo);
			namec.setFont(fo);
			surname.setFont(fo);
			//PANEL POSTI
			cliente.setLayout(new GridLayout(2,2));
			cliente.add(nome);
			cliente.add(namec);
			cliente.add(cognome);
			cliente.add(surname);
			//TOOLBAR
			/*JToolBar toolBar = new JToolBar();
			JButton t1=new JButton("About");
			JButton t2=new JButton("Esci"); 
			toolBar.add(t1);
			toolBar.add(t2);
			toolBar.setFloatable(false);*/
			//CREO L'ASCOLTATORE
			ascolta = new AscoltaBottoneCliente(this);
			//SETTO LAYOUT
			contenitore.setLayout(new BorderLayout());
			contenitore.add(cliente, BorderLayout.CENTER);
			contenitore.add(prenota, BorderLayout.SOUTH);
				
			//AGGIUNGO I COMPONENTI ALL'ASCOLTATORE
			prenota.addActionListener(ascolta);
			
			//POSIZIONO I COMPONENTI NEI DIVERSI PANNELLI;
				//contenitore.add();
			
			//LAST SETTINGS
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public String getNamec() {
			return namec.getText();
		}

		public String getSurname() {
			return surname.getText();
		}
	
}
