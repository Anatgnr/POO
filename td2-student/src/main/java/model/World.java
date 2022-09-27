package model;
import fr.ubx.poo.td2.Position;

public class World {

    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;

    public World(int width, int height) {
        // À compléter
    }

    public int get(Position position) { ... }
    public void set(Position position, int kind) { ... }
}

