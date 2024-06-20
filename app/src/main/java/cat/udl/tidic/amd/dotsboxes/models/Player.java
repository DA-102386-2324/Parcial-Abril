package cat.udl.tidic.amd.dotsboxes.models;

import android.graphics.Point;
import android.util.Pair;

public class Player {
    private String name;
    private int color;
    private boolean isPlaying;
    private int squares;
    public Pair<Point, Point> election;

    public Player() {
        //Constructor buit per Firebase
    }

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
        this.isPlaying = false;
        this.squares = 0;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public int getSquares() {
        return squares;
    }

    public void setSquares(int squares) {
        this.squares = squares;
    }

    public Pair<Point, Point> getElection() {
        return election;
    }

    public void setElection(Pair<Point, Point> election) {
        this.election = election;
    }
}
