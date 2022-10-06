import java.util.ArrayList;

public class Map {
    String[][] map =
            {
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
                    new String[] { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." }
            };
    String[][] mapTemplate1 =
            {
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", "G", ".", "B", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", "P", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
            };


    Game game;

    String[][] tempMap;

    public Map()
    {

    }

    // This function places all my moveable objects on my static map,
    // then prints it.
    public void PrintMap(ArrayList<GameObject> objects)
    {
        tempMap = map.clone();
        for(GameObject obj : objects)
        {
            tempMap[obj.getX()][obj.getY()] = obj.getMapMarker();
        }

        PrintMap(tempMap);
    }

    // This function prints a map that is given to it.
    private void PrintMap(String[][] mapToPrint)
    {
        for (int y = 0; y < mapToPrint.length; y++)
        {
            for (int x = 0; x < mapToPrint[y].length; x++)
            {
                System.out.print(mapToPrint[y][x] + " ");
            }
            System.out.println();
        }
    }

    // Returns what kind of tile it is via an x and y value.
    public String ReturnTile(int x, int y)
    {
        if (x < 0 || y < 0 || x > map[y].length || y > map.length)
        {
            return "";
        }
        return map[y][x];
    }
    public void mapBuilder(){ //String[][] mapTemplate1
        //game = new Game();
     for (int y = 0; y < mapTemplate1.length; y++) { //Make Walls
        for (int x = 0; x < mapTemplate1[y].length; x++) {
            String tile = mapTemplate1[x][y];
            if (tile.equals("W")) {
                game.objects.add(new Wall(x, y));

            }
        }
    }
            for (int y = 0; y < mapTemplate1.length; y++) { //Make goal
        for (int x = 0; x < mapTemplate1[y].length; x++) {
            String tile = mapTemplate1[x][y];
            if (tile.equals("G")) {
                game.objects.add(new GoalTile(x, y));
            }

        }
    }
            for (int y = 0; y < mapTemplate1.length; y++) {//Make Box
        for (int x = 0; x < mapTemplate1[y].length; x++) {
            String tile = mapTemplate1[x][y];
            if (tile.equals("B")) {
                game.objects.add(new Box(x, y));
            }

        }
    }
            for (int y = 0; y < mapTemplate1.length; y++) { //Make player
        for (int x = 0; x < mapTemplate1[y].length; x++) {
            String tile = mapTemplate1[x][y];
            if (tile.equals("P")) {
                game.objects.add(new Player(x, y));
            }

        }
    }
}



}
