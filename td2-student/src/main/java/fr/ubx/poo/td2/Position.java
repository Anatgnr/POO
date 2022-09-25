package fr.ubx.poo.td2;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int cx) {
        this.x = cx;
    } 
    public void setY(int cy) {
        this.y = cy;
    }
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void translate(int delta) {
        translate(delta, delta);
    }
}
