import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AscoltaBottoneStadio implements ActionListener {
	//ATTRIBUTI
	FinestraStadio miafinestra;
	//METODI
	public AscoltaBottoneStadio(FinestraStadio miafinestra) {
		super();
		this.miafinestra = miafinestra;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String act = arg0.getActionCommand();
		if(act.equals("yellow")){
			new FinestraYellow();
			miafinestra.dispose();
		}else{
			if(act.equals("blue")){
				new FinestraBlue();
				miafinestra.dispose();
			}else {
				if(act.equals("orange")){
					new FinestraOrange();
					miafinestra.dispose();
				}else{
					new FinestraGreen();
					miafinestra.dispose();
				}
			}
		}
	}
	

}
