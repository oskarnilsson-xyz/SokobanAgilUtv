import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // Skapar en lista med alla objekt i spelet som används för att rita ut dem på kartan. aa
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    // Skapar kartan från Map-klassen och ritar ut den.
    Map map = new Map();
    Scanner scan = new Scanner(System.in);
    Random randX = new Random();
    Random randY = new Random();
    String[] array2 = {"-1", "1"};



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
                    enemyMove(map.enemy1);
                    map.PrintMap(objects);
                    break;
                case "d":
                    MoveRight(map.player1);
                    enemyMove(map.enemy1);
                    map.PrintMap(objects);
                    break;
                case "w":
                    MoveUp(map.player1);
                    enemyMove(map.enemy1);
                    map.PrintMap(objects);
                    break;
                case "s":
                    MoveDown(map.player1);
                    enemyMove(map.enemy1);
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

        String tile1 = map.ReturnTile(player.getX() + 1, player.getY());         // Get what kind of tile we're stepping on.


        if (tile1.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");
            return false;

        }

        String tile2 = map.ReturnTile(player.getX() + 2, player.getY());

        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
            return false;
        }


        map.tempMap[player.getY()][player.getX()] = "."; //Ersätter nuvarande position med en punkt.
        player.setX(player.getX() + 1); // Move the object's x one step right.
        for (GameObject box : objects) { //Moves box one step to the right if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setX(box.getX() + 1);
                }
            }


        }
        return true;

    }


    //Move Up -Upp i Y led = minus 1
    public boolean MoveUp(Player player) {


        String tile1 = map.ReturnTile(player.getX(), player.getY() - 1);         // Get what kind of tile we're stepping on.

        if (tile1.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        String tile2 = map.ReturnTile(player.getX(), player.getY() - 2);        //Kollar 2 tiles fram

        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
            return false;
        }


        map.tempMap[player.getY()][player.getX()] = ".";    //Ersätter nuvarande position med en punkt.
        player.setY(player.getY() - 1);                     // Move the object's x one step up.
        for (GameObject box : objects) {                            //Moves box one step up if it has the same position as the players new position
            if (box instanceof Box) {
                int boxX = box.getX();
                int boxY = box.getY();
                if (boxX == player.getX() && boxY == player.getY()) {
                    box.setY(box.getY() - 1);
                }
            }


        }
        return true;

    }


    //Move Down -Ner i Y led = plus 1
    public boolean MoveDown(Player player) {



        String tile1 = map.ReturnTile(player.getX(), player.getY() + 1);         // Get what kind of tile we're stepping on.

        if (tile1.equals("")) {
            System.out.println("That's out of bounds!");
            return false;
        } else if (tile1.equals("W")) {
            System.out.println("That's a wall!");
            return false;
        }
        String tile2 = map.ReturnTile(player.getX(), player.getY() + 2);        //Kollar 2 tiles fram

        if (tile1.equals("B") && (tile2.equals("W") || tile2.equals("B"))) { //Kollar så att lådan går att flytta
            return false;
        }


        map.tempMap[player.getY()][player.getX()] = "."; //Ersätter nuvarande position med en punkt.
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


    public void enemyMove(Enemy enemy) {
        Random randXY = new Random();
        String[] array1 = {"x", "y"};
        int rXY = randXY.nextInt(array1.length);
        switch (array1[rXY]) {
            case "x":  //är likamed x kör x led
                eMoveX(map.enemy1);
                map.PrintMap(objects);
                break;
            case "y":  //är likamed y kör y led
                eMoveY(map.enemy1);
                map.PrintMap(objects);
                break;
        }
    }

    // Move X
    public boolean eMoveX(Enemy enemy) {
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
    public boolean eMoveY(Enemy enemy) {
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

    public boolean checkWin(String[][] currentMap) {
        for(int y = 0; y < this.map.tempMap.length; ++y) {
            for(int x = 0; x < this.map.tempMap[y].length; ++x) {
                String actMap = this.map.tempMap[y][x];
                String pasMap = currentMap[y][x];
                if (pasMap.equals("G") && actMap.equals("B")) {
                    System.out.println(" __  __            _      ___        __  __  __ ");
                    System.out.println(" \\ \\/ /__  __ __  | | /| / (_)__    / / / / / / ");
                    System.out.println("  \\  / _ \\/ // /  | |/ |/ / / _ \\  /_/ /_/ /_/  ");
                    System.out.println("  /_/\\___/\\_,_/   |__/|__/_/_//_/ (_) (_) (_)   ");
                    return true;
                }
            }
        }
        return false;
    }
}

