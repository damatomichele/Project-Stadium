import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class GestioneTxtCliente {
	//ATTRIBUTI
	FileWriter f;
	PrintWriter fOUT;
	//METODI
	public void apriScrittura(String nomeFile) throws IOException{
		f = new FileWriter(nomeFile, true);
		fOUT=new PrintWriter(f);
	}
	public void scrivi(String msg){
		fOUT.println(msg);
	}
	public void chiudiScrittura() throws IOException{
		f.close();
	}
}
