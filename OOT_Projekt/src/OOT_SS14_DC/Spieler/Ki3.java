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
public class Ki3 extends Computer {

	public int schwierigkeitsgrad = 3;

	public Ki3 (){
        super(KIgenerator.getKIName()+" (schwer)");
    }
	
	@Override
    public Feld spielsteinWaehlen(Feld[] feld) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Feld zielWaehlen(LinkedList<Feld> ziel) {
        // TODO Auto-generated method stub
        return null;
    }

}