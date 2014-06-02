package OOT_SS14_DC.Bildschirminteraktion;

import java.util.InputMismatchException;
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

	private Queue<Spieler> teilnehmer = new LinkedList<Spieler>();

	private Spielfeld spielfeld;

	private Spieler aktuellerSpieler;
    
    private Scanner eingabe;
    
    private int anzahlSpieler;
    
    private LinkedList<String> symbol = new LinkedList<String>();
    
    private LinkedList<Ecke> gewaehlteEcken = new LinkedList<Ecke>();

    private LinkedList<Ecke> freieEcken = new LinkedList<Ecke>();
    
    /**
     * Game-Konstruktor,
     * es sollte jetzt die runGame()-Methode ausgefuert werden
     */
	public Game(int anzahlSpieler) {
	    eingabe = new Scanner(System.in);
	    this.anzahlSpieler = anzahlSpieler;
	    
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
	    
	    if(anzahlSpieler > 2){
	          freieEcken.add(Ecke.B);
	          freieEcken.add(Ecke.C);
	    }
	    
	    freieEcken.add(Ecke.A);
	    freieEcken.add(Ecke.D);
	}
	
    
    /**
     * neuer Spieler wird erstellt
     * @param name  gewaehlter Name
     * @param ecke  gewaehlte Ecke
     * @return      erstellter Spieler
     */
	private Mensch erstelleMensch(String name, Ecke ecke) {
	    String symbol = symbolWaehlen();
	    Mensch spieler = new Mensch(name, ecke, symbol);
	    spielfeld.spielerSetzen(spieler.getGewaehlteEcke(),spieler);
	    spieler.setZielEcke(spielfeld.zielEckeSetzen(spieler.getGewaehlteEcke()));
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
	    spielfeld.spielerSetzen(ki.getGewaehlteEcke(),ki);
	    ki.setZielEcke(spielfeld.zielEckeSetzen(ki.getGewaehlteEcke()));
		return ki;
	}
	
	/**
	 * man kann aus verschiedenen Symbolen waehlen
	 * @return gewaehltes Symbol
	 */
	private String symbolWaehlen() {

	    System.out.println("Waehlen Sie ihr Symbol (Eingabe einer Zahl)" + 
	            "\n Beliebige Taste fuer zufaelliges Symbol.");

	    System.out.println(symbol);
	    
	    int position;
	    

	    try {
	        position = eingabe.nextInt();
	        return symbol.remove(position-1);
	    } catch (InputMismatchException | IndexOutOfBoundsException ex){
	        position = (int)(Math.random() * symbol.size());
	        return symbol.remove(position);
	    }
	}
	
	
	/**
	 * hier wird abgefragt, wer alles mitspielt
	 * @return Gewinner des aktuellen Spiels
	 */
	private void spielerErstellen() {
        
        //Spielfeld erstellen
        spielfeld = new Spielfeld(anzahlSpieler);
        
        System.out.println("Wie viele davon menschlich?"+ 
                "\n Beliebige Taste fuer 1 Menschen.");
        int mensch;
        try {
            mensch = eingabe.nextInt();
        } catch (InputMismatchException ex) {
            mensch = 1;
        }
        int menschenZaehler = 0;
        
        if (mensch > anzahlSpieler) {
            mensch = anzahlSpieler;
            System.out.println("Es koennen nicht mehr Menschen als Spieler " +
                    "mitspielen.");
        }
        System.out.println(mensch + " menschliche(r) Spieler gewaehlt.");
        
        for (int i=0; i<anzahlSpieler; i++) {

            if(mensch == 0){
                KIgenerator.setSymbol(this.symbol);
                KIgenerator.setEcke(freieEcken);
            }
            
            if (menschenZaehler < mensch) {
                System.out.println("Name fuer Spieler " + (i+1) );
                String name = eingabe.next();
                Ecke ecke = eckeWaehlen();
                teilnehmer.add(erstelleMensch(name, ecke));
                menschenZaehler++;
                KIgenerator.setSymbol(this.symbol);
                KIgenerator.setEcke(freieEcken);
            } else {
                System.out.println("Schwierigkeit fuer Computerspieler waehlen.");
                int schwierig = eingabe.nextInt();
                teilnehmer.add(erstelleKi(schwierig));
            }
        }
        
	}
	


    //CAVE: 2 Spieler --> gegenueberliegende Ecken!
	private Ecke eckeWaehlen() {
	  Ecke gewaehlt; 
	  int index;
	  
	  do {
          System.out.println("Waehlen Sie eine Ecke.");
          System.out.println(freieEcken);
          String auswahl = eingabe.next();
          index = indxDerEckeInListeFinden(auswahl);
      } while (index < 0);
      
      gewaehlt = freieEcken.remove(index);
      
      
	  return gewaehlt;
	}

    private int indxDerEckeInListeFinden(String auswahl) {
        int index;
        switch (auswahl.toUpperCase()) {
        case "A":
            index = freieEcken.indexOf(Ecke.A);
        break;
        case "B":
            index = freieEcken.indexOf(Ecke.B);
        break;
        case "C":
            index = freieEcken.indexOf(Ecke.C);
        break;
        case "D":
            index = freieEcken.indexOf(Ecke.D);
        break;
        default:
            index = -1;
        }
        return index;
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
	    Feld[] aktuelleSpielsteintuete; //wird sofort ueberschrieben
	    Feld gewählterSpielstein;
	    LinkedList<Feld> alleZiele;
	    Feld ziel;
	    
	    do {
	        
	        spielfeld.printSpielfeld();
	        //der Spieler wird zuerst weitergezaehlt, damit die Abfrage
	        //im while() funktioniert.
	        aktuellerSpieler = naechsterSpieler();
	        //zählt getätigte züge weiter
	        aktuellerSpieler.nächsterunde();
	        //Spielfeld gibt zurueck, wo die Steine des aktuellenSpielers sind
            aktuelleSpielsteintuete = spielfeld.getFeldvonSpieler(aktuellerSpieler);
            //aus diesen Steinen waehlt er einen zum Ziehen.
            System.out.println("aktuellerSpieler: "+ aktuellerSpieler);
            gewählterSpielstein = aktuellerSpieler.spielsteinWaehlen(aktuelleSpielsteintuete);
            while(gewählterSpielstein != null){
                //alle möglichen ziele werden ermittelt
                alleZiele = spielfeld.feldersuchen(gewählterSpielstein.getIndexZeile()
                        ,gewählterSpielstein.getIndexSpalte());
                //die neuen Positionen werden uebergeben
                ziel = aktuellerSpieler.zielWaehlen(alleZiele);
                if(ziel == null){
                    gewählterSpielstein = aktuellerSpieler.spielsteinWaehlen(aktuelleSpielsteintuete);
                }else{
 //Ersetzen durch zweimal spielerBewegen
                    spielfeld.spielerSteinBewegen(gewählterSpielstein,ziel,aktuellerSpieler);
                    gewählterSpielstein = null;
                }
            }
            
            
            //neue Spielsteinpositionen werden übergeben
            aktuelleSpielsteintuete = spielfeld.getFeldvonSpieler(aktuellerSpieler);
            
        } while(!aktuellerSpieler.zielErreicht(aktuelleSpielsteintuete)); 

	    spielfeld.printSpielfeld();
	    System.out.println(aktuellerSpieler +" hat mit "+ aktuellerSpieler.getZuege()
	            +" Zügen Gewonnen !");
	    return aktuellerSpieler;
	}
	
	public Spieler runGame() {
		spielerErstellen();
		System.out.println(teilnehmer);
		Spieler gewinner = spielen();
		

		return gewinner;
	}

}