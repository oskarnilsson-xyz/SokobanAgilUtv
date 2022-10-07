public class Box extends GameObject {

    private boolean box = true;

    public Box(int y, int x) { //ärver från GameObject och position definieras när objektet skapas
        super(y, x, "B"); //markör på banan är B och det går inte att gå in i eller igenom boxen
    }

    public boolean isPushable() { //kan anropas av funktion som kollar om lådan kan förflyttas ett steg i samma riktning som spelaren (pushable)
        /*if (två platser bort i riktningen är tom){
            return true;
        }
        else {
            return false;
        }*/
        return false; // för att slippa skriva void i funktionen tills vi har implementerat funktionen
    }

    public boolean isBox() {
        return box;
    }


}
