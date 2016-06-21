import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AscoltaBottoneCliente implements ActionListener {
	//ATTRIBUTI
	FinestraCliente miafinestra;
	GestioneTxtCliente g;
	
	//METODI
	public AscoltaBottoneCliente(FinestraCliente miafinestra) {
		super();
		this.miafinestra = miafinestra;
		g= new GestioneTxtCliente();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String act = arg0.getActionCommand();
		if(act.equals("Invia")){
			try {
				g.apriScrittura("client.txt");
				g.scrivi("Nome: "+miafinestra.getNamec()+" Cognome: "+miafinestra.getSurname()+" Settore: "+miafinestra.color);
				g.chiudiScrittura();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new FinestraPopup("Operazione Conclusa!");
			miafinestra.dispose();
		}
	}


}
