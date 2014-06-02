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

/**mittelschwere KI
 * 
 * @see Computer
 */
public class Ki2 extends Computer {


    /**<pre>Konstruktor mittelschwere KI</pre>
     * 
     * @see Computer
     */
    public Ki2 (){
        super(KIgenerator.getKIName()+" (mittel)");
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
                int zufall = (int)(Math.random()*ziel.size());
                return ziel.get(zufall);
        }
        
    }

}