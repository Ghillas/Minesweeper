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

    private JPanel panel, grille, boutton_top,text_bottom;
    private JFrame frame;
    private JButton[][] grille_boutton;
    private JButton recommencer, quitter;
    private Plateau jeu;



    public Partie(Plateau p) {
        // recupéré la largeur et hauteur avec les args a l'execution pour la V1
        jeu = p;
        frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        int taille_elt = 100;
        frame.setSize(jeu.getHauteur() * taille_elt, jeu.getLargeur() * taille_elt);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        draw_game();
    }


    public void draw_game() {
        panel = new JPanel(new BorderLayout());
        boutton_top = new JPanel(new GridLayout(1,2));
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
                /*if(jeu.plateau[i][j] instanceof Bombe) {
                    grille_boutton[i][j] = new JButton("B");
                    grille_boutton[i][j].setBackground(Color.CYAN);
                } else {
                    Libre lb = (Libre) jeu.plateau[i][j];
                    grille_boutton[i][j] = new JButton(String.valueOf(lb.getVoisin()));
                }*/
                grille_boutton[i][j] = new JButton();
                grille_boutton[i][j].addActionListener((event) -> grid_management(x,y));
                grille.add(grille_boutton[i][j]);
            }
        }
        panel.add(grille);
        frame.setContentPane(panel);
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
            grille_boutton[x][y].setEnabled(false);
            Libre tmp = (Libre) jeu.plateau[x][y];
            grille_boutton[x][y].setText(String.valueOf(tmp.getVoisin()));
            Font my_font = grille_boutton[x][y].getFont();
            Font newFont = new Font(my_font.getFontName(), my_font.getStyle(), my_font.getSize() + 30);
            grille_boutton[x][y].setFont(newFont);
            //grille_boutton[x][y].setOpaque(true);
            //grille_boutton[x][y].setForeground(Color.BLACK);
        }
        frame.revalidate();
        frame.repaint();
    }



    public void restart_game() {
        jeu.generate_grid();
        draw_game();
    }

    public void defaite() {
        for(int i = 0; i < jeu.getHauteur(); i++) {
            for(int j = 0; j < jeu.getLargeur(); j++) {
                grille_boutton[i][j].setEnabled(false);
            }
        }
        JLabel lab = new JLabel("Vous avez perdu");
        lab.setFont(lab.getFont().deriveFont(20f));
        text_bottom = new JPanel();
        text_bottom.add(lab);
        panel.add(text_bottom,BorderLayout.SOUTH);
        frame.setContentPane(panel);
    }



}