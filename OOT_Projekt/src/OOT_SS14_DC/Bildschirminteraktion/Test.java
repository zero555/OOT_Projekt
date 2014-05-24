package OOT_SS14_DC.Bildschirminteraktion;
import OOT_SS14_DC.Spieler.Mensch;
import OOT_SS14_DC.Spieler.Spieler;
import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Spielfeld;


public class Test {

	// Diese Klasse ist zum Testen  :P
	public static void main(String[] args) {
		Spielfeld spiel= new Spielfeld(4);
		Spieler a= new Mensch("hallo",Ecke.A,"A");
		a.setZielEcke(spiel.zielEckeSetzen(a.getGewaehlteEcke()));
		Spieler b= new Mensch("hallo",Ecke.B,"B");

		
		Spieler c= new Mensch("hallo",Ecke.C,"+");
		Spieler d= new Mensch("hallo",Ecke.D,"D");
		spiel.spielerSetzen(Ecke.A, 4, a);
		spiel.spielerSetzen(Ecke.B,4, b);
		spiel.spielerSetzen(Ecke.C, 4, c);
		spiel.spielerSetzen(Ecke.D,4, d);
		
		//Alle Steine Von Spieler 1 zum ZielEck übertragen
		/*for(int i=0;i<a.getSpielsteintuete().length;i++){
			spiel.feld[a.getSpielsteintuete()[i].indexZeile][a.getSpielsteintuete()[i].indexSpalte].setSpieler(null);
			a.getSpielsteintuete()[i].spielsteinBewegen(spiel.eckeD[i].getIndexZeile(),spiel.eckeD[i].getIndexSpalte());
			spiel.feld[spiel.getEcke(Ecke.D)[i].getIndexZeile()][spiel.getEcke(Ecke.D)[i].getIndexSpalte()].setSpieler(a);
		}
		
		boolean erreicht= a.zielEreicht();
		if(erreicht)
			System.out.println("Ziel erreicht!");
		//Wenn man den Stein bewegt
		/*spiel.feld[a.Spielsteine[1].indexZeile][a.Spielsteine[1].indexSpalte].setSpieler(null);
		a.Spielsteine[1].spielsteinBewegen(7,5)
		spiel.feld[7][5].setSpieler(a);
		*/
		spiel.printSpielfeld();
	}

}
