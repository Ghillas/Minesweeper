package model;


public class Plateau {

    private int hauteur, largeur, nb_bombe;
    public Case[][] plateau;


    public Plateau(int a, int b, int c) {
        this.hauteur = a;
        this.largeur = b;
        this.nb_bombe = c;
        this.plateau = new Case[this.hauteur][this.largeur];
    }

    public Plateau(int a, int b) {
        this.hauteur = a;
        this.largeur = b;
        this.nb_bombe = (a + b) / 2;
        this.plateau = new Case[this.hauteur][this.largeur];
    }

    public Plateau() {
        this.hauteur = 10;
        this.largeur = 10;
        this.nb_bombe = 10;
        this.plateau = new Case[this.hauteur][this.largeur];
    }


    public int decouvre_case(int a, int b) {
        if(plateau[a][b] instanceof Bombe) {
            return -1;
        } else {
            plateau[a][b].setDecouvert(true);
            return calcul_voisin(a,b);
        }
    }


    public int calcul_voisin(int a, int b) {
        int tot = 0;
        if(b > 0) { // on regarde les 3 cases au dessus de nous
            for(int i = a-1 >= 0 ? a : 0; i <= a+1 && i < largeur; i++) {
                if(plateau[i][b-1] instanceof Bombe) {
                    tot++;
                }
            }
        }

        // on regarde les 3 cases sur notre ligne (dont la case actuel mais cela n'a pas d'influence sur le résultat)
        for(int i = a-1 >= 0 ? a : 0; i < a+1 && i < largeur; i++) {
            if(plateau[i][b] instanceof Bombe) {
                tot++;
            }
        }

        // on regarde les 3 cases en dessous de nous
        if(b < hauteur - 1) {
            for(int i = a-1 >= 0 ? a : 0; i <= a+1 && i < largeur; i++) {
                if(plateau[i][b+1] instanceof Bombe) {
                    tot++;
                }
            }
        }

        return tot;
    }


    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getNbBombe() {
        return nb_bombe;
    }


    public void generate_bombe() {
        //TODO : generate random location for all bombe
    }


}