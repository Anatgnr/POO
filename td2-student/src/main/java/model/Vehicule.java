package model;

import fr.ubx.poo.td2.Position;

public abstract class Vehicule  {
    protected final double cost;
    protected Position position;
    protected double energy;

    public Vehicule(double cost, Position pos, double energy) {
        this.cost = cost;
        this.position = new Position(pos);
        this.energy = energy;
    }

    public Position getPosition() {
        return position;
    }

    // TODO
    private int range() {
        return (int) (this.energy / this.cost);
    }

    // TODO
    public int distance(Position target) {
        return 0;
    }

    // TODO
    public boolean canMove(Position target) {
        if (distance(target) <= range()) {
            return true;
        }
        return false;
    }

    // TODO
    public void move(Position target) {
        if (canMove(target)) {
            this.energy -= distance(target) * this.cost;
            this.position.setX(target.getX());
            this.position.setY(target.getY());
        }
        System.out.println("Move completed: " + this);
    }
    @Override
    public String toString(){

        return "(Energy="+ this.energy+")";
    }

    // TODO
    public Position[] getPathTo(Position target) {return  null;}

}
