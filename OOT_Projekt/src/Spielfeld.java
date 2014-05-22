public class Spielfeld {

	public Feld[][] feld;
	public Feld[] eckeA;
	public Feld[] eckeB;
	public Feld[] eckeC;
	public Feld[] eckeD;

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
	
	public void eckePositiongeben(int spielerAnzahl){
		eckeSetzen(Ecke.A, spielerAnzahl);
		eckeSetzen(Ecke.B, spielerAnzahl);
		eckeSetzen(Ecke.C, spielerAnzahl);
		eckeSetzen(Ecke.D, spielerAnzahl);
	}
	
	public void spielerSetzen(Ecke ecke,int spielerAnzahl,Spieler spieler){
		Feld[] eckePostion;
		eckePostion= new Feld[eckeA.length];
		if(ecke.toString().equals("A")){
			eckePostion=eckeA.clone();
		}else if(ecke.toString().equals("B")){			
			eckePostion=eckeB.clone();
		}else if(ecke.toString().equals("C")){
			eckePostion=eckeC.clone();
		}else if(ecke.toString().equals("D")){
			eckePostion=eckeD.clone();
		}
		spieler.Spielsteine= new Spielstein[eckeA.length];
		for(int i=0;i<eckeA.length;i++){
			spieler.Spielsteine[i] = new Spielstein();
			feld[eckePostion[i].getIndexZeile()][eckePostion[i].getIndexSpalte()].setSpieler(spieler);
			spieler.Spielsteine[i].indexZeile=eckePostion[i].getIndexZeile();
			spieler.Spielsteine[i].indexSpalte=eckePostion[i].getIndexSpalte();
		}
	}

	private void eckeSetzen(Ecke ecke,int spielerAnzahl) {
		Feld[] eckePostion;
		if (spielerAnzahl == 2) {
			eckePostion=new Feld[19];
		} else {
			eckePostion=new Feld[13];
		}
		int nCountY = 4;
		if (spielerAnzahl == 2) {
			nCountY = 5;
		}
		int nCountX = 4;
		if (spielerAnzahl == 2) {
			nCountX = 5;
		}
		int eckeCounter=0;
		for (int i = ecke.getIndexZeile(); i != ecke.getIndexZeile() + nCountY
				* ecke.getnDirZeile(); i += ecke.getnDirZeile()) {
			for (int j = ecke.getIndexSpalte(); j != ecke.getIndexSpalte()
					+ nCountX * ecke.getnDirSpalte(); j += ecke.getnDirSpalte()) {
				eckePostion[eckeCounter]=new Feld();
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
		if(ecke.toString().equals("A")){
			eckeA= new Feld[eckePostion.length];
			eckeA=eckePostion.clone();
		}else if(ecke.toString().equals("B")){
			eckeB= new Feld[eckePostion.length];
			eckeB=eckePostion.clone();
		}else if(ecke.toString().equals("C")){
			eckeC= new Feld[eckePostion.length];
			eckeC=eckePostion.clone();
		}else if(ecke.toString().equals("D")){
			eckeD= new Feld[eckePostion.length];
			eckeD=eckePostion.clone();
		}
	}

	public void printSpielfeld() {
		String [][] string= new String[16][16];
		System.out.println("________________________________________________");
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (feld[i][j].getSpieler()!= null) {
					string[i][j]="|"+feld[i][j].getSpieler().symbol+"|";
				} else {
					string[i][j]="|_|";
				}
				System.out.print(string[i][j]);
			}
			System.out.println();
			
		}
		System.out.println("------------------------------------------------");
	}
}
