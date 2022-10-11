public class GoalTile extends GameObject{
    private boolean goalTile = true;
    private String goalTilePosition; //Sparar orginalpositionerna så att man kan kolla dem mot vinst, tex om något (spelare/box) flyttats till och sedan ifrån en goalTile.

    public GoalTile(int y, int x) { //ärver från GameObject och position definieras när objektet skapas
        super(y, x, "G");

    }

    //Skapades inledningvis, men har ingen nuvarande implementation. Kan användas vid framtiden (eller tas bort)
    public boolean isGoalTile() {
        return goalTile;
    }

}
