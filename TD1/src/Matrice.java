import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Matrice {
    //Pour matrice carre de taille potentiellement differentes
    private int taille = 0;
    private List<List<Integer>> matrice;

    public Matrice(int taille){
        this.taille = taille;
        this.matrice = new ArrayList<>();
        Random rand = new Random();

        for (int i=0; i<taille; i++){
            List<Integer> autre_liste = new ArrayList<>();
            for (int j=0; j<taille; j++){
                autre_liste.add(rand.nextInt(10));
            }
            this.matrice.add(autre_liste);
        }
    } 

    public int get_taille(){
        return this.taille;
    }

    public List<List<Integer>> get_matrice(){
        return this.matrice;
    }

    public Matrice(List<List<Integer>> matrice){
        this.matrice = matrice;
        this.taille = matrice.size();
        // for (List<Integer> ligne : this.matrice){
        //     this.taille++;
        // }
    }

    public List<Integer> getLigne(int ligne){
        return this.matrice.get(ligne);
    }

    public List<Integer> getColonne(int colonne){
        List<Integer> valeur = new ArrayList<>();
        for (int i=0; i<taille; i++){
            valeur.add(this.matrice.get(i).get(colonne));
        }
        return valeur;
    }

    // A finir
    public Matrice matriceMultiplication(Matrice matrice){
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<this.taille; i++){
            List<Integer> uneLigne = new ArrayList<>();
            for (int j=0; j<this.taille; j++){
                for (int tours=0; tours<this.taille; tours++){
                    uneLigne.add(this.getLigne(i).get(tours) * matrice.getColonne(j).get(tours));
                }
            }
            res.add(uneLigne);
        }
        return new Matrice(res);
    }

    @Override
    public String toString(){
        String laMatrice = "[";
        System.out.println(this.get_taille());
        for (int i=0; i<this.get_taille(); i++){
            for (int j=0; j<this.get_taille(); j++){
                // System.out.println(j);
                if (this.get_taille() == i+1 && this.get_taille() == j+1){laMatrice += this.getLigne(i).get(j)+"]\n";}
                else if (this.get_taille() == j+1){laMatrice += this.getLigne(i).get(j)+"]\n[";}
                else{laMatrice += this.getLigne(i).get(j)+", ";}
            }
        }
        return laMatrice;
    }
}




/*
 * for(int i)
 *  for(int j)
 *      T t = new T()
 *      t.start();
 * 
 * 
 *      t.join();
 * 
 */

// public Matrice multiplicationParCoeur(Matrice matrice) {
//     if (matrice.size() == this.size()){
//         int n = this.size();
//         Matrice res = new Matrice(n);
//         List<ThrC> listThreads = new ArrayList<>();
//         int nbThreads = Runtime.getRuntime().availableProcessors(); // potentiellement important
//         int nbLignesParThread = n / nbThreads;

//         int debut, fin = 0;
//         for (int i = 0; i <nbThreads; i++){
//             debut = i * nbLignesParThread;
//             fin = (i+ 1) * nbLignesParThread;
//             if (i == nbThreads -1)
//                 fin = n;
//             ThrC thrC = new ThrC(this, matrice, res, debut, fin);
//             listThreads.add(thrC);
//             thrC.start();
//         }

//         for (ThrC thrL : listThreads) {
//             try {
//                 thrL.join();
//             }
//             catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
//     return res;
// }