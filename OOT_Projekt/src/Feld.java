public class Feld {

	private int indexZeile;

	private int indexSpalte;
	
	private Spieler anfangsSpieler;

	
	
	public void setIndexSpalte(int indexSpalte) {
		this.indexSpalte = indexSpalte;
	}
	
	public void setIndexZeile(int indexZeile) {
		this.indexZeile = indexZeile;
	}
	
	public int getIndexSpalte() {
		return indexSpalte;
	}
	
	public int getIndexZeile() {
		return indexZeile;
	}
	
	public void setAnfangsSpieler(Spieler anfangsSpieler) {
		this.anfangsSpieler = anfangsSpieler;
	}
	
	
	public Spieler getAnfangsSpieler() {
		return anfangsSpieler;
	}


}