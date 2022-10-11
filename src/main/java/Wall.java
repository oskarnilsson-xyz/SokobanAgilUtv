public class Wall extends GameObject {

    protected boolean wall = true;

    public Wall(int y, int x) {
        super(y, x, "W");

    }

    //Skapades inledningvis, men har ingen nuvarande implementation. Kan användas vid framtiden (eller tas bort)
    public boolean isWall() {
        return wall;
    }

}
