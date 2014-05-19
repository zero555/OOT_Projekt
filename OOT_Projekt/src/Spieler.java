public abstract class Spieler {

	public Ecke gewaehlteEcke;

	public String symbol;

	public String name;

	public int getaetigteZuege;

	public void spielsteinWaehlen() {
	}

	public void zielWaehlen(Feld startposition) {
	}

	public boolean zielErreicht() {
		return false;
	}

	public void spielsteinBewegen(Feld startposition, Feld zielposition) {
	}

}