package fr.ubx.poo.td2;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import model.Robot;
import view.ImageResource;
import view.Sprite;

public class SpriteRock extends SpriteDecor {

    public SpriteRock(Position pos) {
        super(pos);
        this.m_img = new ImageView(ImageResource.imageRock);
        updateLocation(pos);
    }


}
