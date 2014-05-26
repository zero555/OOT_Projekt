package OOT_SS14_DC.Spieler;
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
    public void spielsteinWaehlen() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void zielWaehlen(Feld startposition) {
        // TODO Auto-generated method stub
        
    }

}