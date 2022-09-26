package fr.ubx.poo.td2;

public class Drone extends Vehicule{

    public Drone(Position position, int energy, int cost) {
    super(position, energy, cost);
    }
    public Drone(int x, int y, int energy, int cost) {
    super(x, y, energy, cost);
    }

    @Override public int distance(Position target) {
        int tx = target.getX();
        int ty = target.getY();
        int px = getPosition().getX();
        int py = getPosition().getY();
        int distance = Math.abs(tx - px) + Math.abs(ty - py);
        // System.out.println("distance = " + distance);
        return distance;
    }

    @Override public Position[] getPathTo(Position target) {

            /*############################################################################*/
            //                             X THEN Y METHOD                                //
            /*############################################################################*/
            // Position[] tablo = new Position[2];
            // if(canMove(target)==true){
            //     tablo[0] = new Position(target.getX(), this.position.getY());
            //     tablo[1] = new Position(target.getX(),target.getY());
            // }
            // return tablo;
            /*############################################################################*/
            //                              STAIRS METHOD                                 //
            /*############################################################################*/

            //test de position pour X robot:
        int x,y; //variable pour stocker vers ou aller
        // X
        if(this.getPosition().getX() < target.getX()){x = 1;}   // robot à gauche de target
        else{x = -1;}  // robot à droite de target
        if(this.getPosition().getX() == target.getX()){x = 0;}
        // Y
        if(this.getPosition().getY() < target.getY()){y = 1;}   // robot en dessous de target
        else{y = -1;}  // robot au dessus de target
        if(this.getPosition().getY() == target.getY()){y = 0;}
        // initialisation du tableau
        Position[] tablo = new Position[distance(target)];
        // conditions
            for (int i = 0; i<distance(target); i++) {

//  Pour i paire
                if(i%2==0) {
                    if(i == 0) {
                        if (this.getPosition().getX() == target.getX()){tablo[0] = new Position(this.getPosition().getX(), this.getPosition().getY() + y);}
                        else{tablo[0] = new Position(this.getPosition().getX() + x, this.getPosition().getY());}
                    }
                    else if (tablo[i-1].getX() == target.getX()) {tablo[i] = new Position(tablo[i-1].getX(), tablo[i-1].getY() + y);}
                    else{tablo[i] = new Position(tablo[i-1].getX() + x, tablo[i-1].getY());}
                }

//  Pour i impaire
                if(i%2==1) {
                    if (tablo[i-1].getY() == target.getY()) {tablo[i] = new Position(tablo[i-1].getX() + x, tablo[i-1].getY());}
                    else{tablo[i] = new Position(tablo[i-1].getX(), tablo[i-1].getY() + y);}
                }
                // System.out.println("tab[i] = " + tablo[i].getX() + " " + tablo[i].getY());
            }
        System.out.println("####################################");
            for(int i = 0; i<distance(target);i++){
                System.out.println(tablo[i].getX() + " " +tablo[i].getY() + ";");
            }
        System.out.println("####################################");
        return tablo;
    }

// END OF CLASS
}


