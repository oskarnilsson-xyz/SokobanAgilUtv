import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //Player player = new Player();
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    Map map = new Map();
    Scanner scan = new Scanner(System.in);
    public Game() {

        while(true) {
            map.mapBuilder(map.mapTemplate1);
            map.PrintMap(objects);
            String input = scan.nextLine();
            switch (input) {
                case "a":
                    MoveLeft(map.player1);
                    break;
                case "d":
                    MoveRight(map.player1);
                    break;
                case "w":
                    MoveUp(map.player1);
                    break;
                case "s":
                    MoveDown(map.player1);
                    break;
                default:
                    System.out.println("Snälla skriv korrekt. Annars blir apan ledsen.");
            }
        }


    }


    // Move Right
    public boolean MoveLeft(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY(), gameObject.getX() - 1);        // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        gameObject.setX(gameObject.getX() - 1); // Move the object's x one step right.
        return true;
    }

    //Move Down -Ner i Y led = plus 1
    public boolean MoveRight(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY() , gameObject.getX()+ 1);         // Get what kind of tile we're stepping on.

        if (tile.equals("")){
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        gameObject.setX(gameObject.getX() + 1); // Move the object's x one step down.
        return true;
    }

    //Move Up -Upp i Y led = minus 1
    public boolean MoveUp(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY() - 1, gameObject.getX());         // Get what kind of tile we're stepping on.
        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        gameObject.setY(gameObject.getY() - 1); // Move the object's x one step up.
        return true;
    }

    //Move Down
    public boolean MoveDown(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY() + 1, gameObject.getX());         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }

        gameObject.setY(gameObject.getY() + 1); // Move the object's x one step down.
        return true;
    }

}