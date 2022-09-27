package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;
import model.Robot;
import view.Sprite;

public class SpriteRobot extends Sprite {

    public SpriteRobot(Robot robot, ImageView image) {
        super(robot,image);
        updateLocation(robot.getPosition());
    }

}
