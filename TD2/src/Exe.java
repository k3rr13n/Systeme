public class Exe {
    public static void main(String[] args) {
        Donnee data = new Donnee("Camping");

        Producteur prod = new Producteur(data);
        Consomateur conso = new Consomateur(data);

        Producteur prod2 = new Producteur(data);
        Consomateur conso2 = new Consomateur(data);

        Producteur prod3 = new Producteur(data);
        Consomateur conso3 = new Consomateur(data);

        Producteur prod4 = new Producteur(data);
        Consomateur conso4 = new Consomateur(data);

        prod.start();
        conso.start();
        prod2.start();
        conso2.start();
        prod3.start();
        conso3.start();
        prod4.start();
        conso4.start();


    }
}
