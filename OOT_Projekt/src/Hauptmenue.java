import java.util.LinkedList;
import java.util.Scanner;

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

	public static void main(String[] args) {

		
		Scanner eingabe = new Scanner(System.in);
		
		int auswahl = 1;
		
		while (auswahl != 0) {
			System.out.println("Was tun?");
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