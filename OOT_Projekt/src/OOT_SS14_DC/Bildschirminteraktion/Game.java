package OOT_SS14_DC.Bildschirminteraktion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.*;
import OOT_SS14_DC.Spielkarton.*;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
public class Game {

	private Queue<Spieler> teilnehmer;

	private Spielfeld spielfeld;

	private Spieler aktuellerSpieler;
    
    private Scanner eingabe;
    
    private int anzahlSpieler;
    
    /**
     * Game-Konstruktor,
     * es sollte jetzt die runGame()-Methode ausgefuert werden
     */
	public Game(int anzahlSpieler) {
	    eingabe = new Scanner(System.in);
	    this.anzahlSpieler = anzahlSpieler;	    
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

	private Computer erstelleKi(int schwierigkeitsgrad) {
	    Computer ki;
	    switch (schwierigkeitsgrad) {
	    case 1:
	        ki = new Ki1();
	    break;
	    case 2:
	        ki = new Ki2();
	    break;
	    default:
	        System.out.println("Muhaha!! Schwieriger Gegner wird erstellt.");
	        ki = new Ki3();
	    }
	    //Ki muss Symbol bekommen!
		return ki;
	}
	
	/**
	 * man kann aus verschiedenen Symbolen waehlen
	 * @return gewaehltes Symbol
	 */
	private String symbolWaehlen() {
	    LinkedList<String> symbol = new LinkedList<String>();

	    symbol.add("@"); 
	    symbol.add("®"); 
	    symbol.add("©"); 
	    symbol.add("§"); 
	    symbol.add("♠"); 
	    symbol.add("♣"); 
	    symbol.add("♥"); 
	    symbol.add("♦"); 
        symbol.add("☺"); 
        symbol.add("☻"); 

	    System.out.println("Waehlen Sie ihr Symbol (Eingabe einer Zahl)" + 
	            "\n Beliebige Taste fuer zufaelliges Symbol.");

	    System.out.println(symbol);
	    
	    //hier Fehler abfangen --> Zufall!
	    int position = eingabe.nextInt();
	    
	    //sonst
	    //position = (int)(Math.random() * symbol.size());
	    
	    return symbol.remove(position);
	}
	
	
	/**
	 * hier wird abgefragt, wer alles mitspielt
	 * @return Gewinner des aktuellen Spiels
	 */
	private void spielerErstellen() {
        
        //Spielfeld erstellen
        spielfeld = new Spielfeld(anzahlSpieler);
        
        System.out.println("menschlich?");
        int mensch = eingabe.nextInt();
        int menschenZaehler = 0;
        
        for (int i=0; i<anzahlSpieler; i++) {
            System.out.println("Name fuer Spieler " + i );
            String name = eingabe.next();
            Ecke ecke = Ecke.A; //muss geswitchcased werden //auch auf Feld setzen

            if (menschenZaehler < mensch) {
                teilnehmer.add(erstelleSpieler(name, ecke));
                menschenZaehler++;
            } else {
                System.out.println("Schwierigkeit fuer Computerspieler waehlen.");
                int schwierig = eingabe.nextInt();
                teilnehmer.add(erstelleKi(schwierig));
            }
        }
        
	}
	
	private Spieler naechsterSpieler() {
	    Spieler tmp = teilnehmer.poll();
	    teilnehmer.add(tmp);
	    return tmp;
	}
	
	private Spieler zufaelligerSpieler() {
	    int zufall = (int)(Math.random()*anzahlSpieler);
	    
	    Spieler tmp = teilnehmer.peek();
	    
	    for (int i = 0; i<zufall; i++) {
	        tmp = naechsterSpieler();
	    }
	    
	    return tmp;
	}
	
	private Spieler spielen() {
	    aktuellerSpieler = zufaelligerSpieler();
	    System.out.println(aktuellerSpieler);
	    
	    do {
	        aktuellerSpieler = naechsterSpieler();
	        aktuellerSpieler.spielsteinWaehlen();
        } while(!aktuellerSpieler.zielErreicht());
	    
	    return aktuellerSpieler;
	    
	    //gewinner muss zum Schluss gesetzt werden;
	}
	
	public Spieler runGame() {
		spielerErstellen();
		Spieler gewinner = spielen();
		
		//zum Schluss Scanner wieder zu machen.
		eingabe.close();
		return gewinner;
	}

}