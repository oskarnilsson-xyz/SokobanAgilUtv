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
}
