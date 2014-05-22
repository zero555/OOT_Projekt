public class Feld {
	
	private int indexZeile;

	private int indexSpalte;
	
	private Spieler spieler;

	public void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}
	
	public Spieler getSpieler() {
		return spieler;
	}
	
	
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

}