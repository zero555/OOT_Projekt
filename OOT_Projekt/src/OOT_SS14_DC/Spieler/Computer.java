package OOT_SS14_DC.Spieler;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */
public abstract class Computer extends Spieler {

	public Computer(String name){
	    super(name,KIgenerator.getEcke(),KIgenerator.getSymbol());
	}
	

}