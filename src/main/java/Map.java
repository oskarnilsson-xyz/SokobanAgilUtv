import java.util.ArrayList;

public class Map {

    Player player1 = new Player(5,5);
    Player player2 = new Player(2, 7);
    Player player3 = new Player (5, 8);

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
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
            };
    String[][] mapTemplate2 =
            {
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                    new String[] { "W", ".", "W", ".", ".", ".", ".", ".", "G", "W" },
                    new String[] { "W", "P", "W", "B", ".", ".", "W", "W", "W", "W" },
                    new String[] { "W", ".", "W", ".", ".", "B", ".", ".", ".", "W" },
                    new String[] { "W", ".", ".", ".", ".", ".", ".", ".", ".", "W" },
                    new String[] { "W", "W", ".", ".", "W", ".", "B", "W", ".", "W" },
                    new String[] { "W", ".", ".", ".", "W", ".", ".", "W", ".", "W" },
                    new String[] { "W", ".", ".", "W", "W", ".", ".", "W", ".", "W" },
                    new String[] { "W", "G", "W", "W", "W", ".", ".", "W", "G", "W" },
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
            };
    String[][] mapTemplate3 =
            {
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                    new String[] { "W", "G", "W", "W", "W", ".", ".", "G", "W", "W" },
                    new String[] { "W", ".", "W", ".", ".", ".", ".", ".", "W", "W" },
                    new String[] { "W", ".", ".", "B", ".", "W", "W", "W", "W", "W" },
                    new String[] { "W", "B", ".", "B", ".", ".", ".", ".", "W", "W" },
                    new String[] { "W", ".", "W", "W", "W", ".", "B", ".", "W", "W" },
                    new String[] { "W", ".", "W", "W", "W", ".", "W", "W", "W", "W" },
                    new String[] { "W", ".", "W", "W", "W", ".", "B", ".", ".", "W" },
                    new String[] { "W", "G", "W", "P", ".", ".", ".", "G", "G", "W" },
                    new String[] { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
            };
    Player player = new Player();




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
    public void mapBuilder(String[][] fromTemplate){ // mapTemplate1

     for (int y = 0; y < fromTemplate.length; y++) { //Make Walls
        for (int x = 0; x < fromTemplate[y].length; x++) {
            String tile = fromTemplate[x][y];
            if (tile.equals("W")) {
                Game.objects.add(new Wall(x, y));

            }
        }
    }
            for (int y = 0; y < fromTemplate.length; y++) { //Make goal
        for (int x = 0; x < fromTemplate[y].length; x++) {
            String tile = fromTemplate[x][y];
            if (tile.equals("G")) {
                Game.objects.add(new GoalTile(x, y));
            }

        }
    }
            for (int y = 0; y < fromTemplate.length; y++) {//Make Box
        for (int x = 0; x < fromTemplate[y].length; x++) {
            String tile = fromTemplate[x][y];
            if (tile.equals("B")) {
                Game.objects.add(new Box(x, y));
            }

        }
    }

                Game.objects.add(player1);

}



}
