package fr.ubx.poo.td2;

public class Robot extends Vehicule{
    private final int cost;
    private Position position;
    private int energy;


    public Robot(Position position, int energy, int cost) {
        this.position = position;
        this.energy = energy;
        this.cost = cost;
    }
    public Robot(int x, int y, int energy, int cost) {
        this.position = new Position(0,0);
        this.position.setX(x);
        this.position.setY(y);
        this.energy = energy;
        this.cost = cost;
    }

    @Override int getEnergy() {
        return this.energy;
    }
    @Override public void setEnergy(int mana){
        this.energy = mana;
    }
    @Override int getCost() {
        return this.cost;
    }
    @Override public void printPos(Position pos){
        System.out.println("x = " + pos.getX() + " " + "y = " + pos.getY());
    }

    @Override public Position getPosition() {
        return position;
    }

    // TODO
    @Override public int range() {
        return(this.getEnergy()/this.getCost());
    }

    // TODO
    @Override public int distance(Position target) {
        int tx = target.getX();
        int ty = target.getY();
        int px = this.position.getX();
        int py = this.position.getY();
        int distance = Math.abs(tx - px) + Math.abs(ty - py);
        // System.out.println("distance = " + distance);
        return distance;
    }

    // TODO
    @Override public boolean canMove(Position target) {
        boolean distance_range = this.distance(target)<=this.range(); // variable qui retourne si la range est respectee
        boolean enough_mana = this.getEnergy()>=(this.distance(target) * this.getCost());
        if(distance_range == true && enough_mana == true){return true;}
        else{return false;}
    }

    // TODO
    @Override public void move(Position target) {
        if(canMove(target)==true){
            this.setEnergy(this.getEnergy() - (this.distance(target) * this.getCost()));
            this.getPosition().setX(target.getX());
            this.getPosition().setY(target.getY());
        } 
    }

    // TODO
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



