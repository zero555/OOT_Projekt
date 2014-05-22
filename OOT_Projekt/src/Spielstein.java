
public class Spielstein {

    public Feld feld;
    public Spieler zugehoerigerSpieler;
    
    public Spielstein (Feld feld, Spieler zugehoerigerSpieler){
        this.feld = feld;
        this.zugehoerigerSpieler = zugehoerigerSpieler;
    }
    
    public Feld[] moeglicheZuege(){
        return null;
    }
    
    protected void spielsteinBewegen(Feld startposition, Feld zielposition) {
        // TODO Auto-generated method stub
        
    }
}
