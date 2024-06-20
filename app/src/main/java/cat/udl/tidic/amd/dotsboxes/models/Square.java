package cat.udl.tidic.amd.dotsboxes.models;

import android.graphics.Point;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private List<Line> lines;
    private Player owner;
    private Point p1;
    private Point p2;

    public Square() {
        this.p2 = p2;
        this.p1 = p1;
        lines = new ArrayList<>();
    }

    // Getters y Setters
    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Point getP1() {
        return p1;
    }


    public Point getP2() {
        return p2;
    }


    public boolean isCompleted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lines.stream().allMatch(line -> line.getOwner() != null);
        }
        return false;
    }
}
