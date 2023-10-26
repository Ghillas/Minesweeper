package model;

import java.util.Random;

public class Plateau {

    private int hauteur, largeur, nb_bombe;
    public Case[][] plateau;


    public Plateau(int a, int b, int c) {
        this.hauteur = a;
        this.largeur = b;
        this.nb_bombe = c;
        this.plateau = new Case[this.hauteur][this.largeur];
        this.generate_grid();
    }

    public Plateau(int a, int b) {
        this.hauteur = a;
        this.largeur = b;
        this.nb_bombe = (a + b) / 2;
        this.plateau = new Case[this.hauteur][this.largeur];
        this.generate_grid();
    }

    public Plateau() {
        this.hauteur = 10;
        this.largeur = 10;
        this.nb_bombe = 10;
        this.plateau = new Case[this.hauteur][this.largeur];
        this.generate_grid();
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
        if(a > 0) { // on regarde les 3 cases au dessus de nous
            for(int i = b-1 >= 0 ? b-1 : 0; i <= b+1 && i < largeur; i++) {
                if(plateau[a-1][i] instanceof Bombe) {
                    tot++;
                }
            }
        }

        // on regarde les 3 cases sur notre ligne (dont la case actuel mais cela n'a pas d'influence sur le résultat)
        for(int i = b-1 >= 0 ? b-1 : 0; i <= b+1 && i < largeur; i++) {
            if(plateau[a][i] instanceof Bombe) {
                tot++;
            }
        }

        // on regarde les 3 cases en dessous de nous
        if(a < hauteur - 1) {
            for(int i = b-1 >= 0 ? b-1 : 0; i <= b+1 && i < largeur; i++) {
                if(plateau[a+1][i] instanceof Bombe) {
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


    public void generate_grid() {
        Random rand = new Random();
        plateau = new Case[this.hauteur][this.largeur];
        for (int i = 0 ; i < nb_bombe; i++) { // on place toutes les bombes
            boolean correct_emplacement = false;
            while(!correct_emplacement) {
                int x = rand.nextInt(hauteur);
                int y = rand.nextInt(largeur);
                if(!(plateau[x][y] instanceof Bombe)) {
                    plateau[x][y] = new Bombe(x, y, false);
                    correct_emplacement = true;
                }
            }
        }

        for (int i = 0; i < hauteur; i++) { // on place les cases libre
            for (int j = 0; j < largeur; j++) {
                if(!(plateau[i][j] instanceof Bombe)) {
                    plateau[i][j] = new Libre(i, j, false, calcul_voisin(i, j));
                }
            }
        }

    }


}