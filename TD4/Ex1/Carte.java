import java.util.*;

public class Carte {
    
    // Les matrices
    // private List<List<Integer>> matriceInitial;
    // private List<List<Integer>> matricePropagation;
    private List<List<Case>> matriceInitial;
    private List<List<Case>> matricePropagation;

    // Les petites variables
    private int x;
    private int y;
    private int t;
    

    public Carte(int x, int y){
        this.matriceInitial = new ArrayList<>();
        for(int i=0; i<y; i++){
            List<Case> tempo = new ArrayList<>();
            for(int j=0; j<x; j++){
                Case newCase = new Case(0, x, y);
                tempo.add(newCase);
            }
            this.matriceInitial.add(tempo);
        }

        this.x = x;
        this.y = y;
        this.t = 0;
    }

    public List<Case> getLigne(Integer y){
        return this.matriceInitial.get(y);
    }

    public void initFire(List<Case> lesCases){
        for(int i=0; i<lesCases.size(); i++){
            Integer x = lesCases.get(i).getCoordX();
            Integer y = lesCases.get(i).getCoordY();

            Case uneCase = this.matriceInitial.get(x).get(y);

            this.matriceInitial.get(x).get(y).setIntensite(uneCase.getIntensite()+1);
        }
    }

    public void propager(){
        this.matricePropagation = matriceInitial;
        
    }

    public String toString(){
        String laMatrice = "[";
        for (int i=0; i<this.y; i++){
            for (int j=0; j<this.x; j++){
                if (this.y == i+1 && this.x == j+1){laMatrice += this.getLigne(i).get(j)+"]\n";}
                else if (this.x == j+1){laMatrice += this.getLigne(i).get(j)+"]\n[";}
                else{laMatrice += this.getLigne(i).get(j).toString()+", ";}

            }
        }
        return laMatrice;
    }
}

