package OOT_SS14_DC.Spieler;
import java.util.LinkedList;

import OOT_SS14_DC.Spielkarton.Ecke;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
public class KIgenerator {
    static String name = "Computer ";
    static int nummer = 0;
    static LinkedList<String> symbol;
    static LinkedList<Ecke> ecke;
    
    static String getKIName(){
        nummer++;
        return ""+name+nummer; 
    }
    
    public static void setEcke(LinkedList<Ecke> verfuegbareecke){
        ecke = verfuegbareecke;
    }
    
    static Ecke getEcke(){
        return ecke.remove((int)(Math.random() * ecke.size()));
    }
    
    public static void setSymbol (LinkedList<String> verfuegbaressymbol){
        symbol = verfuegbaressymbol;
    }
    
    static String getSymbol(){
        return symbol.remove((int)(Math.random() * symbol.size()));
    }
    
    
    
}
