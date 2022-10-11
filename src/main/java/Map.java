import java.util.ArrayList;

public class Map {

    Player player1 = new Player(5, 5); // Player bör flyttas ut ur Map till en mer passande klass.
    Player player2 = new Player(2, 7);
    Player player3 = new Player(5, 8);

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
                    new String[]{"W", ".", ".", "G", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", "B", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
            };
    String[][] mapTemplate2 =
            {
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", ".", ".", ".", "G", "W"},
                    new String[]{"W", "P", "W", "B", ".", ".", "W", "W", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", "B", ".", ".", ".", "W"},
                    new String[]{"W", ".", ".", ".", ".", ".", ".", ".", ".", "W"},
                    new String[]{"W", "W", ".", ".", "W", ".", "B", "W", ".", "W"},
                    new String[]{"W", ".", ".", ".", "W", ".", ".", "W", ".", "W"},
                    new String[]{"W", ".", ".", "W", "W", ".", ".", "W", ".", "W"},
                    new String[]{"W", "G", "W", "W", "W", ".", ".", "W", "G", "W"},
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
            };
    String[][] mapTemplate3 =
            {
                    new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    new String[]{"W", "G", "W", "W", "W", ".", ".", "G", "W", "W"},
                    new String[]{"W", ".", "W", ".", ".", ".", ".", ".", "W", "W"},
                    new String[]{"W", ".", ".", "B", ".", "W", "W", "W", "W", "W"},
                    new String[]{"W", "B", ".", "B", ".", ".", ".", ".", "W", "W"},
                    new String[]{"W", ".", "W", "W", "W", ".", "B", ".", "W", "W"},
                    new String[]{"W", ".", "W", "W", "W", ".", "W", "W", "W", "W"},
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
        for (int x = 0; x < mapToPrint.length; x++) {
            for (int y = 0; y < mapToPrint[x].length; y++) {
                System.out.print(mapToPrint[x][y] + " ");
            }
            System.out.println();
        }
    }

    // Returns what kind of tile it is via an x and y value.
    public String ReturnTile(int y, int x) {
        if (x < 0 || y < 0 || y > map[y].length || x > map.length) {
            return "";
        }
        return map[x][y];
    }

    // Lägger in ett objekt på Map, beroende vart vilken symbol den har och placerad den på koordinaten.
    public void mapBuilder(String[][] fromTemplate) { // mapTemplate1
        for (int x = 0; x < fromTemplate.length; x++) { //Make Walls
            for (int y = 0; y < fromTemplate[x].length; y++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("W")) {
                    Game.objects.add(new Wall(y, x));
                }
            }
        }
        for (int x = 0; x < fromTemplate.length; x++) { //Make goal
            for (int y = 0; y < fromTemplate[x].length; y++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("G")) {
                    Game.objects.add(new GoalTile(y, x));
                }
            }
        }
        for (int x = 0; x < fromTemplate.length; x++) {//Make Box
            for (int y = 0; y < fromTemplate[x].length; y++) {
                String tile = fromTemplate[y][x];
                if (tile.equals("B")) {
                    Game.objects.add(new Box(y, x));
                }
            }
        }
        Game.objects.add(player1); // Lägger till spelaren (bör nog placeras på annat ställe)
    }
}
