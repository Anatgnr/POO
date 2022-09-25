package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Creation du robot et du drone
        // Position position = new Position(4,4); // ->initialiser dans la création du robot
        // Robot robot = new Robot(position, 200, 2);
        Vehicule[] vehicules = {};
        Vehicule[0] = new Robot(2,2, 2000, 2);
        Vehicule[1] = new Drone(3,1,300,3);
        // position.translate(10);
        // robot.getPosition().translate(10);
        Sprite[] sprites = {}; 
        sprites[0] = new SpriteRobot(vehicules[0]);
        sprites[1] = new SpriteDrone(vehicules[1]);

        // Affiche la fenetre
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for (int i = 0; i <vehicules.length;i++)
            {
                if(vehicules[i].canMove(target))
                {
                    sprites[i].animateMove(target)
                }
            }
            // if (robot.canMove(target)) {
            //     // robot.move(target);
            //     spriteRobot.animateMove(target);
            //     // spriteRobot.animateMove(robot.getPosition());
            // }
            // if (drone.canMove(target)) {
            //     // drone.move(target);
            //     spriteDrone.animateMove(target);
            //     // spriteDrone.animateMove(robot.getPosition());
            // }
        });

        view.getPane().getChildren().addAll(spriteRobot.getImg());
        view.getPane().getChildren().addAll(spriteDrone.getImg());

    }

    public static void main(String[] args) { launch(); }
}