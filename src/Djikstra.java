import java.util.ArrayList;
import java.util.Collections;

public class Djikstra {

    static ArrayList<Arête> chemin = new ArrayList<>();
    static ArrayList<Arête> traversé = new ArrayList<>();

    public static void main(String[] args) {

        Arête A = new Arête("A", 0);
        Arête B = new Arête("B", 0);
        Arête C = new Arête("C", 0);
        Arête D = new Arête("D", 0);
        Arête E = new Arête("E", 0);
        Arête F = new Arête("F", 0);

        ArrayList<Arête> arêtes = new ArrayList<>();
        Collections.addAll(arêtes, A, B, C, D, E, F);

        A.AjouterVoisin(D, 15);
        D.AjouterVoisin(A, 15);
        A.AjouterVoisin(B, 7);
        B.AjouterVoisin(A, 7);
        B.AjouterVoisin(C, 12);
        C.AjouterVoisin(B, 12);
        B.AjouterVoisin(F, 16);
        F.AjouterVoisin(B, 16);
        B.AjouterVoisin(E, 4);
        E.AjouterVoisin(B, 4);
        C.AjouterVoisin(F, 3);
        F.AjouterVoisin(C, 3);
        C.AjouterVoisin(D, 5);
        D.AjouterVoisin(C, 5);
        D.AjouterVoisin(E, 2);
        E.AjouterVoisin(D, 2);
        E.AjouterVoisin(F, 14);
        F.AjouterVoisin(E, 14);

        chemin.add(A);
        traversé.add(A);

        djikstra(A, "F");

        }


    public static void djikstra(Arête arête, String destination){

        Voisin nextArret = closestVoisin(arête);
        chemin.add(nextArret.arête);

        if(!nextArret.arête.name.equals(destination)) {
            djikstra(nextArret.arête, destination);
        }
        else{
            System.out.println("Distance parcourue: "+ nextArret.arête.distanceParcourue  );
            System.out.println("Chemin plus court pour arriver à "+ destination +" : ");
            for (Arête ar :
                    chemin) {
                System.out.print(ar.name +" ");
            }
        }
    }

    public static Voisin closestVoisin(Arête arête){
        int min = 999;
        Voisin closestVoisin = null;

        for (Voisin voisin :
                arête.voisins) {
            if(!traversé.contains(voisin.arête) && voisin.distance + arête.distanceParcourue <= min){
                    min = voisin.distance + arête.distanceParcourue;
                    closestVoisin = voisin;
            }
        }
        traversé.add(closestVoisin.arête);

        closestVoisin.arête.distanceParcourue = closestVoisin.distance + arête.distanceParcourue;

        return closestVoisin;
    }
}
