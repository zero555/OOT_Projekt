package OOT_SS14_DC.Bildschirminteraktion;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.Mensch;
import OOT_SS14_DC.Spieler.Spieler;
import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Feld;
import OOT_SS14_DC.Spielkarton.Spielfeld;


public class Test {

	// zum testen
	private static Feld[] feld=new Feld[13];
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
	// Ab Hier könnte man es in die GameKlasse reinschreiben, bzw eine Methode entwickeln die so ungefähr aussieht
		// Es werden keine Fehler abgefangen! wollte nur demonstrieren dass es geht :P
		// Der Spieler D wird in dem Fall genommen
		System.out.println("Welchen Stein möchten sie bewegen?");
		feld=spiel.getFeldvonSpieler(d);
		for(int i=0;i<feld.length;i++){
			System.out.println("Zeile:"+feld[i].getIndexZeile()+" Spalte:"+ feld[i].getIndexSpalte());
		}
		Scanner scanner= new Scanner(System.in);
		int startZeile = scanner.nextInt();
		int startSpalte= scanner.nextInt();
		Feld[] feld=spiel.spielsteinKannBewegtwerden(startZeile, startSpalte);
		System.out.println("Wohin möchten sie es bewegen?");
		for(int i=0;i<6;i++){
			if(feld[i]!=null)
			System.out.println("Zeile:" +feld[i].getIndexZeile()+" Spalte:"+ feld[i].getIndexSpalte());
		}
		int zielZeile= scanner.nextInt();
		int zielSpalte=scanner.nextInt();
		spiel.spielerAufFeldSetzen(startZeile, startSpalte, null);
		spiel.spielerAufFeldSetzen(zielZeile,zielSpalte, d);
		spiel.printSpielfeld();
	}

}
