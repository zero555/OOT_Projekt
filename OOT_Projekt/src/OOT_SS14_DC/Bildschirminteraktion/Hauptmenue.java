package OOT_SS14_DC.Bildschirminteraktion;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.Spieler;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
public class Hauptmenue {

	public static LinkedList<Spieler> highscore = new LinkedList<Spieler>();
	private static Scanner eingabe;

	public static void regelnAusgeben() {
		System.out.println("Regeln");
	}

	public static void spielStarten() {
	    System.out.println("Wie viele Spieler? (2-4)"+ 
                "\n Beliebige Taste fuer 2 Spieler.");
	    int anzahl;
        try {
            anzahl = eingabe.nextInt();
        } catch (InputMismatchException ex) {
            anzahl = 2;
        }
        if(anzahl<2) {
            anzahl = 2;
        }
        if(anzahl>4){
            anzahl = 4;
        }
        System.out.println(anzahl + " Spieler gewaehlt.");
		Game spiel = new Game(anzahl);
		highscore.add(spiel.runGame());
	}
	
	public static void printHighscore() {
		System.out.println(highscore);
	}
	
	public static void printMenue() {
	    System.out.println( "~ ~ ~ ~ HAUPTMENU ~ ~ ~ ~ \n" +
	            "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~        \n \n" +

	            "---------------------------    \n" +
	            "Geben Sie ein:                 \n" +
	            "---------------------------    \n" +
	            "exit  |  Spiel beenden              \n" +
	            "---------------------------    \n" +
	            "1     |  Spielregeln ausgeben       \n" +
	            "---------------------------    \n" +
	            "2     |  Highscore ausgeben         \n" +
	            "---------------------------    \n" +   
	            "---------------------------    \n" +
	            "beliebige Taste:               \n" +   
	            "---------------------------    \n" +
	            "Spiel starten                  \n \n" +
	                
	            " ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~     \n" +
	            "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
	}

	public static void main(String[] args) {
	    eingabe = new Scanner(System.in);

		
		String auswahl = "";
		
		while (!auswahl.equals("exit")) {
		    printMenue();
		    auswahl = eingabe.next();
			
			switch (auswahl){
			case "exit":
			break;
			case "1":
				regelnAusgeben();
			break;
			case "2":
				printHighscore();
			break;
			default:
				spielStarten();
			}
			
		}
		
		eingabe.close();
	}

}