package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;
import model.Drone;
import view.Sprite;

public class SpriteDrone extends Sprite {
    public SpriteDrone(Drone drone, ImageView image) {
        super(drone,image);
        updateLocation(drone.getPosition());
    }
}
