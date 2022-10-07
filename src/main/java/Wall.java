public class Wall extends GameObject {

    protected boolean wall = true;

    public Wall(int y, int x) {
        super(y, x, "W");

    }

    public boolean isWall() {
        return wall;
    }

}
