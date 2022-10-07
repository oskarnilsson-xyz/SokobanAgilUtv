public class Player extends GameObject {


    public Player() {

    }

    public Player(int x, int y) { //ärver från GameObject och position definieras när objektet skapas
        super(x, y, "P");
    }

}
