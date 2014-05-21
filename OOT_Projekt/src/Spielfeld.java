public class Spielfeld {

	public Feld[][] feld;

	public Spielfeld() {
		feld=new Feld[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				feld[i][j].setIndexSpalte(j);
				feld[i][j].setIndexZeile(i);
			}
		}
	}

	public void spielerSetzen( Ecke ecke, int spielerAnzahl , Spieler spieler){
		
	if(spielerAnzahl==2){	
		spieler.Spielsteine= new Spielstein[16];
	}else{
		spieler.Spielsteine= new Spielstein[13];
	}
	int nCounter = 0;
	 int nCountY = 4;
	 if( spielerAnzahl == 2){
	  nCountY = 5;
	 }
	 int  nCountX = 4;
	 if (spielerAnzahl == 2){
	  nCountX = 5;
	 }
	 for( int i=ecke.getIndexZeile();i!=ecke.getIndexZeile()+nCountY*ecke.getnDirZeile();i+=ecke.getnDirZeile() )
	 {
	  for( int j=ecke.getIndexSpalte(); j!=ecke.getIndexSpalte()+nCountX*ecke.getnDirSpalte(); j+=ecke.getnDirSpalte() ){
	   feld[i][j].setAnfangsSpieler(spieler);
	   spieler.Spielsteine[nCounter].indexZeile = i;
	   spieler.Spielsteine[nCounter++].indexSpalte = j;
	   
	  }
	  if (Math.abs(i-ecke.getIndexZeile()) == 1)
	   nCountX--;
	  else if (Math.abs(i-ecke.getIndexZeile()) == 2)
	   nCountX--;
	  else if(Math.abs(i-ecke.getIndexZeile()) == 3)
	   nCountX--;
	 }
	}
	
	public void printSpielfeld(){
		for(int i=0;i<16;i++){
			for(int j=0;j<16;j++){
				if (feld[i][j].getAnfangsSpieler() != null)
				System.out.print(feld[i][j].getAnfangsSpieler().symbol);
			}
			System.out.println();
		}
	}
}
