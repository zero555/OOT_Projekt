package OOT_SS14_DC.Bildschirminteraktion;
import java.util.LinkedList;
import java.util.Scanner;

import OOT_SS14_DC.Spieler.Spieler;

public class Hauptmenue {

	public static LinkedList<Spieler> highscore = new LinkedList<Spieler>();

	public static void regelnAusgeben() {
		System.out.println("Regeln");
	}

	public static void spielStarten() {
		Game spiel = new Game();
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

	    spielStarten();
	//funktioniert, aber nervt beim Testen	
/*		Scanner eingabe = new Scanner(System.in);
		
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
*/	}

}