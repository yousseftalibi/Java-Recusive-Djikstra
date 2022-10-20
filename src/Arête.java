import java.util.ArrayList;

public class Arête {

    public String name;
    public int distanceParcourue;
    public ArrayList<Voisin> voisins = new ArrayList<>();

    public Arête(String name, int distanceParcourue){
        this.name = name;
        this.distanceParcourue = distanceParcourue;
    }

    public void AjouterVoisin(Arête arête, int distance ){

        Voisin voisin = new Voisin(arête, distance);
        voisins.add(voisin);
    }
}
