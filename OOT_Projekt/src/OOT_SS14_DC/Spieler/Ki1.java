package OOT_SS14_DC.Spieler;
import OOT_SS14_DC.Spielkarton.Feld;

public class Ki1 extends Computer {

	public int schwierigkeitsgrad = 1;

	public Ki1 (){
	    super(KIgenerator.getKIName()+" (leicht)");
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