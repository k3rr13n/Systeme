public class Case {
    
    private Integer intensite;
    private Integer coordX;
    private Integer coordY;

    public Case(Integer intensite, Integer coordX, Integer coordY){
        this.intensite = intensite;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Integer getIntensite(){
        return this.intensite;
    }

    public void setIntensite(Integer intensite){
        this.intensite = intensite;
    }

    public Integer getCoordX(){
        return this.coordX;
    }

    public void setCoordX(Integer coordX){
        this.coordX = coordX;
    }

    public Integer getCoordY(){
        return this.coordY;
    }

    public void setCoordY(Integer coordY){
        this.coordY = coordY;
    }

    public String toString(){
        return Integer.toString(this.intensite);
    }

    public String generalString(){
        return Integer.toString(this.intensite) + ", " + Integer.toString(this.coordX) + ", " + Integer.toString(this.coordY);
    }
}
