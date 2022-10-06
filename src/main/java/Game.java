import java.util.ArrayList;

public class Game {
    Map map;
    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public Game() {
        map = new Map();

        // map.buildMapFromTemplate();


        //objects.add(new Player(5, 5)); //tar bara två argument då "P" definieras i Player-konstruktorn.
        // Positionen beror på bana/bandesign


        for (int y = 0; y < map.mapTemplate1.length; y++) { //Make Walls
            for (int x = 0; x < map.mapTemplate1[y].length; x++) {
                String tile = map.mapTemplate1[x][y];
                if (tile.equals("W")) {
                    objects.add(new Wall(x, y)); //Bugg i constructorn
                }

            }
        }

       for (int y = 0; y < map.mapTemplate1.length; y++) { //Make goal
            for (int x = 0; x < map.mapTemplate1[y].length; x++) {
                String tile = map.mapTemplate1[x][y];
                if(tile.equals("G")){
                    objects.add(new GameObject(x, y, "G"));// Fixa till rätt klass efter en merge
                }

            }
        }
        for (int y = 0; y < map.mapTemplate1.length; y++) {//Make Box
            for (int x = 0; x < map.mapTemplate1[y].length; x++) {
                String tile = map.mapTemplate1[x][y];
                if(tile.equals("B")){
                    objects.add(new GameObject(x, y, "B"));// Fixa till rätt klass efter en merge
                }

            }
        }
        for (int y = 0; y < map.mapTemplate1.length; y++) { //Make player

            for (int x = 0; x < map.mapTemplate1[y].length; x++) {
                String tile = map.mapTemplate1[x][y];
                if (tile.equals("P")) {
                    objects.add(new Player(x, y));
                }

            }
        }


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
