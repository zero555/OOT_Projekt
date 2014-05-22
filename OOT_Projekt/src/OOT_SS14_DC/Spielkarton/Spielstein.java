package OOT_SS14_DC.Spielkarton;
import OOT_SS14_DC.Spieler.Spieler;

public class Spielstein {

	public int indexZeile;
	public Feld feld;
	public int indexSpalte;
	
    public Spieler zugehoerigerSpieler;
    
    public Spielstein() {}
    public Spielstein (Feld feld, Spieler zugehoerigerSpieler){
        this.feld = feld;
        this.zugehoerigerSpieler = zugehoerigerSpieler;
    }
    
    
    
    public Feld[] moeglicheZuege(){
		return null;
        
    }
    
    protected void spielsteinBewegen(int zeile, int spalte) {
    	this.indexZeile = zeile;
    	this.indexSpalte = spalte;
    	
    }
}
