import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AscoltaBottonePopup implements ActionListener {
	//ATTRIBUTI
	FinestraPopup miafinestra;
	//METODI
	public AscoltaBottonePopup(FinestraPopup miafinestra) {
		super();
		this.miafinestra = miafinestra;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new FinestraStadio();
		miafinestra.dispose();
		
	}
}