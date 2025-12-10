public class Exe {
    public static void main(String[] args) {
        Usine usine = new Usine();

        Fournisseur four = new Fournisseur(usine);
        // Assembleur assembl = new Assembleur(usine);

        usine.fournisseurUsine(four);
        // usine.assembleurUsine(assembl);

        four.start();
        // assembl.start();
    }
}
