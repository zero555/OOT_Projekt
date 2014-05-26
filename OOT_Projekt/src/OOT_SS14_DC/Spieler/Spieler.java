package OOT_SS14_DC.Spieler;

import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Feld;
import OOT_SS14_DC.Spielkarton.Spielstein;
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
	private Feld[] spielsteintuete;
	protected Feld[] zielEcke;

	public Spieler(String name, Ecke ecke, String symbol) {
		this.gewaehlteEcke = ecke;
		this.symbol = symbol;
		this.name = name;
		this.getaetigteZuege = 0;

	}

	public abstract void spielsteinWaehlen();

	protected abstract void zielWaehlen(Feld startposition);

	/**
	 * <pre>
	 * setSpielsteintuete(int laenge)
	 * </pre>
	 * Die Größe des Spielsteintütenarrays wird festgelegt
	 * @param laenge Die Größe
	 */
	public void setSpielsteintuete(int laenge) {
		spielsteintuete = new Feld[laenge];
	}

	/**
	 * @return the spielsteintuete
	 */
	public Feld[] getSpielsteintuete() {
		return spielsteintuete;
	}

	/**
	 * @param spielsteintuete
	 *            the spielsteintuete to set
	 */
	public void setSpielsteintuete(Feld[] spielsteintuete) {
		this.spielsteintuete = spielsteintuete;
	}

	/**
	 * <pre>
	 * zielErreicht()
	 * </pre>
	 * Überprüft ob der Spieler gewonnen hat.
	 * @return aktuelle Lage des Spielers
	 */
	public boolean zielErreicht() {
		boolean erreicht = false;
		for (int i = 0; i < spielsteintuete.length; i++) {
			for (int j = 0; i < zielEcke.length; j++) {
				erreicht = false;
				if (spielsteintuete[i].getIndexZeile() == zielEcke[j]
						.getIndexZeile()) {
					if (spielsteintuete[i].getIndexSpalte() == zielEcke[j]
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
    
}
