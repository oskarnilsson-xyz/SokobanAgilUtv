import java.util.ArrayList;

public class Game {
    //Player player = new Player();
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    Map map = new Map();

    public Game() {


        map.mapBuilder(map.mapTemplate1);


        map.PrintMap(objects);


    }


    // Move Right
    public boolean MoveLeft(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY(), gameObject.getX() + 1);        // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("w")) {
            System.out.println("That's a wall!");
            return false;
        }
        gameObject.setX(gameObject.getX() + 1); // Move the object's x one step right.
        return true;
    }

    //Move Down -Ner i Y led = plus 1
    public boolean MoveRight(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY() + 1, gameObject.getX());         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("w")) {
            System.out.println("That's a wall!");
            return false;
        }
        gameObject.setY(gameObject.getY() + 1); // Move the object's x one step down.
        return true;
    }

    //Move Up -Upp i Y led = minus 1
    public boolean MoveUp(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY() - 1, gameObject.getX());         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("w")) {
            System.out.println("That's a wall!");
            return false;
        }
        gameObject.setY(gameObject.getY() - 1); // Move the object's x one step up.
        return true;
    }

    //Move Left
    public boolean MoveDown(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY(), gameObject.getX() - 1);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("w")) {
            System.out.println("That's a wall!");
            return false;
        }

        gameObject.setX(gameObject.getX() - 1); // Move the object's x one step left.
        return true;
    }

}