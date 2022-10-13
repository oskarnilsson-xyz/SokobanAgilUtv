import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Enemy extends GameObject {
    // Skapar en lista med alla objekt i spelet som används för att rita ut dem på kartan.
    public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    // Skapar kartan från Map-klassen och ritar ut den.
    Map map = new Map();
    Scanner scanner = new Scanner(System.in);

    public Enemy(int x, int y) { //ärver från GameObject och position definieras när objektet skapas
        super(x, y, "E");
        map.mapBuilder(map.mapTemplate1);  // banan borde vara en variasbel som ges av menyvalet
        map.PrintMap(objects);

        for (int i = 0; i < 1; y++) {
            for (int j = 0; j < 1; x++) {
            }
        }
    }

    Random randXY = new Random();
    String[] arr = {"x", "y"};
    String rXY = String.valueOf(randXY.nextInt(arr.length));

    Random randX = new Random();
    Random randY = new Random();
    String[] arr = {"-1", "1"};
    int rX = randX.nextInt(arr.length);
    int rY = randY.nextInt(arr.length);

    if()

    {
    }//är likamed x kör x led
        else

    {
    } //är likamed y kör y led

    // Move X
    public boolean MoveLeft(Enemy enemy) {
        String tile = map.ReturnTile(enemy.getX() + rX, enemy.getY());         // Get what kind of tile we're stepping on.
        if (tile.equals("")) {
            return false;
        } else if (tile.equals("W")) {
            return false;
        } else if (tile.equals("B")) {
            return false;
        }
        map.tempMap[enemy.getX()][enemy.getY()] = "."; // Ersätter nuvarande position med en punkt.
        enemy.setX(enemy.getX() - 1);// Move the object's x one step left.
        return true;
    }

    //Move Y
    public boolean MoveUp(Enemy enemy) {
        String tile = map.ReturnTile(enemy.getX(), enemy.getY() + rY);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            return false;
        } else if (tile.equals("W")) {
            return false;
        } else if (tile.equals("B")) {
            return false;
        }
        map.tempMap[enemy.getX()][enemy.getY()] = "."; // Ersätter nuvarande position med en punkt.
        enemy.setX(enemy.getX() - 1);// Move the object's x one step left.
        return true;
    }

    //Move Right;
    public boolean MoveRight(Enemy enemy) {

        // Get what kind of tile we're stepping on.
        String tile = map.ReturnTile(enemy.getX() + rX, enemy.getY());

        if (tile.equals("")) {
            return false;
        } else if (tile.equals("W")) {
            return false;
        } else if (tile.equals("B")) {
            return false;
        }
        map.tempMap[enemy.getX()][enemy.getY()] = "."; // Ersätter nuvarande position med en punkt.
        enemy.setX(enemy.getX() - 1);// Move the object's x one step left.
        return true;
    }

    //Move Down -Ner i Y led = plus 1
    public boolean MoveDown(Enemy enemy) {


        String tile = map.ReturnTile(enemy.getX(), enemy.getY() - rY);         // Get what kind of tile we're stepping on.

        if (tile.equals("")) {
            return false;
        } else if (tile.equals("W")) {
            return false;
        } else if (tile.equals("B")) {
            return false;
        }
        map.tempMap[enemy.getX()][enemy.getY()] = "."; //Ersätter nuvarande position med en punkt.
        enemy.setY(enemy.getY() + 1); // Move the object's x one step down.
        return true;
    }
}