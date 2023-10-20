package model;


public abstract class Case {

    private int coord_x, coord_y;
    private boolean decouvert;


    public Case(int i, int j, boolean b) {
        this.coord_x = i;
        this.coord_y = j;
        this.decouvert = b;
    }


    public Case(int i, int j) {
        this.coord_x = i;
        this.coord_y = j;
        this.decouvert = false;
    }



    public int getX() {
        return coord_x;
    }

    public void setX(int x) {
        coord_x = x;
    }

    public int getY() {
        return coord_y;
    }

    public void setY(int y) {
        coord_y = y;
    }

    public boolean getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(boolean b) {
        decouvert = b;
    }

}