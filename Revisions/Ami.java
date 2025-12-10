import java.util.*;

public class Ami extends Thread{
    private List<Gestion> paquet;

    public Ami(Gestion paquet){
        this.paquet = new ArrayList<>();
        this.paquet.add(paquet);
    }

    @Override
    public void run(){
        System.out.println(3);
    }
}
