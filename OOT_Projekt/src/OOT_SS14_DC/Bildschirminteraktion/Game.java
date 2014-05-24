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
    
    private int anzahlSpieler = 4;
    
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
	    String symbol = symbolWaehlen();
	    Mensch spieler = new Mensch(name, ecke, symbol);
		return spieler;
	}

	private Computer erstelleKi(String name, int schwierigkeitsgrad) {
	    String symbol = symbolWaehlen();
	    //Computer ki = KIgenerator(name, schwierigkeitsgrad);
	    ///Simon, wie erzeuge ich eine KI??
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
	private void spielerErstellen() {
	    System.out.println("Wie viele Spieler? (2-4)");
	    int tmp = eingabe.nextInt();
	    if(tmp<2) {
	        tmp = 2;
	    }
	    if(tmp>4){
	        tmp = 4;
	    }
        anzahlSpieler = tmp;
        
        //Spielfeld erstellen
        spielfeld = new Spielfeld(anzahlSpieler);
        
        System.out.println("menschlich?");
        int mensch = eingabe.nextInt();
        int menschenZaehler = 0;
        
        for (int i=0; i<anzahlSpieler; i++) {
            System.out.println("Name fuer Spieler " + i );
            String name = eingabe.next();
            Ecke ecke = Ecke.A; //muss geswitchcased werden

            if (menschenZaehler < mensch) {
                teilnehmer[i] = erstelleSpieler(name, ecke);
                menschenZaehler++;
            } else {
                System.out.println("Schwierigkeit fuer Computerspieler waehlen.");
                int schwierig = eingabe.nextInt();
                teilnehmer[i] = erstelleKi(name, schwierig);
            }
        }
        
	}
	private Spieler zufaelligerSpieler() {
	    int zufall = (int)(Math.random()*anzahlSpieler);
	    return teilnehmer[zufall];
	}
	
	private void spielen() {
	    aktuellerSpieler = zufaelligerSpieler();
	    System.out.println(aktuellerSpieler);
	    
	    
	    //gewinner muss zum Schluss gesetzt werden;
	}
	
	public Spieler runGame() {
		spielerErstellen();
		spielen();
		
		//zum Schluss Scanner wieder zu machen.
		eingabe.close();
		return gewinner;
	}

}