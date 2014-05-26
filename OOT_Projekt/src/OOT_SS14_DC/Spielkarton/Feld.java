package OOT_SS14_DC.Spielkarton;

import OOT_SS14_DC.Spieler.Spieler;
import java.util.*;
/**
 * Die Klasse <code> Feld <code> besitzt Attribute die notwendig sind,um die
 * Spielsteine zu bewegen und um zu wissen welche Felder noch nicht besetzt
 * sind.
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
public class Feld {

	private int indexZeile;

	private int indexSpalte;

	private Spieler spieler;
	
	//Spielfeld

	/**
	 * <pre>
	 * setSpieler(Spieler spieler)
	 * </pre>
	 * Der Spieler wird auf das ausgewählte Feld gesetzt.
	 * @param spieler Der aktuelle Spieler
	 */
	public void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}

	/**
	 * <pre>
	 * getSpieler()
	 * </pre>
	 * @return Der Spieler auf dem ausgewählten Feld wird zurückgegeben. Falls
	 * das Feld leer ist wird null zurückgegeben.
	 */
	public Spieler getSpieler() {
		return spieler;
	}

	/**
	 * <pre>
	 * setIndexSpalte(int indexSpalte)
	 * </pre>
	 * Dem Feld wird das Spaltenindex hinzugefügt.
	 * @param indexSpalte Spalteindex des Feldes
	 */
	
	
	    
	public LinkedList<Feld> moeglicheZuege(){
        LinkedList<Feld> alleMoeglichkeiten = new LinkedList<>();
        alleMoeglichkeiten = moegelichesGehen(this);
        // noch springen möglichkeiten
        return alleMoeglichkeiten;
        
    }

	private LinkedList<Feld> moegelichesGehen(Feld sp){
	    
        class Suchausmass{
            private int rechts;
            private int rechtsoben;
            private int oben;
            private int linksoben;
            private int links;
            private int linksunten;
            private int unten;
            private int rechtsunten;
            
            public Suchausmass(int R,int RO,int O,int LO,int L,int LU,int U,int RU){
                this.rechts = R;
                this.rechtsoben = RO;
                this.oben = O;
                this.linksoben = LO;
                this.links = L;
                this.linksunten = LU;
                this.unten = U;
                this.linksoben = LO;
            }
        }
        
        Suchausmass suchausmass; 
        if (sp.getIndexZeile() == 0 && sp.getIndexSpalte() == 0){
            suchausmass = new Suchausmass(0,0,1,1,1,0,0,0);
        } else if (sp.getIndexZeile() == 15 && sp.getIndexSpalte() == 15) {
            suchausmass = new Suchausmass(1,0,0,0,0,0,1,1);
        } else if (sp.getIndexZeile() == 0 && sp.getIndexSpalte() == 15) {
            suchausmass = new Suchausmass(1,1,1,0,0,0,0,0);
        } else if (sp.getIndexZeile() == 15 && sp.getIndexSpalte() == 0) {
            suchausmass = new Suchausmass(0,0,0,0,1,1,1,0);
        } else {
            suchausmass = new Suchausmass(1,1,1,1,1,1,1,1);
        }
        
        if(spieler.getGewaehlteEcke() == Ecke.A){
            suchausmass.oben = 0;
            suchausmass.links = 0;
            suchausmass.linksoben = 0;
        } else if (spieler.getGewaehlteEcke() == Ecke.B){
            suchausmass.oben = 0;
            suchausmass.rechts = 0;
            suchausmass.rechtsoben = 0;
        } else if (spieler.getGewaehlteEcke() == Ecke.C){
            suchausmass.unten = 0;
            suchausmass.links = 0;
            suchausmass.linksunten = 0;
        } else if (spieler.getGewaehlteEcke() == Ecke.D){
            suchausmass.unten = 0;
            suchausmass.rechts = 0;
            suchausmass.rechtsunten = 0;
        }else{
            suchausmass = new Suchausmass (0,0,0,0,0,0,0,0);
        }
        
            
    }
    
    private LinkedList<Feld> moeglichesSpringen(Feld startposition){
        
        
    }
    
    public void spielsteinBewegen(int zeile, int spalte) {
        this.indexZeile = zeile;
        this.indexSpalte = spalte;
        
    }
    
    
    public void setIndexSpalte(int indexSpalte) {
        this.indexSpalte = indexSpalte;
    }
	/**
	 * <pre>
	 * setIndexZeile(int indexZeile)
	 * </pre>
	 * Dem Feld wird das Zeilenindex hinzugefügt.
	 * @param indexZeile Zeilenindex des Feldes.
	 */
	public void setIndexZeile(int indexZeile) {
		this.indexZeile = indexZeile;
	}

	/**
	 * <pre>
	 * getIndexSpalte()
	 * </pre>
	 * @return Spaltenindex des Feldes
	 */
	public int getIndexSpalte() {
		return indexSpalte;
	}

	/**
	 * <pre>
	 * getIndexZeile()
	 * </pre>
	 * @return Zeilenindex des Feldes
	 */
	public int getIndexZeile() {
		return indexZeile;
	}

}