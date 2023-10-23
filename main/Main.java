package main;

import model.*;
import view.*;


public class Main {


    public static void main(String[] args) {
        System.out.println(args.length);
        Plateau p;
        if(args.length == 0) {
            p = new Plateau();
        } else if(args.length == 2) {
            try {
                p = new Plateau(Integer.valueOf(args[1]), Integer.valueOf(args[2]));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else if(args.length == 3) {
            try {
                p = new Plateau(Integer.valueOf(args[1]), Integer.valueOf(args[2]), Integer.valueOf(args[3]));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            System.out.println("Incorrect number of argument");
            return;
        }
        new Partie(p);

    }

}