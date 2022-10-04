package fr.ubx.poo.td2;
import java.util.Random;

//import org.jetbrains.annotations.NotNull;

public class Position {
    private int x;
    private int y;

    public Position(Position pos) {
        this.x= pos.getX();
        this.y= pos.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void translate(int delta) {
        translate(delta, delta);
    }
    public boolean equals(Position pos1, Position pos2){
        if(pos1.getX()== pos2.getX()&&pos1.getY()== pos2.getY()){
            System.out.print("equals");
            return true;
        }
        return false;
    }

    public static Position random()
    {

        Random random = new Random();
        int r1 = random.nextInt(19);
        int r2 = random.nextInt(19);
        Position pos = new Position(r1,r2);
        return pos;
    }

    public static Position generation(int x, int y)
    {
        return new Position(x,y);

    }
    //public boolean equals(Position pos1, Position pos2){
      //  if(pos1.getX()== pos2.getX()&&pos1.getY()== pos2.getY()){
        //    System.out.print("equals");
          //  return true;
        //}
       // return false;
    //}
}
