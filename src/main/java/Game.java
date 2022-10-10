import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //Player player = new Player();
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    Map map = new Map();
    Scanner scan = new Scanner(System.in);

    public Game() {

        map.mapBuilder(map.mapTemplate1);
        map.PrintMap(objects);

        while (checkWin(map.mapTemplate1) == false) {
            String input = scan.nextLine();
            switch (input) {
                case "a":
                    MoveLeft(map.player1);
                    map.PrintMap(objects);
                    break;
                case "d":
                    MoveRight(map.player1);
                    map.PrintMap(objects);
                    break;
                case "w":
                    MoveUp(map.player1);
                    map.PrintMap(objects);
                    break;
                case "s":
                    MoveDown(map.player1);
                    map.PrintMap(objects);
                    break;
                default:
                    System.out.println("Snälla skriv korrekt. Annars blir apan ledsen.");
            }
        }
    }


    // Move Left
    public boolean MoveLeft(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY(), gameObject.getX() - 1);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        map.tempMap[gameObject.getY()][gameObject.getX()] = "."; //Ersätter nuvarande position med en punkt.
        gameObject.setX(gameObject.getX() - 1); // Move the object's x one step left.

        return true;

    }

    //Move Right
    public boolean MoveRight(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY(), gameObject.getX() + 1);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        map.tempMap[gameObject.getY()][gameObject.getX()] = "."; //Ersätter nuvarande position med en punkt.
        gameObject.setX(gameObject.getX() + 1); // Move the object's x one step right.
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
        map.tempMap[gameObject.getY()][gameObject.getX()] = "."; //Ersätter nuvarande position med en punkt.
        gameObject.setY(gameObject.getY() - 1); // Move the object's x one step up.
        return true;
    }

    //Move Down -Ner i Y led = plus 1
    public boolean MoveDown(Player gameObject) {

        String tile = map.ReturnTile(gameObject.getY() + 1, gameObject.getX());         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }

        map.tempMap[gameObject.getY()][gameObject.getX()] = "."; //Ersätter nuvarande position med en punkt.
        gameObject.setY(gameObject.getY() + 1); // Move the object's x one step down.
        return true;
    }

    public boolean checkWin(String[][] currentMap) { // Victory condition checker
        //if all goalTiles are covered by boxes = win

        for (int x = 0; x < map.tempMap.length; x++) { //check if goalTile
            for (int y = 0; y < map.tempMap[x].length; y++) {
                String tile = map.tempMap[y][x];
                String tile2 = currentMap[y][x];
                if (tile2.equals("G")) {
                    return false;
                } else if (tile.equals("P")) {
                    return false; //något annat än B står på G (just nu enbart P) Uppdatera när vi lägger till fler object på map
                }
            }
        }
        System.out.println(" __  __            _      ___        __  __  __ ");
        System.out.println(" \\ \\/ /__  __ __  | | /| / (_)__    / / / / / / ");
        System.out.println("  \\  / _ \\/ // /  | |/ |/ / / _ \\  /_/ /_/ /_/  ");
        System.out.println("  /_/\\___/\\_,_/   |__/|__/_/_//_/ (_) (_) (_)   ");
        return true;
    }
}