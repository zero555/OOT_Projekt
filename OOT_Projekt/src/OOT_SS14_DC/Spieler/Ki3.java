package OOT_SS14_DC.Spieler;
import java.util.LinkedList;

import OOT_SS14_DC.Spielkarton.Feld;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
/**schwere KI
 * 
 * @see Computer
 */

public class Ki3 extends Computer {
    
    
    /**<pre>Konstruktor schwere KI</pre>
     * 
     * @see Computer
     */
    
    public Ki3 (){
        super(KIgenerator.getKIName()+" (schwer)");
    }
	
    /**
     * @see Computer
     * @see Spieler
     */
	@Override
    public Feld spielsteinWaehlen(Feld[] feld) {
        return feld[(int)(Math.random()*(feld.length))];
    }

	/**
     * @see Computer
     * @see Spieler
     */
    @Override
    public Feld zielWaehlen(LinkedList<Feld> ziel) {
                  
        if(ziel.size() == 0){
            return null;
        }else{
            return ziel.getLast();
        }
        
    }

}