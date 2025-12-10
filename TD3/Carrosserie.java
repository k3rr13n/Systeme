public class Carrosserie {
    
    private String carrosserie;
    private int noSerie;

    public Carrosserie(String carrosserie, int noSerie){
        this.carrosserie = carrosserie;
        this.noSerie = noSerie;
    }
    
    public String toString(){
        return this.carrosserie + " n°" + this.noSerie;
    }
}
