import java.util.ArrayList;

public class Game {
    Map map;
    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public Game() {
        map = new Map();

        // map.buildMapFromTemplate();


        objects.add(new Player(5, 5)); //tar bara två argument då "P" definieras i Player-konstruktorn.
                                            // Positionen beror på bana/bandesign


        for (int y = 0; y < map.mapTemplate1.length; y++) {
            for (int x = 0; x < map.mapTemplate1[y].length; x++) {
                String tile;
                if()
                objects.add(new GameObject(1, 1, "W"));
            }
        }


        map.PrintMap(objects);
    }




    // Move the given object one step left
    public boolean MoveLeft(GameObject gameObject)
    {

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
