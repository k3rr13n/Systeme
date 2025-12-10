import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Usine {
    // Les listes des differentes pieces
    List<Carrosserie> carrosseries;
    List<Moteur> moteurs;
    List<Roue> roues;
    
    // Les instances de fournisseur et assembleur
    Fournisseur fournisseur;
    Assembleur assembleur;

    // Le nombre d'unité maximal de chaques pieces
    int maxC;
    int maxM;
    int maxR;

    // Les verrou des differentes pieces
    Lock verrouC;
    Lock verrouM;
    Lock verrouR;

    // Les conditions pour chaques pieces
    Condition condCarrosserieFull;
    Condition condCarrosserieEmpty;
    Condition condMoteurFull;
    Condition condMoteurEmpty;    
    Condition condRoueFull;
    Condition condRoueEmpty;

    public Usine(){
        this.carrosseries = new ArrayList<>();
        this.moteurs = new ArrayList<>();
        this.roues = new ArrayList<>();

        this.maxC = 3;
        this.maxM = 5;
        this.maxR = 20;

        this.verrouC = new ReentrantLock();
        this.verrouM = new ReentrantLock();
        this.verrouR = new ReentrantLock();

        this.condCarrosserieFull = verrouC.newCondition();
        this.condCarrosserieEmpty = verrouC.newCondition();
        this.condMoteurFull = verrouM.newCondition();
        this.condMoteurEmpty = verrouM.newCondition();
        this.condRoueFull = verrouR.newCondition();
        this.condRoueEmpty = verrouR.newCondition();
    }

    public Usine(Gestion chemin) {
        //TODO Auto-generated constructor stub
    }

    public void fournisseurUsine(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }

    public void assembleurUsine(Assembleur assembleur){
        this.assembleur = assembleur;
    }

    public void ajoutCarrosserie(){ 
        this.verrouC.lock();
        try{
            while (this.carrosseries.size() == maxC){
                this.condCarrosserieFull.await();
            }
            this.carrosseries.add(this.fournisseur.stockerC()); //add un if
            System.out.println(this.carrosseries.get(this.carrosseries.size()-1)+" a été ajouté");
            this.condCarrosserieEmpty.signal();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally{
            this.verrouC.unlock();
        }
    }

    public void ajoutMoteur() throws InterruptedException{
        this.verrouM.lock();
        while (this.moteurs.size() == maxM){
            this.condMoteurFull.await();
        }
        this.moteurs.add(this.fournisseur.stockerM()); //add un if
        this.condMoteurEmpty.signal();
        this.verrouM.unlock();
    }

    public void ajoutRoue() throws InterruptedException{
        this.verrouR.lock();
        while (this.roues.size() == maxR){
            this.condRoueFull.await();
        }
        this.roues.add(this.fournisseur.stockerR()); //add un if
        this.condRoueEmpty.signal();
        this.verrouR.unlock();
    }

//===============================================================================================================

    public void supprimeCarrosserie() throws InterruptedException{ 
        if (this.carrosseries.size() != 0){
            this.verrouC.lock();
            while (this.assembleur.carrosserieRecuperable(this.carrosseries.get(0)) == false){
                this.condCarrosserieEmpty.await();
            }
            this.assembleur.recupererC(this.carrosseries.get(0));
            this.carrosseries.remove(0);
            this.condCarrosserieFull.signal();
            this.verrouC.unlock();
        }
    }

    public void supprimeMoteur() throws InterruptedException{
        if (this.moteurs.size() != 0){
            this.verrouM.lock();
            while (this.assembleur.moteurRecuperable(this.moteurs.get(0)) == false){
                this.condMoteurEmpty.await();
            }
            this.assembleur.recupererM(this.moteurs.get(0));
            this.moteurs.remove(0);
            this.condMoteurFull.signal();
            this.verrouM.unlock();
        }
    }

    public void supprimeRoue() throws InterruptedException{
        if (this.carrosseries.size() != 0){
            this.verrouR.lock();
            while (this.assembleur.roueRecuperable(this.roues.get(0)) == false){
                this.condRoueEmpty.await();
            }
            this.assembleur.recupererR(this.roues.get(0));
            this.roues.remove(0);
            this.condRoueFull.signal();
            this.verrouR.unlock();
        }
    }

    public void start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
