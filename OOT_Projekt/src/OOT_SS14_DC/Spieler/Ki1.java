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
public class Ki1 extends Computer {


	public Ki1 (){
	    super(KIgenerator.getKIName()+" (leicht)");
	}
	
    @Override
    public Feld spielsteinWaehlen(Feld[] feld) {
        return feld[(int)Math.random()*(feld.length-1)];
    }

    @Override
    public Feld zielWaehlen(LinkedList<Feld> ziel) {
                    
        
        return ziel.get(0);
    }

}