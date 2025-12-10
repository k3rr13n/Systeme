public class Usine extends Thread{
    private Gestion paquet;
    private int val;
    private String caracList;

    public Usine(Gestion paquet){
        this.val = 0;
        this.caracList = "abcdefghijklmnopqrstuvwxyz";
        this.paquet = paquet;
    }

    public String creer(){
        String newPaquet = String.valueOf(caracList.charAt(this.val));
        this.val++;
        return newPaquet;
    }

    @Override
    public void run(){
        creer();
        System.out.println(1);
    }
}
