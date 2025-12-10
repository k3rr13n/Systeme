public class Gestion {
    private String paquet;

    public Gestion(String paquet){
        this.paquet = paquet;
    }

    // public synchronized void deposerUsine(){
    //     this.paquet = null;
    // }

    public synchronized void recuperer(String paquet){
        // while (this.paquet != null){ // Il attend de déposer le paquet
        // }
        this.paquet = paquet;
    }

    public synchronized void deposer() throws InterruptedException{
        while (this.paquet == null){ // Il attend de récuperer un paquet
            wait();
        }
        this.paquet = null;
    }

    public synchronized void recupererAmi(String paquet){
        // this.paquet.add(paquet);
    }
}

