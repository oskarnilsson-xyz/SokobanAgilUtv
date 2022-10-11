public class GoalTile extends GameObject{
    private boolean goalTile = true;
    private String goalTilePosition; //Sparar orginalpositionerna så att man kan kolla dem mot vinst, tex om något (spelare/box) flyttats till och sedan ifrån en goalTile.

    public GoalTile(int x, int y) { //ärver från GameObject och position definieras när objektet skapas
        super(x, y, "G");

    }

    public boolean isGoalTile() {
        return goalTile;
    }

}
