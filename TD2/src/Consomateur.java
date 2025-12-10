public class Consomateur extends Thread{

    private Donnee donnee;

    public Consomateur(Donnee data){
        this.donnee = data;
    }

    @Override
    public void run(){
        try{
            for (int i=0; i<1; i++){
                this.donnee.retirer();
                Thread.sleep(10); // le .sleep() prend en paramettre millis (des milisecnde)
            }
        }
        catch (InterruptedException e){

        }
    }
}

