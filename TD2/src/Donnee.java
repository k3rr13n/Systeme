public class Donnee {
    
    private String data; // cela peux etre nimporte quoi
    // private List<String> data;
    // private int born;

    public Donnee(String data){
        this.data = data;
    }

    synchronized void ajouter(String newData) throws InterruptedException{
        while (this.data != null){
            System.out.println("Attente d'un retrait");
            wait(); // on peux utiliser wait() seulement si la methode possede synchronized
        }
        this.data = newData;
        System.out.println(newData+" a été ajouté");
        notifyAll();
    }

    synchronized String retirer() throws InterruptedException{
        while (this.data == null){
            System.out.println("Attente d'un ajout");
            wait(); // on peux utiliser wait() seulement si la methode possede synchronized
        }
        String res = this.data;            
        System.out.println(res+" a été retiré");
        this.data = null;
        notifyAll();
        return res;
    }

}
