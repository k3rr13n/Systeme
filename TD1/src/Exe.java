public class Exe {
    public static void main(String []agrs){
        Matrice uneMatrice = new Matrice(4);
        Matrice uneAutreMatrice = new Matrice(4);
        // uneMatrice.matriceMultiplication(uneAutreMatrice);

        System.out.println(uneMatrice);
        System.out.println(uneAutreMatrice);
        System.out.println(uneMatrice.matriceMultiplication(uneAutreMatrice));
    }
}
