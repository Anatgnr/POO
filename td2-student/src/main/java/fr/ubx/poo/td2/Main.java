package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Drone;
import model.Robot;
import model.Vehicule;
import model.World;
import view.ImageResource;
import view.Sprite;
import view.View;

import java.util.Random;

//je mets en commentaires là ou il y a des erreurs.

//import java.lang.annotation.Target;
//import java.lang.invoke.VarHandle;

public class Main extends Application {

    //@Override
    public void start(Stage stage)  {

        // Creation du robot et du drone

        Position pos = new Position(0,0);
        Position poss = new Position(05,0);
        Vehicule[]playerTab = new Vehicule[]{new Robot(pos, 400, 2),new Drone(poss,400,2)};
        Sprite[]spritesTab = new Sprite[]{new SpriteRobot((Robot) playerTab[0],new ImageView(ImageResource.imageRobot)),
                new SpriteDrone((Drone) playerTab[1],new ImageView(ImageResource.imageDrone))};







        // Affiche la fenetre

        World w = new World(20,20,3,5);
        //System.out.printf("getrock %f : ",w.getRock());
        SpriteDecor[] decor = w.generate();
        View view = new View(w.getWidth(), w.getHeight());
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(int i=0;i<playerTab.length;i++){
                if (playerTab[i].canMove(target)&&!playerTab[i].getPosition().equals(playerTab[i].getPosition(), target)) {
                    spritesTab[i].animateMove(target, w);
                }
            }
        });

        for(int i = 0 ; i < decor.length ; i++)
        {
            view.getPane().getChildren().addAll(decor[i].getImg());
        }
        view.getPane().getChildren().addAll(spritesTab[0].getImg(),spritesTab[1].getImg());
      //  view.getPane().getChildren().addAll(decorsTab[0].getImg(),decorsTab[1].getImg());

    }

    public static void main(String[] args) { launch(); }
}