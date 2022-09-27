package view;

import fr.ubx.poo.td2.Position;
import fr.ubx.poo.td2.SpriteDecor;
import fr.ubx.poo.td2.SpriteDust;
import fr.ubx.poo.td2.SpriteRock;
import model.World;

public class DecorFactory {
    public static SpriteDecor create(Position position, int kind) {
        switch (kind) {
            case World.DUST:
                return new SpriteDust(position);
            case World.ROCK:
                return new SpriteRock(position);
            default:
                return null;
        }
    }
}
