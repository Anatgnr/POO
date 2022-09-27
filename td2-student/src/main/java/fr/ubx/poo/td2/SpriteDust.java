package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;
import model.Robot;
import view.ImageResource;
import view.Sprite;

public class SpriteDust extends SpriteDecor {

    public SpriteDust(Position pos)
    {
        super(pos);
        this.m_img = new ImageView(ImageResource.imageDust);
        updateLocation(pos);

    }



}
