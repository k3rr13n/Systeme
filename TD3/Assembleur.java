import java.util.ArrayList;
import java.util.List;

public class Assembleur extends Thread{
    
    // La liste des pieces pour une voiture
    List<Carrosserie> carrosseries;
    List<Moteur> moteurs;
    List<Roue> roues;

    // Le nombre d'unité maximal de chaques pieces
    int maxC;
    int maxM;
    int maxR;

    int noVoiture;

    // L'usine
    Usine usine;

    public Assembleur(Usine usine){
        this.carrosseries = new ArrayList<>();
        this.moteurs = new ArrayList<>();
        this.roues = new ArrayList<>();

        this.maxC = 1;
        this.maxM = 1;
        this.maxR = 4;

        this.noVoiture = 0;

        this.usine = usine;
    }

    public boolean carrosserieRecuperable(Carrosserie carrosserie){
        if (this.carrosseries.size() < maxC)
            return true;
        return false;
    }

    public boolean moteurRecuperable(Moteur moteur){
        if (this.moteurs.size() < maxM)
            return true;
        return false;
    }

    public boolean roueRecuperable(Roue roue){
        if (this.roues.size() < maxR)
            return true;
        return false;
    }

    public void recupererC(Carrosserie carrosserie){
        this.carrosseries.add(carrosserie);
    }

    public void recupererM(Moteur moteur){
        this.moteurs.add(moteur);
    }

    public void recupererR(Roue roue){
        this.roues.add(roue);
    }

    public void creationVoiture(){
        System.out.println("GDGD");
        if (this.carrosseries.size() == maxC && this.moteurs.size() == maxM && this.roues.size() == maxR){
            this.carrosseries = new ArrayList<>();
            this.moteurs = new ArrayList<>();
            this.roues = new ArrayList<>();
            this.noVoiture++;
            System.out.println("La voiture n°"+this.noVoiture+" a été créé");
        }
    }

    @Override
    public void run(){
        try{
            for (int i=0; i<10; i++){
                this.usine.supprimeCarrosserie();
                this.usine.supprimeMoteur();
                this.usine.supprimeRoue();
                creationVoiture();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e){

        }
    }
}
