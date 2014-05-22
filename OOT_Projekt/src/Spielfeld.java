public class Spielfeld {

	public Feld[][] feld;

	public Spielfeld() {
		feld = new Feld[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				feld[i][j] = new Feld();
				feld[i][j].setIndexSpalte(j);
				feld[i][j].setIndexZeile(i);
			}
		}
	}

	public void spielerSetzen(Ecke ecke, int spielerAnzahl, Spieler spieler) {

		if (spielerAnzahl == 2) {
			spieler.Spielsteine = new Spielstein[19];
		} else {
			spieler.Spielsteine = new Spielstein[13];
		}
		int nCounter = 0;
		int nCountY = 4;
		if (spielerAnzahl == 2) {
			nCountY = 5;
		}
		int nCountX = 4;
		if (spielerAnzahl == 2) {
			nCountX = 5;
		}
		for (int i = ecke.getIndexZeile(); i != ecke.getIndexZeile() + nCountY
				* ecke.getnDirZeile(); i += ecke.getnDirZeile()) {
			for (int j = ecke.getIndexSpalte(); j != ecke.getIndexSpalte()
					+ nCountX * ecke.getnDirSpalte(); j += ecke.getnDirSpalte()) {
				feld[i][j].setAnfangsSpieler(spieler);
				feld[i][j].setSpieler(spieler);
				spieler.Spielsteine[nCounter] = new Spielstein();
				spieler.Spielsteine[nCounter].indexZeile = i;
				spieler.Spielsteine[nCounter++].indexSpalte = j;
			}
			if (Math.abs(i - ecke.getIndexZeile()) == 1)
				nCountX--;
			else if (Math.abs(i - ecke.getIndexZeile()) == 2)
				nCountX--;
			else if (Math.abs(i - ecke.getIndexZeile()) == 3)
				nCountX--;
		}
	}

	public void printSpielfeld() {
		String [][] string= new String[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (feld[i][j].getSpieler()!= null) {
					string[i][j]="|"+feld[i][j].getSpieler().symbol+"|";
				} else {
					string[i][j]="| |";
				}
				System.out.print(string[i][j]);
			}
			System.out.println();
		}
	}
}
