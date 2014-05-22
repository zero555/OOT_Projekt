
public class Test {

	// Diese Klasse ist zum Testen  :P
	public static void main(String[] args) {
		Spielfeld spiel= new Spielfeld();
		Spieler a= new Mensch("hallo",Ecke.A,"f");
		Spieler b= new Mensch("hallo",Ecke.D,"e");
		spiel.spielerSetzen(Ecke.A, 2, a);
		spiel.spielerSetzen(Ecke.D,2, b);
		
		//Wenn man den Stein bewegt
		/*spiel.feld[a.Spielsteine[1].indexZeile][a.Spielsteine[1].indexSpalte].setSpieler(null);
		a.Spielsteine[1].indexSpalte=5;
		a.Spielsteine[1].indexZeile=7;
		spiel.feld[7][5].setSpieler(a);
		*/
		spiel.printSpielfeld();
	}

}
