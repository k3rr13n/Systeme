import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Tab {
   private List<Integer> liste;
   
    public Tab(int taille){
        this.liste = new ArrayList<>();
        Random rand = new Random();

        for (int j=0; j<taille; j++){
            this.liste.add(rand.nextInt(taille*2));
        }
    }

   public void updateMax(){ // trouver le max parmi une liste d'entier
        ForkJoinPool pool = new ForkJoinPool();
        Tache tache = new Tache(liste);

        System.out.println(pool.invoke(tache));
   }
}
