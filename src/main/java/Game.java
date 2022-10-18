import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // Skapar en lista med alla objekt i spelet som används för att rita ut dem på kartan.
    public ArrayList<GameObject> objects;
    // Skapar kartan från Map-klassen och ritar ut den.
    Map map = new Map();
    Scanner scan = new Scanner(System.in);
    Random randX = new Random();
    Random randY = new Random();
    String[] array2 = {"-1", "1"};
    Integer stepCount = 0;
    Boolean backToStart = false;



    public Game() {
        objects = new ArrayList<GameObject>();
    }

    public void gameOn(String[][] mapTemplate) {
        Player player = new Player(0, 0);
        Enemy enemy = new Enemy(0, 0);

        System.out.println("To move your player use:\na = left\nd = right\nw = upp\ns = down\n\"return\" return to main menu\"exit\" ends the game");
        map.mapBuilder(mapTemplate, player, enemy, objects);  // banan är en variabel som ges av menyvalet
        map.PrintMap(objects);


        while (!backToStart && (!checkWin(mapTemplate) && !death(player, enemy))) {  //banan är en variabel som ges av menyvalet

            String input = scan.nextLine().trim().toLowerCase();

            // Här kommer tangentdelegeringen för hur Player styrs på kartan.

            switch (input) {
                case "a":
                    moveLeft(player);
                    if (death(player, enemy)) { //Checks if player enters enemy tile before enemy moves
                        break;
                    }
                    enemyMove(enemy);
                    map.PrintMap(objects);
                    break;
                case "d":
                    moveRight(player);
                    if (death(player, enemy)) { //Checks if player enters enemy tile before enemy moves
                        break;
                    }
                    enemyMove(enemy);
                    map.PrintMap(objects);
                    break;
                case "w":
                    moveUp(player);
                    if (death(player, enemy)) { //Checks if player enters enemy tile before enemy moves
                        break;
                    }
                    enemyMove(enemy);
                    map.PrintMap(objects);
                    break;
                case "s":
                    moveDown(player);
                    if (death(player, enemy)) { //Checks if player enters enemy tile before enemy moves
                        break;
                    }
                    enemyMove(enemy);
                    map.PrintMap(objects);
                    break;
                case "return":
                    backToStart = true;
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid input. The ape is now sad.");
            }
        }
        if (death(player, enemy)) {
            System.out.println("You are dead!");
        }
        objectArrayClear();
    }


    // Här beskrivs ytterligare rörelser, hur objekten flyttas i förhållande till Player.

    // Move Left
    private boolean moveLeft(Player player) {

        String tile1 = map.ReturnTile(player.getX() - 1, player.getY());         // Get what kind of tile we're stepping on.
        if (tile1.equals("")) {

            System.out.println("That's out of bounds!");
            return false;
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");
            return false;

        }
        String tile2 = map.ReturnTile(player.getX() - 2, player.getY());        //Kollar 2 tiles fram
        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
            return false;

        }

        map.tempMap[player.getY()][player.getX()] = "."; // Ersätter nuvarande position med en punkt.
        player.setX(player.getX() - 1);// Move the object's x one step left.
        stepCount += 1;


        for (GameObject box : objects) { //Moves box one step to the left if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();

                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setX(box.getX() - 1);
                }
            }

        }
        return true;
    }

    //Move Right;
    private void moveRight(Player player) {

        String tile1 = map.ReturnTile(player.getX() + 1, player.getY());         // Get what kind of tile we're stepping on.


        if (tile1.equals("")) {
            System.out.println("That's out of bounds!");
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");

        }

        String tile2 = map.ReturnTile(player.getX() + 2, player.getY());

        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
        }


        map.tempMap[player.getY()][player.getX()] = "."; //Ersätter nuvarande position med en punkt.
        player.setX(player.getX() + 1); // Move the object's x one step right.
        stepCount += 1;

        for (GameObject box : objects) { //Moves box one step to the right if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setX(box.getX() + 1);
                }
            }
        }

    }


    //Move Up -Upp i Y led = minus 1
    private void moveUp(Player player) {


        String tile1 = map.ReturnTile(player.getX(), player.getY() - 1);         // Get what kind of tile we're stepping on.

        if (tile1.equals("")) {
            System.out.println("That's out of bounds!");
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");
        }
        String tile2 = map.ReturnTile(player.getX(), player.getY() - 2);        //Kollar 2 tiles fram

        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
        }


        map.tempMap[player.getY()][player.getX()] = ".";    //Ersätter nuvarande position med en punkt.
        player.setY(player.getY() - 1); // Move the object's x one step up.
        stepCount += 1;

        for (GameObject box : objects) {                            //Moves box one step up if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setY(box.getY() - 1);
                }
            }


        }

    }


    //Move Down -Ner i Y led = plus 1
    private void moveDown(Player player) {


        String tile1 = map.ReturnTile(player.getX(), player.getY() + 1);         // Get what kind of tile we're stepping on.

        if (tile1.equals("")) {
            System.out.println("That's out of bounds!");
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");
        }
        String tile2 = map.ReturnTile(player.getX(), player.getY() + 2);        //Kollar 2 tiles fram

        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
        }


        map.tempMap[player.getY()][player.getX()] = "."; //Ersätter nuvarande position med en punkt.
        player.setY(player.getY() + 1); // Move the object's x one step down.
        stepCount += 1;

        for (GameObject box : objects) { //Moves box one step down if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setY(box.getY() + 1);
                }
            }
        }
    }


    private void enemyMove(Enemy enemy) {
        Random randXY = new Random();
        String[] array1 = {"x", "y"};
        int rXY = randXY.nextInt(array1.length);
        switch (array1[rXY]) {
            case "x":  //är likamed x kör x led
                eMoveX(enemy);
                break;
            case "y":  //är likamed y kör y led
                eMoveY(enemy);
                break;
        }
    }

    // Move X
    private boolean eMoveX(Enemy enemy) {
        int rX = randX.nextInt(array2.length);
        String tile = map.ReturnTile(enemy.getX() + Integer.parseInt(array2[rX]), enemy.getY());
        if (tile.equals("")) {
            return false;
        } else if (tile.equals("W")) {
            return false;
        } else if (tile.equals("B")) {
            return false;
        }
        map.tempMap[enemy.getY()][enemy.getX()] = ".";
        enemy.setX(enemy.getX() + Integer.parseInt(array2[rX]));
        return true;
    }

    //Move Y
    private boolean eMoveY(Enemy enemy) {
        int rY = randY.nextInt(array2.length);
        String tile = map.ReturnTile(enemy.getX(), enemy.getY() + Integer.parseInt(array2[rY]));

        if (tile.equals("")) {
            return false;
        } else if (tile.equals("W")) {
            return false;
        } else if (tile.equals("B")) {
            return false;
        }
        map.tempMap[enemy.getY()][enemy.getX()] = ".";
        enemy.setY(enemy.getY() + Integer.parseInt(array2[rY]));
        return true;
    }

    private boolean death(Player player, Enemy enemy) { //saknar flera fiender?

        if ((player.getX() == enemy.getX()) && (player.getY() == enemy.getY())) { //Compares enemy tile with player tile and returns true or false
            return true;
        }

        return false;
    }

    private void objectArrayClear() { // Tar bort alla object i listan GameObjects.
        int list = objects.size();
        for (int y = 0; y < list; y++) {
            objects.remove(0);
        }

    }

    private boolean checkWin(String[][] currentMap) {
        Integer numGtiles = 0;
        Integer gTCovered = 0;
        for (GameObject goal : objects) {
            if (goal instanceof GoalTile) {
                numGtiles++;
            }
        }
        for (int y = 0; y < this.map.tempMap.length; ++y) {
            for (int x = 0; x < this.map.tempMap[y].length; ++x) {
                String actMap = this.map.tempMap[y][x];
                String pasMap = currentMap[y][x];
                if (pasMap.equals("G") && actMap.equals("B")) {
                    gTCovered++;

                }
            }
        }
        if ((numGtiles == gTCovered) && gTCovered > 0) {
            System.out.println(" __  __            _      ___        __  __  __ ");
            System.out.println(" \\ \\/ /__  __ __  | | /| / (_)__    / / / / / / ");
            System.out.println("  \\  / _ \\/ // /  | |/ |/ / / _ \\  /_/ /_/ /_/  ");
            System.out.println("  /_/\\___/\\_,_/   |__/|__/_/_//_/ (_) (_) (_)   ");

            System.out.println("You got " + stepCount + " steps");
            return true;
        }
        return false;
    }
}