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
		spiel.spielerSetzen(Ecke.A, a);
		spiel.spielerSetzen(Ecke.B, b);
		spiel.spielerSetzen(Ecke.C, c);
		spiel.spielerSetzen(Ecke.D, d);
		spiel.printSpielfeld();
	}

}
