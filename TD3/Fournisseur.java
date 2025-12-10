public class Fournisseur extends Thread{
    
    // Les pieces fabriqué par le fournisseur
    Carrosserie carrosserie;
    Moteur moteur;
    Roue roue;

    // Le n° de série des pieces founis
    int noC;
    int noM;
    int noR;

    // L'usine
    Usine usine;

    public Fournisseur(Usine usine){
        this.carrosserie = null;
        this.moteur = null;
        this.roue = null;

        this.noC = 0;
        this.noM = 0;
        this.noR = 0;

        this.usine = usine;
    }

    public void creationCarrosserie(){
        this.carrosserie = new Carrosserie("Carrosserie", this.noC);
        this.noC++;
        System.out.println("La carrosserie n°"+this.noC+" a été créé");
    }

    public void creationMoteur(){
        this.moteur = new Moteur("Moteur", this.noM);
        this.noM++;
        System.out.println("Le moteur n°"+this.noM+" a été créé");

    }

    public void creationRoue(){
        this.roue = new Roue("Roue", this.noR);
        this.noR++;
        System.out.println("Le roue n°"+this.noR+" a été créé");
    }

    public Carrosserie stockerC(){
        Carrosserie carrosserie = this.carrosserie;
        this.carrosserie = null;
        return carrosserie;
    }

    public Moteur stockerM(){
        Moteur moteur = this.moteur;
        this.moteur = null;
        return moteur;
    }

    public Roue stockerR(){
        Roue roue = this.roue;
        this.roue = null;
        return roue;
    }

    @Override
    public void run(){
        try{
            for (int i=0; i<3; i++){
                creationCarrosserie();
                creationMoteur();
                creationRoue();
                this.usine.ajoutCarrosserie();
                this.usine.ajoutMoteur();
                this.usine.ajoutRoue();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e){

        }
    }
    // KInsqC1oDksK
}