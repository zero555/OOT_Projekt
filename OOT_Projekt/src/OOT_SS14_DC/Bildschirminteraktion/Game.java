package OOT_SS14_DC.Bildschirminteraktion;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.*;
import OOT_SS14_DC.Spielkarton.*;

public class Game {

	private Spieler[] teilnehmer;

	private Spielfeld spielfeld;

	private Spieler aktuellerSpieler;

    private Spieler gewinner;  //kann später wieder gelöscht werden??
    
    private Scanner eingabe;
    
    /**
     * Game-Konstruktor,
     * es sollte jetzt die runGame()-Methode ausgefuert werden
     */
	public Game() {
	    eingabe = new Scanner(System.in);
	    teilnehmer = new Spieler[4];
	    
	    gewinner = new Mensch(null, null, null); //kann später auch wieder gelöscht werden
	    
	}
	
    
    /**
     * neuer Spieler wird erstellt
     * @param name  gewaehlter Name
     * @param ecke  gewaehlte Ecke
     * @return      erstellter Spieler
     */
	private Mensch erstelleSpieler(String name, Ecke ecke) {
	    System.out.println("Bitte ein Symbol wählen.");
	    String symbol = symbolWaehlen();
	    Mensch spieler = new Mensch(name, ecke, symbol);
		return spieler;
	}

	private Computer erstelleKi(String name, int schwierigkeitsgrad) {
		return null;
	}
	
	/**
	 * man kann aus verschiedenen Symbolen waehlen
	 * @return gewaehltes Symbol
	 */
	private String symbolWaehlen() {
	    String[] symbole = {"@","®","©","§","♠","♣","♥","♦","☺","☻"};
	    System.out.println("Waehlen Sie ihr Symbol (Eingabe einer Zahl)");

	    for(int i=0; i<symbole.length; i++) {
	        System.out.println(i + ": " + symbole[i]);
	    }
	    
	    return symbole[eingabe.nextInt()];
	}
	
	
	/**
	 * hier wird abgefragt, wer alles mitspielt
	 * @return Gewinner des aktuellen Spiels
	 */
	public Spieler runGame() {
		System.out.println("Wie viele Spieler?");
		int spielerZahl = eingabe.nextInt();
		
		//Spielfeld erstellen
		spielfeld = new Spielfeld(spielerZahl);
		
		System.out.println("menschlich?");
		int mensch = eingabe.nextInt();
		int menschenZaehler = 0;
		
		for (int i=0; i<spielerZahl; i++) {
			System.out.println("Name fuer Spieler " + i );
			String name = eingabe.next();
			Ecke ecke = Ecke.A;	//muss geswitchcased werden

			if (menschenZaehler < mensch) {
				teilnehmer[i] = erstelleSpieler(name, ecke);
				menschenZaehler++;
			} else {
				System.out.println("Schwierigkeit fuer Computerspieler waehlen.");
				int schwierig = eingabe.nextInt();
			teilnehmer[i] = erstelleKi(name, schwierig);
			}
		}
		
		
		
		//zum Schluss Scanner wieder zu machen.
		eingabe.close();
		return gewinner;
	}

}