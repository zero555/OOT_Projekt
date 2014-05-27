package OOT_SS14_DC.Spielkarton;

import OOT_SS14_DC.Spieler.Spieler;

/**
 * Die Klasse <code>Spielfeld<code> erstellt das Spielfeld auf dem die Spieler 
 * spielen können. Es gibt vier Ecken, die nach Spieleranzahl unterschiedliche 
 * Anzahl an Felder besitzen können. Die Spieler werden auf die gewünschten 
 * Ecken platziert.
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 * 
 */
public class Spielfeld {

	public Feld[][] feld;
	private int spielerAnzahl;
	protected Feld[] eckeA;
	protected Feld[] eckeB;
	protected Feld[] eckeC;
	protected Feld[] eckeD;
	private Feld[] zugPruefen;

	/**
	 * <pre>
	 * Spielfeld(int spielerAnzahl)
	 * </pre>
	 * 
	 * Das Spielfeld wird erstellt.
	 * 
	 * @param spielerAnzahl
	 *            Anzahl der Spieler
	 */
	public Spielfeld(int spielerAnzahl) {
		feld = new Feld[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				feld[i][j] = new Feld();
				feld[i][j].setIndexSpalte(j);
				feld[i][j].setIndexZeile(i);
			}
		}
		eckeSetzen(Ecke.A, spielerAnzahl);
		eckeSetzen(Ecke.B, spielerAnzahl);
		eckeSetzen(Ecke.C, spielerAnzahl);
		eckeSetzen(Ecke.D, spielerAnzahl);

