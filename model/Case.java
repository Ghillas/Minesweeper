package model;


public abstract class Case {

    private int coord_x, coord_y;
    private boolean decouvert;
    private boolean flag;


    public Case(int i, int j, boolean b) {
        this.coord_x = i;
        this.coord_y = j;
        this.decouvert = b;
        this.flag = false;
    }


    public Case(int i, int j) {
        this.coord_x = i;
        this.coord_y = j;
        this.decouvert = false;
        this.flag = false;
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

    public boolean getFlag() {
        return this.flag;
    }

    public void setFlag(boolean b) {
        this.flag = b;
    }

}