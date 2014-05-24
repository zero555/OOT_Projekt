package OOT_SS14_DC.Spieler;

import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Feld;
import OOT_SS14_DC.Spielkarton.Spielstein;

public abstract class Spieler {

	protected Ecke gewaehlteEcke;
	protected String symbol;
	protected String name;
	protected int getaetigteZuege;
	private Spielstein[] spielsteintuete;
	protected Feld[] zielEcke;

	public Spieler(String name, Ecke ecke, String symbol) {
		this.gewaehlteEcke = ecke;
		this.symbol = symbol;
		this.name = name;
		this.getaetigteZuege = 0;

	}

	public abstract void spielsteinWaehlen();

	protected abstract void zielWaehlen(Feld startposition);

	public void setSpielsteintuete(int laenge) {
		spielsteintuete = new Spielstein[laenge];
	}

	/**
	 * @return the spielsteintuete
	 */
	public Spielstein[] getSpielsteintuete() {
		return spielsteintuete;
	}

	/**
	 * @param spielsteintuete
	 *            the spielsteintuete to set
	 */
	public void setSpielsteintuete(Spielstein[] spielsteintuete) {
		this.spielsteintuete = spielsteintuete;
	}

	public boolean zielErreicht() {
		boolean erreicht = false;
		for (int i = 0; i < spielsteintuete.length; i++) {
			for (int j = 0; i < zielEcke.length; j++) {
				erreicht = false;
				if (spielsteintuete[i].indexZeile == zielEcke[j]
						.getIndexZeile()) {
					if (spielsteintuete[i].indexSpalte == zielEcke[j]
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

	public void setZielEcke(Feld[] zielEcke) {
		this.zielEcke = zielEcke;
	}

	public Feld[] getZielEcke() {
		return zielEcke;
	}

	public String getSymbol() {
		return symbol;
	}

	public Ecke getGewaehlteEcke() {
		return gewaehlteEcke;
	}
}