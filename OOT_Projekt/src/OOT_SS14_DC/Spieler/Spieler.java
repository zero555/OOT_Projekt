package OOT_SS14_DC.Spieler;
import OOT_SS14_DC.Spielkarton.Ecke;
import OOT_SS14_DC.Spielkarton.Feld;
import OOT_SS14_DC.Spielkarton.Spielstein;

public abstract class Spieler {

    protected Ecke gewaehlteEcke;
    protected String symbol;
    protected String name;
    protected int getaetigteZuege;
    private Spielstein[] spielsteintuete;
    
    
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
    
    public void setSpielsteintuete(int laenge){
    	spielsteintuete=new Spielstein[laenge];
    }

    /**
     * @return the spielsteintuete
     */
    public Spielstein[] getSpielsteintuete() {
        return spielsteintuete;
    }

    /**
     * @param spielsteintuete the spielsteintuete to set
     */
    public void setSpielsteintuete(Spielstein[] spielsteintuete) {
        this.spielsteintuete = spielsteintuete;
    }

    public String getSymbol() {
        return symbol;
    }
}