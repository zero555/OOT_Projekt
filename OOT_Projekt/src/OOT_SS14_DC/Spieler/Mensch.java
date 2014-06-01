package OOT_SS14_DC.Spieler;

import java.util.*;

import OOT_SS14_DC.Spielkarton.*;

public class Mensch extends Spieler {

    public Mensch(String Name, Ecke ecke, String symbol) {
        super(Name, ecke, symbol);
    }

    @Override
    public Feld spielsteinWaehlen(Feld[] feld) {
        int wahlmöglichkeit = 2;
        System.out.println("1 Aussetzen");
        for (Feld iterator : feld) {
        System.out.println(wahlmöglichkeit +" "+  (iterator.getIndexZeile() + 1)
                + "/"+ (iterator.getIndexSpalte() +1));
        wahlmöglichkeit++;
        }
        System.out.println("Bitte Spielstein auswählen der bewegt werden soll");
        Scanner eingabe = new Scanner(System.in);
        int auswahl;
        try{
        auswahl = eingabe.nextInt();
        }catch(InputMismatchException ex){
            auswahl = -1;
        }
        while (auswahl <= 0 || auswahl > wahlmöglichkeit) {
            System.out.println("Es wurde kein gültiger Spielstein gewählt,"
                    + " versuchen sie es erneut");
            try{
                auswahl = eingabe.nextInt();
            }catch(InputMismatchException ex){
                auswahl = -1;
            }
        }
        
        if(auswahl == 1){
            return null;
        }else{
            return feld[auswahl-2];
        }
    }

    
    @Override
    public Feld zielWaehlen(LinkedList<Feld> ziel) {
    	
        
        
        int wahlmöglichkeit = 2;
        System.out.println("1 neuen Spielstein wählen");
        for (Feld iterator : ziel) {
        System.out.println(wahlmöglichkeit +" "+  (iterator.getIndexZeile() + 1)
                + "/"+ (iterator.getIndexSpalte()+1));
        wahlmöglichkeit++;
        }
        System.out.println("wohin soll der Stein bewegt werden?");
        Scanner eingabe = new Scanner(System.in);
        
        int auswahl;
        try{
            auswahl = eingabe.nextInt();
        }catch(InputMismatchException ex){
            auswahl = -1;
        }
        while (auswahl <= 0 || auswahl > wahlmöglichkeit) {
            System.out.println("Es wurde kein gültiger Ziel gewählt,"
                    + " versuchen sie es erneut");
            try{
                auswahl = eingabe.nextInt();
            }catch(InputMismatchException ex){
                auswahl = -1;
            }
        }
        
        
        if(auswahl == 1){
            return null;
        }else{
            return ziel.get(auswahl-2);
        }
        
    }
       
        
}
