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

/**leichte KI
 * 
 * @see Computer
 */
public class Ki1 extends Computer {

    /**<pre>Konstruktor leichte KI</pre>
     * 
     * @see Computer
     */
	public Ki1 (){
	    super(KIgenerator.getKIName()+" (leicht)");
	}
	
	/**
     * @see Computer
     * @see Spieler
     */
	@Override
    public Feld spielsteinWaehlen(Feld[] feld) {
        if (getaetigteZuege%3 == 0 ){
            return null;
        }
        
        return feld[(int)(Math.random()*(feld.length))];
    }
	
	/**
     * @see Computer
     * @see Spieler
     */
    @Override
    public Feld zielWaehlen(LinkedList<Feld> ziel) {
                    
        
        if (ziel.size() == 0){
            return null;
        } else{
            if(ziel.size()>2){
                int zufall = (int)(Math.random()*3);
                return ziel.get(zufall);
            }
            return ziel.get(0);
        }
        
    }

}