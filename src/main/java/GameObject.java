public class GameObject {
    protected int x;
    protected int y;

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

    public GameObject(int x, int y, String mapMarker)
    {
        this.x = x;
        this.y = y;
        this.mapMarker = mapMarker;
    }
}
