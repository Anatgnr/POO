package model;

import fr.ubx.poo.td2.Position;

public class Robot extends Vehicule {


    public Robot(Position pos, double energy, double cost) {
        super(cost, pos, energy);

    }

    @Override
    public int distance(Position target) {
        return Math.abs(target.getX() - position.getX()) + Math.abs(target.getY() - position.getY());
    }
    @Override
    public Position[] getPathTo(Position target) {
        Position[] tab = new Position[distance(target) + 1];
        int x, y;
        if (position.getX() < target.getX()) {
            x = 1;
        } else {
            x = -1;
        }
        if (position.getX() == target.getX()) {
            x = 0;
        }


        if (position.getY() < target.getY()) {
            y = 1;
        } else {
            y = -1;
        }
        if (position.getY() == target.getY()) {
            y = 0;

        }


        tab[0] = new Position(position.getX(), position.getY());

        for (int i = 1; i < distance(target) + 1; i++) {
            if (i % 2 == 0) {
                if (tab[i - 1].getX() == target.getX()) {
                    tab[i] = new Position(tab[i - 1].getX(), tab[i - 1].getY() + y);
                } else {
                    tab[i] = new Position(tab[i - 1].getX() + x, tab[i - 1].getY());
                }

            }
            if (i % 2 == 1) {
                if (tab[i - 1].getY() == target.getY()) {
                    tab[i] = new Position(tab[i - 1].getX() + x, tab[i - 1].getY());
                } else {
                    tab[i] = new Position(tab[i - 1].getX(), tab[i - 1].getY() + y);
                }

            }

        }
        return tab;
    }
    @Override public String toString(){
        return "Robot "+super.toString();
    }
}
