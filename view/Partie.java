package view;


import model.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class Partie {

    private JPanel panel, grille, boutton_top;
    private JFrame frame;
    private JButton[][] grille_boutton;
    private JButton recommencer, quitter;
    private Plateau jeu;



    public Partie(Plateau p) {
        // recupéré la largeur et hauteur avec les args a l'execution pour la V1
        jeu = p;
        frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setSize(jeu.getHauteur() * 50, jeu.getLargeur() * 50);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        draw_game();
    }


    public void draw_game() {
        panel = new JPanel(new BorderLayout());
        boutton_top = new JPanel(new GridLayout(2, 1));
        recommencer = new JButton("Restart");
        quitter = new JButton("Leave");

        recommencer.addActionListener((event) -> restart_game());
        quitter.addActionListener((event) -> frame.dispose());
        boutton_top.add(recommencer);
        boutton_top.add(quitter);
        panel.add(boutton_top, BorderLayout.NORTH);

        grille_boutton = new JButton[jeu.getHauteur()][jeu.getLargeur()];
        grille = new JPanel(new GridLayout(jeu.getHauteur(), jeu.getLargeur()));
        for(int i = 0; i < jeu.getHauteur(); i++) {
            for(int j = 0; j < jeu.getLargeur(); j++) {
                int x = i;
                int y = j;
                grille_boutton[i][j] = new JButton();
                grille_boutton[i][j].addActionListener((event) -> grid_management(x,y));
                grille.add(grille_boutton[i][j]);
            }
        }
        frame.revalidate();
        frame.repaint();
    }

    public void grid_management(int x, int y) {
        if(jeu.plateau[x][y] instanceof Bombe) {
            try {
                Image photo = ImageIO.read(new File("./bombe.png"));
                grille_boutton[x][y].setIcon(new ImageIcon(photo)); 
            } catch(Exception e) {
                grille_boutton[x][y].setBackground(Color.BLACK);
            }
            defaite();
        } else {
            //TODO : print the number of Bombe arounds this Case and setEnabled(false)
        }
    }



    public void restart_game() {
        //TODO : regénérer aleatoirement le plateau + tout les JButton
    }

    public void defaite() {
        //TODO : setEnabled(false) for all button + message on bottom (lost)
    }



}