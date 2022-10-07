import java.util.ArrayList;

public class Game {
    Map map = new Map();
    //Player player = new Player();
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public Game() {


        map.mapBuilder(map.mapTemplate1);


        map.PrintMap(objects);


    }


    // Move the given object one step left
    public boolean MoveLeft(GameObject gameObject) {

        // Get what kind of tile we're stepping on.
        String tile = map.ReturnTile(gameObject.getX() - 1, gameObject.getY());

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("w")) {
            System.out.println("That's a wall!");
            return false;
        }

        // Perhaps add code to see if we're walking into another object, too.

        gameObject.setX(gameObject.getX() - 1); // Move the object's x one step left.
        return true;
    }

}