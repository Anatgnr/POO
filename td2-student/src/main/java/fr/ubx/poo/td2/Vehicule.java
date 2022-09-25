package fr.ubx.poo.td2;

public class Vehicule {
    private final int cost;
    private Position position;
    private int energy;

    public Vehicule(Position position, int energy, int cost) {
        this.position = position;
        this.energy = energy;
        this.cost = cost;
    }
    public Vehicule(int x, int y, int energy, int cost) {
        this.position = new Position(0,0);
        this.position.setX(x);
        this.position.setY(y);
        this.energy = energy;
        this.cost = cost;
    }

    int getEnergy() {
        return this.energy;
    }
    public void setEnergy(int mana){
        this.energy = mana;
    }
    int getCost() {
        return this.cost;
    }
    public void printPos(Position pos){
        System.out.println("x = " + pos.getX() + " " + "y = " + pos.getY());
    }

    public Position getPosition() {
        return position;
    }

    // TODO
    public int range() {
        return(this.getEnergy()/this.getCost());
    }

    // TODO
    public int distance(Position target) {
        return 0;
    }

    // TODO
    public boolean canMove(Position target) {
        boolean distance_range = this.distance(target)<=this.range(); // variable qui retourne si la range est respectee
        boolean enough_mana = this.getEnergy()>=(this.distance(target) * this.getCost());
        if(distance_range == true && enough_mana == true){return true;}
        else{return false;}
    }

    // TODO
    public void move(Position target) {
        if(canMove(target)==true){
            this.setEnergy(this.getEnergy() - (this.distance(target) * this.getCost()));
            this.getPosition().setX(target.getX());
            this.getPosition().setY(target.getY());
        } 
    }

    // TODO
    public Position[] getPathTo(Position target) {
        return null;
    }

// END OF CLASS
}



