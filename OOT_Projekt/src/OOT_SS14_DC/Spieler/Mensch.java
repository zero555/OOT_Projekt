package OOT_SS14_DC.Spieler;

import java.util.*;

import OOT_SS14_DC.Spielkarton.*;

public class Mensch extends Spieler {

    public Mensch(String Name, Ecke ecke, String symbol) {
        super(Name, ecke, symbol);
    }

    @Override
    public void spielsteinWaehlen() {
        int wahlmöglichkeit = 2;
        System.out.println("1 Aussetzen");
        for (Feld iterator : this.getSpielsteintuete()) {
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
        while (auswahl <= 0 || auswahl >= wahlmöglichkeit) {
            System.out.println("Es wurde kein gültiger Spielstein gewählt,"
                    + " versuchen sie es erneut");
            try{
                auswahl = eingabe.nextInt();
            }catch(InputMismatchException ex){
                auswahl = -1;
            }
        }
        eingabe.close();
        
        if(auswahl == 1){
        }else{
            zielWaehlen(this.getSpielsteintuete()[auswahl - 2]);
        }
    }

    
    @Override
    protected void zielWaehlen(Feld startposition) {
        LinkedList<Feld> ziel = startposition.moeglicheZuege();
        
        int wahlmöglichkeit = 3;
        System.out.println("1 Aussetzen");
        System.out.println("2 neuen Spielstein wählen");
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
        while (auswahl <= 0 || auswahl >= wahlmöglichkeit) {
            System.out.println("Es wurde kein gültiger Ziel gewählt,"
                    + " versuchen sie es erneut");
            try{
                auswahl = eingabe.nextInt();
            }catch(InputMismatchException ex){
                auswahl = -1;
            }
        }
        eingabe.close();
        
        if(auswahl == 1){
        }else if(auswahl == 2) {
            this.spielsteinWaehlen();
        }else{
            startposition.spielsteinBewegen(ziel.get(auswahl-3).getIndexZeile()
                    ,ziel.get(auswahl-3).getIndexSpalte());
        }

    }

}