		this.spielerAnzahl = spielerAnzahl;
	}

	/**
	 * <pre>
	 * spielerSetzen(Ecke ecke, Spieler spieler)
	 * </pre>
	 * 
	 * Die Spielsteine des Spielers werden in die gewünschte Ecke platziert.
	 * 
	 * @param ecke
	 *            Die ausgewählte Ecke
	 * @param spieler
	 *            Der aktuelle Spieler
	 */
	public void spielerSetzen(Ecke ecke, Spieler spieler) {
		spielerSetzen(ecke, spielerAnzahl, spieler);
	}

	/**
	 * <pre>
	 * spielerSetzen(Ecke ecke,int spielerAnzahl,Spieler spieler)
	 * </pre>
	 * 
	 * Die Spielsteine des Spielers werden in die gewünschte Ecke platziert.
	 * 
	 * @param ecke
	 *            Die ausgewählte Ecke
	 * @param spielerAnzahl
	 *            Anzahl der Spieler
	 * @param spieler
	 *            Der aktuelle Spieler
	 */
	private void spielerSetzen(Ecke ecke, int spielerAnzahl, Spieler spieler) {
		Feld[] eckePostion;
		eckePostion = new Feld[eckeA.length];
		if (ecke.toString().equals("A")) { // Enum
			eckePostion = eckeA.clone();
		} else if (ecke.toString().equals("B")) {
			eckePostion = eckeB.clone();
		} else if (ecke.toString().equals("C")) {
			eckePostion = eckeC.clone();
		} else if (ecke.toString().equals("D")) {
			eckePostion = eckeD.clone();
		}
		  spieler.setSpielsteintuete(eckeA.length);
		  for (int i = 0; i < eckeA.length; i++) {
		      spielerAufFeldSetzen(eckePostion[i].getIndexZeile(),
		              (eckePostion[i].getIndexSpalte()), spieler);
		}
	}

	/**
	 * <pre>
	 * eckeSetzen(Ecke ecke, int spielerAnzahl)
	 * </pre>
	 * 
	 * Die Felder der jeweiligen Ecken werden erstellt. Je nach Spieleranzahl
	 * varriert die Anzahl der Felder.
	 * 
	 * @param ecke
	 *            Die ausgewählte Ecke
	 * @param spielerAnzahl
	 *            Anzahl der Spieler
	 */
	private void eckeSetzen(Ecke ecke, int spielerAnzahl) {
		Feld[] eckePostion;
		if (spielerAnzahl == 2) {
			eckePostion = new Feld[19];
		} else {
			eckePostion = new Feld[13];
		}
		int nCountY = 4;
		int nCountX = 4;
		if (spielerAnzahl == 2) {
			nCountY = 5;
			nCountX = 5;
		}
		int eckeCounter = 0;
		for (int i = ecke.getIndexZeile(); i != ecke.getIndexZeile() + nCountY
				* ecke.getRichtungWaagerecht(); i += ecke
				.getRichtungWaagerecht()) {
			for (int j = ecke.getIndexSpalte(); j != ecke.getIndexSpalte()
					+ nCountX * ecke.getRichtungSenkrecht(); j += ecke
					.getRichtungSenkrecht()) {
				eckePostion[eckeCounter] = new Feld();
				eckePostion[eckeCounter].setIndexZeile(i);
				eckePostion[eckeCounter++].setIndexSpalte(j);
			}
			if (Math.abs(i - ecke.getIndexZeile()) == 1)
				nCountX--;
			else if (Math.abs(i - ecke.getIndexZeile()) == 2)
				nCountX--;
			else if (Math.abs(i - ecke.getIndexZeile()) == 3)
				nCountX--;
		}
		if (ecke.toString().equals("A")) {
			eckeA = new Feld[eckePostion.length];
			eckeA = eckePostion.clone();
		} else if (ecke.toString().equals("B")) {
			eckeB = new Feld[eckePostion.length];
			eckeB = eckePostion.clone();
		} else if (ecke.toString().equals("C")) {
			eckeC = new Feld[eckePostion.length];
			eckeC = eckePostion.clone();
		} else if (ecke.toString().equals("D")) {
			eckeD = new Feld[eckePostion.length];
			eckeD = eckePostion.clone();
		}
	}

	/**
	 * <pre>
	 * Feld[] zielEckeSetzen(Ecke ecke)
	 * </pre>
	 * 
	 * Die Zielecke des aktuellen Spieler wird zurückgegeben.
	 * 
	 * @param ecke
	 *            Die Ecke aufdem der Spieler beginnt
	 * @return Zielecke
	 */
	public Feld[] zielEckeSetzen(Ecke ecke) {
		if (ecke.toString().equals("A")) {
			return eckeD;
		} else if (ecke.toString().equals("B")) {
			return eckeC;
		} else if (ecke.toString().equals("C")) {
			return eckeB;
		}
		return eckeA;
	}

	/**
	 * <pre>
	 * pielerAufFeldSetzen(int zeile, int spalte, Spieler spieler)
	 * </pre>
	 * 
	 * Der Spieler wird auf das bewegte Feld hinzugefügt.
	 * 
	 * @param zeile
	 *            Zeilenindex des Feldes
	 * @param spalte
	 *            Spaltenindex des Feldes
	 * @param spieler
	 *            der aktuelle Spieler
	 */
	public void spielerAufFeldSetzen(int zeile, int spalte, Spieler spieler) {
		feld[zeile][spalte].setSpieler(spieler);
	}

	/**
	 * Es wird überprüft ob neben dem gewählten Spielstein freie Felder zum spielen
	 * sind.
	 * @param startZeile Der Startparameter der Zeile des Spielsteines
	 * @param startSpalte Der Startparameter der Spalte des Spielsteines
	 * @return Die freien spielbaren Felder
	 */
	public Feld[] spielsteinKannBewegtwerden(int startZeile, int startSpalte) {
		int index = 0;
		zugPruefen = new Feld[6];
		int richtungZeile = 1; // in welche Richtung ein Stein gehen darf
		int richtungSpalte = 1; // Ecke A als Standard genommen. Spart 1 if-Abfrage
		Ecke ecke = feld[startZeile][startSpalte].getSpieler().getGewaehlteEcke();
		if (ecke == Ecke.B) {
			richtungZeile = 1; //jede Ecke hat verschiedene erlaubte Richtungen 
			richtungSpalte = -1; 
		}
		if (ecke == Ecke.C) {
			richtungZeile = -1;
			richtungSpalte = 1;
		}
		if (ecke == Ecke.D) {
			richtungZeile = -1;
			richtungSpalte = -1;
		}
		spielsteinKannBewegtwerden(startZeile, startSpalte, -1 * richtungZeile,
				1 * richtungSpalte, index++);
		spielsteinKannBewegtwerden(startZeile, startSpalte, 0,
				1 * richtungSpalte, index++);
		spielsteinKannBewegtwerden(startZeile, startSpalte, 1 * richtungZeile,
				1 * richtungSpalte, index++);
		spielsteinKannBewegtwerden(startZeile, startSpalte, 1 * richtungZeile,
				0, index++);
		spielsteinKannBewegtwerden(startZeile, startSpalte, 1 * richtungZeile,
				-1 * richtungSpalte, index);
		return zugPruefen;
	}

	/**
	 * <pre>
	 * spielsteinKannBewegtwerden(int startZeile, int startSpalte,
			int richtungZeile, int richtungSpalte, int index)
	 * </pre>
	 * Es wird nach freien Felder für den Spielzug gesucht.
	 * @param startZeile Der Startparameter der Zeile des Spielsteines
	 * @param startSpalte Der Startparameter der Spalte des Spielsteines
	 * @param richtungZeile Die erlaubte Zeilenrichtung des Spielsteines
	 * @param richtungSpalte Die erlaubte Spaltenrichtung des Spielsteines
	 * @param index Position im zugPruefenarray
	 */
	private void spielsteinKannBewegtwerden(int startZeile, int startSpalte,
			int richtungZeile, int richtungSpalte, int index) {
		int endpunktZeile = 16;
		int endpunktSpalte = 16;
		if (richtungZeile < 0) {
			endpunktZeile = -1;
		}
		if (richtungSpalte < 0) {
			endpunktSpalte = -1;
		}
		boolean gefunden = false;
		int i = startZeile + richtungZeile;
		int j = startSpalte + richtungSpalte;
		while (!gefunden && i != endpunktZeile && j != endpunktSpalte) {
			if (feld[i][j].getSpieler() == null) {
				zugPruefen[index] = feld[i][j];
				gefunden = true;
			}
			i += 1 * richtungZeile;
			j += 1 * richtungSpalte;
		}
	}

	/**
	 * <pre>
	 * getFeldvonSpieler(Spieler spieler)
	 * </pre>
	 * Die Positionen der Spielsteine des aktuellen Spielers werden gesucht.
	 * @param spieler der aktuelle Spieler
	 * @return Positionen der Spielsteine
	 */
	public Feld[] getFeldvonSpieler(Spieler spieler) {
		int index = 0;
		Feld[] feldtmp = new Feld[eckeA.length];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (spieler.equals(feld[i][j].getSpieler())) {
					feldtmp[index] = feld[i][j];
					index++;
				}
			}
		}
		return feldtmp;
	}

	/**
	 * <pre>
	 * printSpielfeld()
	 * </pre>
	 * 
	 * Das Spielfeld wird ausgegeben.
	 */
	public void printSpielfeld() {
		String[][] string = new String[16][16];
		System.out.println("________________________________________________");
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (feld[i][j].getSpieler() != null) {
					string[i][j] = "|" + feld[i][j].getSpieler().getSymbol()
							+ "|";
				} else {
					string[i][j] = "|_|";
				}
				System.out.print(string[i][j]);
			}
			System.out.println();

		}
		System.out.println("------------------------------------------------");
	}
}
