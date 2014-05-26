package OOT_SS14_DC.Spieler;
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
    
    static String getKIName(){
        nummer++;
        return ""+name+nummer; 
    }
    
    static Ecke getEcke(){
		return null;
        
    }
    
    static String getSymbol(){
		return name;
        
    }
    
}
