package model;

import fr.ubx.poo.td2.Position;

public class Drone extends Vehicule {


    public Drone(Position pos, double energy, double cost) {

        super(cost, pos, energy);
    }
    @Override public String toString(){
        return "Drone "+super.toString();
    }


}
