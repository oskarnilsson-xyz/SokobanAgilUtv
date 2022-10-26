import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

public class HighScore {

    private Integer[] highScore = {100, 99, 98, 97, 96};
    private String playerName = "Linnea";

    public void run() {
        //addHighScore(playerName, 97);
        setHighScore();
        printHighScore();
    }

    public void setHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int j = 0; j < highScore.length; j++) {
                    highScore[j] = Integer.valueOf(reader.readLine());
                }
                //System.out.println(Arrays.toString(highScore));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public Integer[] getHighScore() {
        return highScore;
    }

    public String getPlayerName() {
        return playerName;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean madeHighScore(Integer stepCount) {
        for (int i = 0; i < highScore.length; i++) {
            if (stepCount < highScore[i]) {
                highScore[i] = stepCount;
                addHighScore(playerName, stepCount);
                return true;
            }
        }
        return false;
    }


    public void addHighScore(String playerName, Integer stepCount) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"));
            for (int i = 0; i < highScore.length; i++) {
            writer.write("\n" + highScore[i]);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHighScore() {
        for (int j = 0; j < highScore.length; j++) {
            System.out.println("sourseHighScore " + (j + 1) + " = " + playerName + " with " + highScore[j] + " steps");
        }
    }
}

