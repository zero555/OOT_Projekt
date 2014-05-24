package OOT_SS14_DC.Spielkarton;

import OOT_SS14_DC.Spieler.Spieler;

public class Spielfeld {

	public Feld[][] feld;
	private int spielerAnzahl;
	protected Feld[] eckeA;
	protected Feld[] eckeB;
	protected Feld[] eckeC;
	protected Feld[] eckeD;

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
		
		this.spielerAnzahl = spielerAnzahl;   //von Dominik
	}
	/**
	 * von Dominik
	 * 
	 */
	public void spielerSetzen(Ecke ecke, Spieler spieler) {
	    spielerSetzen(ecke, spielerAnzahl, spieler);
	}
	
	
	public void spielerSetzen(Ecke ecke,int spielerAnzahl,Spieler spieler){
		Feld[] eckePostion;
		eckePostion = new Feld[eckeA.length];
		if (ecke.toString().equals("A")) {
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
			spieler.getSpielsteintuete()[i] = new Spielstein();
			spielerAufFeldSetzen(eckePostion[i].getIndexZeile(),
					(eckePostion[i].getIndexSpalte()), spieler);
			spieler.getSpielsteintuete()[i].indexZeile = eckePostion[i]
					.getIndexZeile();
			spieler.getSpielsteintuete()[i].indexSpalte = eckePostion[i]
					.getIndexSpalte();
		}
	}

	private void eckeSetzen(Ecke ecke, int spielerAnzahl) {
		Feld[] eckePostion;
		if (spielerAnzahl == 2) {
			eckePostion = new Feld[19];
		} else {
			eckePostion = new Feld[13];
		}
		int nCountY = 4;
		if (spielerAnzahl == 2) {
			nCountY = 5;
		}
		int nCountX = 4;
		if (spielerAnzahl == 2) {
			nCountX = 5;
		}
		int eckeCounter = 0;
		for (int i = ecke.getIndexZeile(); i != ecke.getIndexZeile() + nCountY
				* ecke.getnDirZeile(); i += ecke.getnDirZeile()) {
			for (int j = ecke.getIndexSpalte(); j != ecke.getIndexSpalte()
					+ nCountX * ecke.getnDirSpalte(); j += ecke.getnDirSpalte()) {
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

	public Feld[] getEcke(Ecke ecke) {
		if (ecke.toString().equals("A")) {
			return eckeA;
		} else if (ecke.toString().equals("B")) {
			return eckeB;
		} else if (ecke.toString().equals("C")) {
			return eckeC;
		}
		return eckeD;
	}

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

	public void spielerAufFeldSetzen(int zeile, int spalte, Spieler spieler) {
		feld[zeile][spalte].setSpieler(spieler);
	}

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
