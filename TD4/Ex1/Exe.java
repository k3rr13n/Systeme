import java.util.*;

public class Exe {
    public static void main(String []agrs){
        Carte laCarte = new Carte(5, 6);
        // uneMatrice.matriceMultiplication(uneAutreMatrice);

        System.out.println(laCarte);

        List<Case> lesCases = new ArrayList<>();
        Case case1 = new Case(0, 1, 1);
        Case case2 = new Case(0, 1, 2);
        Case case3 = new Case(0, 2, 1);
        Case case4 = new Case(0, 2, 2);

        lesCases.add(case1);
        lesCases.add(case2);
        lesCases.add(case3);
        lesCases.add(case4);

        laCarte.initFire(lesCases);

        System.out.println(laCarte);

    }
}
