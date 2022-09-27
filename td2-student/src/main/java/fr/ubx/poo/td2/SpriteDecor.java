package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;
import model.Vehicule;
import view.ImageResource;
import view.Sprite;

public class SpriteDecor {

    protected Position m_position;
    protected ImageView m_img;

    public SpriteDecor(Position pos) {
        this.m_position = new Position(pos);
    }

    protected void updateLocation(Position position) {
        this.m_img.setX(position.getX() * ImageResource.size);
        this.m_img.setY(position.getY() * ImageResource.size);
    }



    public ImageView getImg() {
        return m_img;
    }


}
