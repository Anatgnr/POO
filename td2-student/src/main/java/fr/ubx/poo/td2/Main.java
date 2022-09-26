package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.lang.annotation.Target;
import java.lang.invoke.VarHandle;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Creation du robot et du drone

        Position pos = new Position(0,0);
        Position poss = new Position(05,0);
        Vehicule []playerTab = new Vehicule[]{new Robot(pos, 400, 2),new Drone(poss,400,2)};
        Sprite []spritesTab = new Sprite[]{new SpriteRobot((Robot) playerTab[0],new ImageView(ImageResource.imageRobot)),
                new SpriteDrone((Drone) playerTab[1],new ImageView(ImageResource.imageDrone))};



        // Affiche la fenetre

        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(int i=0;i<playerTab.length;i++){
                if (playerTab[i].canMove(target)&&!playerTab[i].getPosition().equals(playerTab[i].getPosition(), target)) {
                    spritesTab[i].animateMove(target);
                }
            }
        });

        view.getPane().getChildren().addAll(spritesTab[0].getImg(),spritesTab[1].getImg());

    }

    public static void main(String[] args) { launch(); }
}