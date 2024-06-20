package cat.udl.tidic.amd.dotsboxes.models;

import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Player playerRed;
    private Player playerBlue;

    public Game(Board board) {
        this.board = board;
        this.playerRed = new Player("Red", Color.RED);
        this.playerBlue = new Player("Blue", Color.BLUE);
        this.playerRed.setPlaying(true);
    }

    // Getters y Setters
    public Board getBoard() {
        return board;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Player playerRed) {
        this.playerRed = playerRed;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    public void setPlayerBlue(Player playerBlue) {
        this.playerBlue = playerBlue;
    }

    public Player currentPlayer() {
        if (playerRed.isPlaying()) {
            return playerRed;
        } else if (playerBlue.isPlaying()){
            return playerBlue;
        } else {
            return null;
        }

    }

    public void nextPlayer() {
        if (playerRed.isPlaying()) {
            playerRed.setPlaying(false);
            playerBlue.setPlaying(true);
        } else {
            playerRed.setPlaying(true);
            playerBlue.setPlaying(false);
        }
    }
}
