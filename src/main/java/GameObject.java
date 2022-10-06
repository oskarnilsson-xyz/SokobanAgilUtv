public class GameObject {
    protected int x;
    protected int y;

    protected String mapMarker;

    protected boolean solid;





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

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }



    public GameObject(int x, int y, String mapMarker)
    {
        this.x = x;
        this.y = y;
        this.mapMarker = mapMarker;
    }


}
