import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Tache extends RecursiveTask<Integer>{

   private List<Integer> liste;

    public Tache(List<Integer> liste){
        this.liste = liste;
    }

    // La methode compute permet ici de renvoyer la plus grande valeur d'une liste
    // Chaques return renveront donc forcement un max, d'une liste ou alors seulement 
    // de deux elements en fonction de la condition dans laquel on se trouve
    public Integer compute(){
        if(this.liste.size() < 10){
            // Si ma liste est de bonne taille (ici de taille 10), on return juste la plus grande valeur
            return Collections.max(this.liste); 
        }
        else{
            List<Integer> uneMoitie = new ArrayList<>(); // Déclaration des deux sous listes
            List<Integer> lautreMoitie = new ArrayList<>();
            for(int i=0; i<this.liste.size(); i++){ // Boucle qui sépare la liste en deux autres plus petites
                if(i%2 == 0){
                    uneMoitie.add(this.liste.get(i));
                }
                else{
                    lautreMoitie.add(this.liste.get(i));
                }
            }
            // La methode fork() est utilisable sur des instances de classes qui ont la methode compute()
            // Elle permet de faire executer l'action paralelement a la suite du programme
            Tache t1 = new Tache(uneMoitie); // Ici on recupere la premiere demi-liste pour créer une nouvelle tache et on lui aplique fork()
            t1.fork();
            Tache t2 = new Tache(lautreMoitie); 
            // Ici je ne dois pas renvoyer la plus grande valeur d'une liste, mais la plus grande entre les deux taches precedement créé
            return Integer.valueOf(Math.max(t1.join(), t2.compute())); 
        }
    }
}


