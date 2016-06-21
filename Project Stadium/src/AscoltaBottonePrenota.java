import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AscoltaBottonePrenota implements ActionListener {
	//ATTRIBUTI
	FinestraYellow miafinestra;
	FinestraGreen miafinestrag;
	FinestraBlue miafinestrab;
	FinestraOrange miafinestrao;
	int color;
	GestioneTxt g;
	String temp;
	//METODI
	public AscoltaBottonePrenota(FinestraYellow miafinestra) {
		super();
		this.miafinestra = miafinestra;
		g= new GestioneTxt();
		color=1;
		
	}
	public AscoltaBottonePrenota(FinestraBlue miafinestra) {
		super();
		this.miafinestrab = miafinestra;
		g= new GestioneTxt();
		color=2;
		
	}
	public AscoltaBottonePrenota(FinestraOrange miafinestra) {
		super();
		this.miafinestrao = miafinestra;
		g= new GestioneTxt();
		color=3;
		
	}
	public AscoltaBottonePrenota(FinestraGreen miafinestra) {
		super();
		this.miafinestrag = miafinestra;
		g= new GestioneTxt();
		color=4;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String act = arg0.getActionCommand();
		if(act.equals("Prenota")){
			try {
				if(color==1)
					leggi("yellow.txt");
				else{
					if(color==2){
						leggi("blue.txt");
					}else{
						if(color==3){
							leggi("orange.txt");
						}else{
							if(color==4){
								leggi("green.txt");
							}
						}
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int num = Integer.parseInt(temp);
			num--;
			temp=String.valueOf(num);
			try {
				if(color==1)
					g.apriScrittura("yellow.txt");
				else{
					if(color==2){
						g.apriScrittura("blue.txt");
					}else{
						if(color==3){
							g.apriScrittura("orange.txt");
						}else{
							if(color==4){
								g.apriScrittura("green.txt");
							}
						}
					}
				}
				g.scrivi(temp);
				g.chiudiScrittura();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(color==1){
				new FinestraCliente("Yellow");
				miafinestra.dispose();
			}else{
				if(color==2){
					new FinestraCliente("Blue");
					miafinestrab.dispose();
				}else{
					if(color==3){
						new FinestraCliente("Orange");
						miafinestrao.dispose();
					}else{
						if(color==4){
							new FinestraCliente("Green");
							miafinestrag.dispose();
						}
					}
				}
			}
			
		}
	}
	public void leggi(String nome) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(nome));
	    String line = reader.readLine();
	    while(line!=null) {
	    	temp=line;
	        line = reader.readLine();
	        
	    }
		reader.close();
	}

}
