public class Moteur {
    
    private String moteur;
    private int noSerie;

    public Moteur(String moteur, int noSerie){
        this.moteur = moteur;
        this.noSerie = noSerie;
    }
    
    public String toString(){
        return this.moteur + " n°" + this.noSerie;
    }
}
