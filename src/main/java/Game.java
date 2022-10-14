import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // Skapar en lista med alla objekt i spelet som används för att rita ut dem på kartan.
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    // Skapar kartan från Map-klassen och ritar ut den.
    Map map = new Map();
    Scanner scan = new Scanner(System.in);

    public Game() {
        System.out.println("Du rör din spelare med:\na = vänster\nd = höger\nw = uppåt\ns = nedåt\n\"exit\" avslutar programmet");
        map.mapBuilder(map.mapTemplate1);  // banan borde vara en variasbel som ges av menyvalet
        map.PrintMap(objects);


        while (!checkWin(map.mapTemplate1)) { //banan borde vara en variabel som ges av menyvalet

            String input = scan.nextLine().trim().toLowerCase();

            // Här kommer tangentdelegeringen för hur Player styrs på kartan.
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
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Snälla skriv korrekt. Annars blir apan ledsen.");
            }
        }
    }


    // Här beskrivs ytterligare rörelser, hur objekten flyttas i förhållande till Player.

    // Move Left
    public boolean MoveLeft(Player player) {


        String tile = map.ReturnTile(player.getX() - 1, player.getY());         // Get what kind of tile we're stepping on.
        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }

        map.tempMap[player.getX()][player.getY()] = "."; // Ersätter nuvarande position med en punkt.
        player.setX(player.getX() - 1);// Move the object's x one step left.


        for (GameObject box : objects) { //Moves box one step to the left if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();

                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setX(box.getX() - 1);
                }
            }
        } return true;

    }

    //Move Right;
    public boolean MoveRight(Player player) {


        String tile = map.ReturnTile(player.getX() + 1, player.getY());         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }

        map.tempMap[player.getX()][player.getY()] = "."; //Ersätter nuvarande position med en punkt.
        player.setX(player.getX() + 1); // Move the object's x one step right.
        for (GameObject box : objects) { //Moves box one step to the right if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setX(box.getX() + 1);
                }
            }
        } return true;
    }

    //Move Up -Upp i Y led = minus 1
    public boolean MoveUp(Player player) {


        String tile = map.ReturnTile(player.getX(), player.getY() - 1);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }

        map.tempMap[player.getX()][player.getY()] = ".";    //Ersätter nuvarande position med en punkt.
        player.setY(player.getY() - 1);                     // Move the object's x one step up.
        for (GameObject box : objects) {                            //Moves box one step up if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setY(box.getY() - 1);
                }
            }
        } return true;
    }

    //Move Down -Ner i Y led = plus 1
    public boolean MoveDown(Player player) {


        String tile = map.ReturnTile(player.getX(), player.getY() + 1);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }


        map.tempMap[player.getX()][player.getY()] = "."; //Ersätter nuvarande position med en punkt.
        player.setY(player.getY() + 1); // Move the object's x one step down.

        for (GameObject box : objects) { //Moves box one step down if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setY(box.getY() + 1);
                }
            }
        }
        return true;
    }

    public boolean checkWin(String[][] currentMap) { // Victory condition checker
        // if all goalTiles are covered by boxes = win

        for (int x = 0; x < map.tempMap.length; x++) { // check if goalTile
            for (int y = 0; y < map.tempMap[x].length; y++) {
                String tile1 = map.tempMap[x][y];
                String tile2 = currentMap[x][y];
                if (tile2.equals("G") && tile1.equals("P")) {//något annat än B står på G (just nu enbart P) Uppdatera när vi lägger till fler object på map
                    return false;
                } else if (tile1.equals("G")) {
                    return false;
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