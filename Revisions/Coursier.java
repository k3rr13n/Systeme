public class Coursier extends Thread{
    private Gestion paquet;

    public Coursier(Gestion paquet){
        this.paquet = paquet;
    }

    @Override
    public void run(){
        System.out.println(2);
    }
}
