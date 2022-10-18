import java.util.ArrayList;

public class Map {


    //Skapar en multidimensionellarray för punktsystemet som ritar ut kartan.
    String[][] map =
            {
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
    //Här kommer den inledande kartan som är spelbar, med tillhörande Box och Goal.
    String[][] mapTemplate1 =
            {
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", "B", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", "B", ".", ".", ".", "E", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", "W", "W", "W", "W", ".", ".", ".", "W"},
                    new String[]{"W", ".", "W", ".", "P", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", "W", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", "W", ".", "G", ".", ".", ".", ".", "W"},
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
            };
    String[][] mapTemplate2 =
            {
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", ".", ".", ".", "G", "W"},
                    new String[]{"W", "P", "W", "B", ".", ".", "W", "W", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", "B", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", "W", "E", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", "W", ".", "B", "W", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", "W", ".", "W"},
                    new String[]{"W", ".", ".", "W", "W", ".", ".", "W", ".", "W"},
                    new String[]{"W", "G", ".", "W", "W", ".", ".", "W", "G", "W"},
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
            };
    String[][] mapTemplate3 =
            {
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    new String[]{"W", "G", "W", "W", "W", ".", ".", "G", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", "E", ".", ".", "W", "W"},
                    new String[]{"W", ".", ".", "B", ".", "W", "W", ".", "W", "W"},
                    new String[]{"W", "B", ".", ".", "B", ".", ".", ".", "W", "W"},
                    new String[]{"W", ".", "W", ".", "W", ".", "B", ".", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", ".", "W", ".", "W", "W"},
                    new String[]{"W", ".", "W", "W", "W", ".", "B", ".", ".", "W"},
                    new String[]{"W", "G", "W", "P", ".", ".", ".", "G", "G", "W"},
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
            };


    //Skapar en tom multiarray som sedan fylls med kartlayouten.
    String[][] tempMap;

    public Map() {

    }

    // This function places all my MapMarkers for my objects on my static map,
    // then prints it.
    public void PrintMap(ArrayList<GameObject> objects) {
        tempMap = map.clone();
        for (GameObject obj : objects) {
            tempMap[obj.getY()][obj.getX()] = obj.getMapMarker();
        }
        PrintMap(tempMap);
    }

    // This function prints a map that is given to it.
    private void PrintMap(String[][] mapToPrint) {

        for (int y = 0; y < mapToPrint.length; y++) {
            for (int x = 0; x < mapToPrint[y].length; x++) {
                System.out.print(mapToPrint[y][x] + " ");
            }
            System.out.println();
        }
    }

    // Returns what kind of tile it is via an x and y value
    public String ReturnTile(int x, int y) {
        if (x < 0 || y < 0 || y > map[y].length || x > map.length) {
            return "";
        }
        return map[y][x];
    }

    // Lägger in ett objekt på Map, beroende vart vilken symbol den har och placerad den på koordinaten.
    public void mapBuilder(String[][] fromTemplate, Player player, Enemy enemy, ArrayList<GameObject> objects) { // mapTemplate1
        for (int y = 0; y < fromTemplate.length; y++) { //Make player
            for (int x = 0; x < fromTemplate[y].length; x++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("P")) {
                    player.setX(x);
                    player.setY(y);
                    objects.add(player);
                }
            }
        }
        for (int y = 0; y < fromTemplate.length; y++) { //Make Enemy
            for (int x = 0; x < fromTemplate[y].length; x++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("E")) {
                    enemy.setX(x);
                    enemy.setY(y);
                    objects.add(enemy);
                }
            }
        }
        for (int y = 0; y < fromTemplate.length; y++) { //Make Walls
            for (int x = 0; x < fromTemplate[y].length; x++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("W")) {
                    objects.add(new Wall(x, y));
                }
            }
        }
        for (int y = 0; y < fromTemplate.length; y++) { //Make goal
            for (int x = 0; x < fromTemplate[y].length; x++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("G")) {
                    objects.add(new GoalTile(x, y));
                }
            }
        }
        for (int y = 0; y < fromTemplate.length; y++) {//Make Box
            for (int x = 0; x < fromTemplate[y].length; x++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("B")) {
                    objects.add(new Box(x, y));
                }
            }
        }
    }
}