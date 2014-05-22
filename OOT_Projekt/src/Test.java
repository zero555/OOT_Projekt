
public class Test {

	// Diese Klasse ist zum Testen  :P
	public static void main(String[] args) {
		Spielfeld spiel= new Spielfeld();
		Spieler a= new Mensch("hallo",Ecke.A,"A");
		Spieler b= new Mensch("hallo",Ecke.B,"B");
		
		Spieler c= new Mensch("hallo",Ecke.C,"C");
		Spieler d= new Mensch("hallo",Ecke.D,"D");
		
		spiel.spielerSetzen(Ecke.A, 4, a);
		spiel.spielerSetzen(Ecke.B,4, b);
		spiel.spielerSetzen(Ecke.C, 4, c);
		spiel.spielerSetzen(Ecke.D,4, d);
		
		//Wenn man den Stein bewegt
		/*spiel.feld[a.Spielsteine[1].indexZeile][a.Spielsteine[1].indexSpalte].setSpieler(null);
		a.Spielsteine[1].indexSpalte=5;
		a.Spielsteine[1].indexZeile=7;
		spiel.feld[7][5].setSpieler(a);
		*/
		spiel.printSpielfeld();
	}

}
