public class Roue {
    
    private String roue;
    private int noSerie;

    public Roue(String roue, int noSerie){
        this.roue = roue;
        this.noSerie = noSerie;
    }
   
    public String toString(){
        return this.roue + " n°" + this.noSerie;
    }
}
