package OOT_SS14_DC.Spieler;
/**
 * 
 * @author Dominik Meixner 1324227
 * @author Deniz Tas 1320360
 * @author Simon Sauerzapf 1320341
 *
 */

/**Die Klasse repräsentiert einen Computerspieler, Es gibt verschiedene Schwirigkeitsgrade
 * 
 * 
 *
 */
public abstract class Computer extends Spieler {

	/**Konstruktor ermöglicht parameterlose inizialisierung einer KI
	 * 
	 * @param name wird normalerweiße von explizieter KI übergeben
	 */
    public Computer(String name){
	    super(name,KIgenerator.getEcke(),KIgenerator.getSymbol());
	}
	

}