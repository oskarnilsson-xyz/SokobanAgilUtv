public class Box extends GameObject {

    private boolean box = true;

    public Box(int x, int y) { //ärver från GameObject och position definieras när objektet skapas
        super(x, y, "B"); //markör på banan är B och det går inte att gå in i eller igenom boxen
    }

    public boolean isBox() {
        return box;
    }


}
