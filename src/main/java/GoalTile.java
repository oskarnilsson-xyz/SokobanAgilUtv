public class GoalTile extends GameObject{
    private boolean goalTile = true;
    private String goalTilePosition; //Sparar orginalpositionerna så att man kan kolla dem mot vinst, tex om något (spelare/box) flyttats till och sedan ifrån en goalTile.

    public GoalTile(int y, int x) { //ärver från GameObject och position definieras när objektet skapas
        super(y, x, "G");

    }

    public boolean isWin() { //kan anropas av funktion som kollar om det finns någon goalTile kvar
        /*if (står box på alla goalTiles){
            return true;
        }
        else {
            return false;
        }*/
        return false; // för att slippa skriva void i funktionen tills vi har implementerat funktionen
    }

    public boolean isGoalTile() {
        return goalTile;
    }

}
