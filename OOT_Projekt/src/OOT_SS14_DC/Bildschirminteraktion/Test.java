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
		
		//Wenn man den Stein bewegt
		/*spiel.feld[a.Spielsteine[1].indexZeile][a.Spielsteine[1].indexSpalte].setSpieler(null);
		a.Spielsteine[1].spielsteinBewegen(7,5)
		spiel.feld[7][5].setSpieler(a);
		*/
		spiel.printSpielfeld();
	}

}
