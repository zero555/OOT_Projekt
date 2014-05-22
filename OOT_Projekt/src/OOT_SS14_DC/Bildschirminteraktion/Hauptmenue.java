package OOT_SS14_DC.Bildschirminteraktion;
import java.util.LinkedList;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.Spieler;

public class Hauptmenue {

	public static LinkedList<Spieler> highscore;

	public static void regelnAusgeben() {
		System.out.println("Regeln");
	}

	public static void spielStarten() {
		Game spiel = new Game();
		spiel.runGame();
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
	            "0 | Spiel beenden              \n" +
	            "---------------------------    \n" +
	            "1 | Spielregeln ausgeben       \n" +
	            "---------------------------    \n" +
	            "2 | Highscore ausgeben         \n" +
	            "---------------------------    \n" +   
	            "---------------------------    \n" +
	            "beliebige Taste:               \n" +   
	            "---------------------------    \n" +
	            "Spiel starten                  \n \n" +
	                
	            " ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~     \n" +
	            "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
	}

	public static void main(String[] args) {

		
		Scanner eingabe = new Scanner(System.in);
		
		int auswahl = 1;
		
		while (auswahl != 0) {
		    printMenue();
		    auswahl = eingabe.nextInt();
			
			switch (auswahl){
			case 0:
			break;
			case 1:
				regelnAusgeben();
			break;
			case 2:
				printHighscore();
			break;
			default:
				spielStarten();
			}
			
		}
		
		eingabe.close();
	}

}