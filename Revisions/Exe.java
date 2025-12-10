public class Exe {
    public static void main(String[] args) {
        Gestion chemin = new Gestion("miel");

        Ami ami = new Ami(chemin);
        Coursier coursier = new Coursier(chemin);
        Usine usine = new Usine(chemin);

        ami.start();
        coursier.start();
        usine.start();
    }
}
