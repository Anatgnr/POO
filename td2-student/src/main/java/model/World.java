package model;
import fr.ubx.poo.td2.Position;

public class World {

    int width, height;
    int[][] tableau;
    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;

    public World(int w, int h) {
    this.width = w;
    this.height = h;
    tableau = new int[this.width][this.height];

    }

    public int get(Position position) { return tableau[position.getX()][position.getY()]; }
    public void set(Position position, int kind) { tableau[position.getX()][position.getY()] = kind; }


}

