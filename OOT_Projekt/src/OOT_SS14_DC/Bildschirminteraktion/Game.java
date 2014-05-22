package OOT_SS14_DC.Bildschirminteraktion;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.Computer;
import OOT_SS14_DC.Spieler.Mensch;
import OOT_SS14_DC.Spieler.Spieler;
import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Feld;

public class Game {

	public Spieler[] teilnehmer;

	public Feld[][] spielfeld;

	public Spieler aktuellerSpieler;

	public Game() {
		spielfeld = new Feld[16][16];
	}
	
	private void startpositionEinnehmen() {
		//spielsteine verteilen
	}

	private void printSpielfeld() {
		
	}

	private Mensch erstelleSpieler(String name, Ecke ecke) {
		return null;
	}

	private Computer erstelleKi(String name, int schwierigkeitsgrad) {
		return null;
	}

	public void runGame() {
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Wie viele Spieler?");
		int spieler = eingabe.nextInt();
		System.out.println("menschlich?");
		int mensch = eingabe.nextInt();
		int menschenZaehler = 0;
		
		for (int i=0; i<spieler; i++) {
			System.out.println("Name f�r Spieler " + i );
			String name = eingabe.next();
			Ecke ecke = Ecke.A;	//muss geswitchcased werden

			if (menschenZaehler < mensch) {
//				teilnehmer[i] = erstelleSpieler(name, ecke);
				menschenZaehler++;
			} else {
				System.out.println("Schwierigkeit f�r Computerspieler waehlen.");
				int schwierig = eingabe.nextInt();
//			teilnehmer[i] = erstelleKi(name, schwierig);
			}

		}
			
	}

}