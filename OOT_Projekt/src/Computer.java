public abstract class Computer extends Spieler {

	public Computer(String name){
	    super(name,KIgenerator.getEcke(),KIgenerator.getSymbol());
	}
    
    public int schwierigkeitsgrad;
	

}