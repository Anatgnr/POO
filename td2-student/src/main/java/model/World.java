package model;
import fr.ubx.poo.td2.Position;
import fr.ubx.poo.td2.SpriteDecor;
import fr.ubx.poo.td2.SpriteDust;
import fr.ubx.poo.td2.SpriteRock;
import view.DecorFactory;


public class World {

    int width, height;
    int[][] tableau;
    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;

    private int percentageRock, percentageDust, total;

    public World(int w, int h, int r, int d) {
    this.width = w;
    this.height = h;
    this.total = w * h;
    this.percentageRock = r * this.total / 100;
    this.percentageDust = d * this.total / 100;
    this.tableau = new int[this.width][this.height];

    }

    public int get(Position position) { return tableau[position.getX()][position.getY()]; }
    public void set(Position position, int kind) { tableau[position.getX()][position.getY()] = kind; }

    public SpriteDecor[] generate()
    {
        SpriteDecor[] decor = new SpriteDecor[this.getDust() + this.getRock()];
        int iteration = 0;
        for(int i = 0 ; i < this.getRock() ; i++)
        {

            Position pos = new Position(DecorFactory.create(Position.random(),World.ROCK).getPosition());
            set(pos,World.ROCK);
            SpriteRock r = new SpriteRock(pos);
            decor[iteration] = r;
            iteration++;
            //System.out.printf("Position %d %d %d \n ", pos.getX(), pos.getY(), i);


        }

        for(int i = 0 ; i < this.getDust() ; i++)
        {
            Position pos = new Position(DecorFactory.create(Position.random(),World.DUST).getPosition());
            set(pos,World.DUST);
            SpriteDust r = new SpriteDust(pos);
            decor[iteration] = r;
            iteration++;


        }

        return decor;

    }

    public int getRock()
    {
        return this.percentageRock;
    }
    public int getDust()
    {
        return this.percentageDust;
    }
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }



}

