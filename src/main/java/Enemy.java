public class Enemy extends GameObject {

    public Enemy(int x, int y) {
        super(x, y, "E");
    }
}
// Skapar en lista med alla objekt i spelet som används för att rita ut dem på kartan.
//public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
// Skapar kartan från Map-klassen och ritar ut den.
//Map map = new Map();
//Scanner scan = new Scanner(System.in);
//map.mapBuilder(map.mapTemplate1);  // banan borde vara en variabel som ges av menyvalet
//map.PrintMap(objects);
    /*Move Right;
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