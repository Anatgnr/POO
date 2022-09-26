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
        Vehicule[] vehicules = new Vehicule[2];
        Robot r1 = new Robot(2,2, 2000, 2);
        vehicules[0] = r1;
        Drone d1 = new Drone(3,1,300,3);
        vehicules[1] = d1;
        // position.translate(10);
        // robot.getPosition().translate(10);
        Sprite[] sprites = new Sprite[2];
        sprites[0] = new SpriteRobot(r1);
        sprites[1] = new SpriteDrone(d1);

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
                    sprites[i].animateMove(target);
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

        view.getPane().getChildren().addAll(sprites[0].getImg());
        view.getPane().getChildren().addAll(sprites[1].getImg());

    }

    public static void main(String[] args) { launch(); }
}