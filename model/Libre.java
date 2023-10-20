package model;


public class Libre extends Case {

    private int voisin_bombe;

    public Libre(int a, int b, boolean bo, int v) {
        super(a, b, bo);
        voisin_bombe = v;
    }

    public Libre(int a, int b, int v) {
        super(a, b);
        voisin_bombe = v;
    }

    public Libre(int a, int b) {
        super(a,b);
        voisin_bombe = 0;
    }


    public int getVoisin() {
        return voisin_bombe;
    }

    public void setVoisin(int v) {
        voisin_bombe = v;
    }

}