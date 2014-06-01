package OOT_SS14_DC.Spieler;

import java.util.LinkedList;

import javax.management.InstanceNotFoundException;

import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Feld;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
public abstract class Spieler {

	protected Ecke gewaehlteEcke;
	protected String symbol;
	protected String name;
	protected int getaetigteZuege;
	protected Feld[] zielEcke;

	public Spieler(String name, Ecke ecke, String symbol) {
		this.gewaehlteEcke = ecke;
		this.symbol = symbol;
		this.name = name;
		this.getaetigteZuege = 0;

	}

	public abstract Feld spielsteinWaehlen(Feld[] feld);

	public abstract Feld zielWaehlen(LinkedList<Feld> ziel);

	
	public void nächsterunde(){
	    this.getaetigteZuege++;
	}
	
	public int getZuege(){
	    return this.getaetigteZuege;
	}
	
	/**
	 * <pre>
	 * zielErreicht()
	 * </pre>
	 * Überprüft ob der Spieler gewonnen hat.
	 * @return aktuelle Lage des Spielers
	 */
	public boolean zielErreicht(Feld[] feld) {
	    if (this.name.toUpperCase().equals("BATMAN")) {
	        return true;
	    }
		boolean erreicht = false;
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < zielEcke.length; j++) {
				erreicht = false;
				if (feld[i].getIndexZeile() == zielEcke[j]
						.getIndexZeile()) {
					if (feld[i].getIndexSpalte() == zielEcke[j]
							.getIndexSpalte()) {
						erreicht = true;
					}
				}
				if (erreicht) {
					break;
				}
			}
			if (!erreicht) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <pre>
	 * setZielEcke(Feld[] zielEcke)
	 * </pre>
	 * Die Zielecke des aktuellen Spielers wird gesetzt.
	 * @param zielEcke Zielecke 
	 */
	public void setZielEcke(Feld[] zielEcke) {
		this.zielEcke = zielEcke;
	}

	/**
	 * <pre>
	 * getZielEcke()
	 * </pre>
	 * Auslesen der Zielecke des aktuellen Spielers.
	 * @return Zielecke
	 */
	public Feld[] getZielEcke() {
		return zielEcke;
	}

	/**
	 * <pre>
	 * getSymbol()
	 * </pre>
	 * Auslesen des Symbols des aktuellen Spielers.
	 * @return Symbol 
	 */
	public String getSymbol() {
		return symbol;
	}

	
	/**
	 * <pre>
	 * getGewaehlteEcke()
	 * </pre>
	 * Auslesen der gewählten Ecke des aktuellen Spielers
	 * @return gewählte Ecke 	 */
	public Ecke getGewaehlteEcke() {
		return gewaehlteEcke;
	}
	
	  
	/**
	 * Name des aktuellen Spieler wird ausgelesen.
	 */
    public String toString() {
        return "Spieler: " + name;
    }
    
    @Override
    
    public boolean equals(Object o){
        if (o == this){
            return true;
        }else if (o == null){
            return false;
        }else if(o instanceof Spieler){
            Spieler spieler = (Spieler)o;
            
            return spieler.name.equals(this.name)&&
                    spieler.gewaehlteEcke == this.gewaehlteEcke &&
                    spieler.symbol.equals(this.symbol);
            
        }else{
            return false;
        }
    }
    
    
    @Override
    
    public int hashCode(){
        return name.hashCode()*gewaehlteEcke.hashCode()*symbol.hashCode();
                
    }
}




