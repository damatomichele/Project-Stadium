import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class FinestraPopup extends JFrame {
	//ATTRIBUTI
	JPanel contenitore,pnlok;
	JTextArea testo;
	JLabel l1,l2,testol;
	JButton ok;
	AscoltaBottonePopup ascolta;
	JFrame f;
	boolean chiudi = false;
	boolean v=true;
	//METODI
	//COSTRUTTORE
	public FinestraPopup(String msg){
		//FIRST SETTINGS
		this.setTitle("Operazione acquisto");
		this.setSize(200, 200);
		//POSIZIONO LA FINESTRA AL CENTRO DELLO SCHERMO
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width/2)-(this.getWidth()/2),(screenSize.height/2)-(this.getHeight()/2));
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		//CONTENITORe
		contenitore = (JPanel) this.getContentPane();
		contenitore.setLayout(new BorderLayout());
		pnlok = new JPanel();
		pnlok.setLayout(new GridLayout(1,3));
		pnlok.setBorder(new EmptyBorder(5,10,5,10));
		testo = new JTextArea(msg);
		testol = new JLabel(msg);
		l1 = new JLabel(" ");
		l2 = new JLabel(" ");
		ok = new JButton("OK");
		ascolta=new AscoltaBottonePopup(this);
		//AGGIUNGO ASCOLTATORe
		ok.addActionListener(ascolta);
		//SETTO LA NON EDITABILITà DELLA TEXT AREA
		testo.setEditable(false);
		//TESTO AL CENTRO
		testol.setHorizontalAlignment(0);
		//SETTO IL COLORE DEL TESTO
			testol.setForeground(Color.GREEN);
			contenitore.add(testol,BorderLayout.CENTER);
			chiudi=true;
		pnlok.add(l1);
		pnlok.add(ok);
		pnlok.add(l2);
		contenitore.add(pnlok,BorderLayout.SOUTH);
		//LAST SETTINGS
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
