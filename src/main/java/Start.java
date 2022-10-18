import java.util.Scanner;

public class    Start {
    Map map = new Map();
    Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Sokoban! What would you like to do?");

        while (true) {
            System.out.println("\n1 = learn how to play\n2 = start new game\n3 = choose level\n4 = high score\n\"exit\" ends the program");
            String input = scan.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    System.out.println(howTo());
                    break;
                case "2":
                    Game game = new Game();
                    game.gameOn(map.mapTemplate1);
                    break;
                case "3":
                    levelChoice();
                    break;
                case "4":
                    System.out.println("High score:\n1. - - - Linnea\n2. - - - Linnea\n3. - - - Linnea\n4. - - - Linnea\n5. - - - Linnea");
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Snälla skriv korrekt. Annars blir apan ledsen.");
            }
        }
    }

    public static String howTo() {
        return ("The game is played on a board of squares, where each square is a floor or a wall.\nSome floor squares contain boxes, and some floor squares are marked as storage locations.\nThe player is confined to the board and may move horizontally or vertically onto empty squares (never through walls or boxes).\nThe player can move a box by walking up to it and push it to the square beyond.\nBoxes cannot be pulled, and they cannot be pushed to squares with walls or other boxes.\nThe number of boxes equals the number of storage locations.\nThe puzzle is solved when all boxes are placed at storage locations.\n□ = Moveable boxes\n■ = Wall\n¥ = Player\nձ = Enemy");
    }

    public void levelChoice() {

        while (true) {
            System.out.println("1 = level 1\n2 = level 2\n3 = level 3\n\"return\" = back to start menu\n\"exit\" ends the program");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine().trim().toLowerCase();
            Game game = new Game();

            switch (input) {
                case "1":
                    game.gameOn(map.mapTemplate1);
                    break;
                case "2":
                    game.gameOn(map.mapTemplate2);
                    break;
                case "3":
                    game.gameOn(map.mapTemplate3);
                    break;
                case "return":
                    start();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Snälla skriv korrekt. Annars blir apan ledsen.");
            }
        }
    }
}