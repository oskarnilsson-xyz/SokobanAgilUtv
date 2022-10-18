public class Wall extends GameObject {

    protected boolean wall = true;


    public Wall(int x, int y) {
        super(x, y, "■");
    }

    //Skapades inledningvis, men har ingen nuvarande implementation. Kan användas vid framtiden (eller tas bort)
    public boolean isWall() {
        return wall;
    }
}
