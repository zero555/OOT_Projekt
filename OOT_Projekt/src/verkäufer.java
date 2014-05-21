
public class verkäufer {

	public static void main(String[] args) {
		int[][] hallo= new int[1][1];
		Feld[][]feld= new Feld[16][16];
		Spieler spieler1= new Mensch("Verkäufer",Ecke.A,"LOL");
		Spieler spieler2= new Mensch("Verkäufer2",Ecke.D,"LOL");
		Spielfeld käufer= new Spielfeld();
		käufer.spielerSetzen(spieler1.gewaehlteEcke, 2, spieler1);
		käufer.spielerSetzen(spieler2.gewaehlteEcke, 2, spieler2);
		käufer.printSpielfeld();
		
		

	}

}
