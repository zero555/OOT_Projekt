package OOT_SS14_DC.Spieler;
import OOT_SS14_DC.Spielkarton.Ecke;


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
