import java.util.Random;

public class Producteur extends Thread{

    private Donnee donnee;
    private String caracList;
    
    public Producteur(Donnee data){
        this.donnee = data;
        this.caracList = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPKRSTUVWXYZ";
    }

    public String getCaracList(int indice){
        return Character.toString(this.caracList.charAt(indice));
    }

    public String genereChaine(){
        String chaine = "";
        Random rand = new Random();
        for (int i=0; i<12; i++){
            chaine += getCaracList(rand.nextInt(this.caracList.length()));
        }
        return chaine;
    }

    @Override
    public void run(){
        try{
            for (int i=0; i<10; i++){
                String chaine = genereChaine();
                this.donnee.ajouter(chaine);
                Thread.sleep(10); // le .sleep() prend en paramettre millis (des milisecnde)
            }
        }
        catch (InterruptedException e){

        }
    }
}
