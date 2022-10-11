public class Wall extends GameObject {

    protected boolean wall = true;

    public Wall(int x, int y) {
        super(x, y, "W");

    }

    public boolean isWall() {
        return wall;
    }

}
