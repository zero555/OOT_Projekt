package OOT_SS14_DC.Spielkarton;

import OOT_SS14_DC.Spieler.Spieler;
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