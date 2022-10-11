public class GameObject {

    //Implementerar koordinatsystem för vart GameObjects kan ritas ut på kartan.
    protected int x;
    protected int y;

    //Mapmarker definerar hur de olika GameObjecten ritas ut på kartan (P för Player, W för Wall, etc.)
    protected String mapMarker;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMapMarker() {
        return mapMarker;
    }

    public void setMapMarker(String mapMarker) {
        this.mapMarker = mapMarker;
    }

    public GameObject(int y, int x, String mapMarker)
    {
        this.y = y;
        this.x = x;
        this.mapMarker = mapMarker;
    }
}
