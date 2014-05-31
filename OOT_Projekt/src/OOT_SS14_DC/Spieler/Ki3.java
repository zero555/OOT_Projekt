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
    
    Feld besterZug = null;
    int besterSpielstein = 0;
    int aktuellerSpielstein = 0;


	public Ki3 (){
        super(KIgenerator.getKIName()+" (schwer)");
    }
	
	private boolean bessererZug(Feld alterZug,Feld vergleichsZug){
	    if((vergleichsZug.getIndexZeile()-alterZug.getIndexZeile())*this.gewaehlteEcke.getRichtungSenkrecht() >= 0
	            &&vergleichsZug.getIndexSpalte()-alterZug.getIndexSpalte()*this.getGewaehlteEcke().getRichtungWaagerecht()>= 0){
	        return true;
	    }else{
	        return false;
	    }
	    
	    
	}
	
	@Override
    public Feld spielsteinWaehlen(Feld[] feld) {
        
        if (aktuellerSpielstein < feld.length){
            return feld[aktuellerSpielstein];
        }else{
            aktuellerSpielstein = -1;
            return feld[besterSpielstein];
        }
    }

    @Override
    public Feld zielWaehlen(LinkedList<Feld> ziel) {
                    
       if (aktuellerSpielstein == 0|besterZug==null){
          if(ziel.size()>0){
              besterZug = ziel.getFirst();
          }else{
              return null;
          }
       }
        
       if (ziel.size() == 0|aktuellerSpielstein != -1){
            
            for(Feld f:ziel){
                if(bessererZug(besterZug,f)){
                    besterZug = f;
                    besterSpielstein = aktuellerSpielstein; 
                }
            }
            
            aktuellerSpielstein++;
            return null;
        
        } else {        
            aktuellerSpielstein++;
            return besterZug;
            
        }
        
    }

}