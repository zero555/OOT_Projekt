public abstract class Spieler {

    protected Ecke gewaehlteEcke;
    protected String symbol;
    protected String name; int getaetigteZuege;	//Absicht??
    protected Spielstein[] Spielsteine;
    
    
    public Spieler(String name,Ecke ecke, String symbol){
        this.gewaehlteEcke = ecke;
        this.symbol = symbol;
        this.name = name;
        this.getaetigteZuege = 0; 
        
    }
    
    public abstract void spielsteinWaehlen();

    protected abstract void zielWaehlen(Feld startposition) ;

    protected boolean zielErreicht() {
        return false;
    }

}