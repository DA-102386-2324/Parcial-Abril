package cat.udl.tidic.amd.dotsboxes.models;

import android.graphics.Point;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.concurrent.atomic.AtomicBoolean;

public class Line {
    private Point pa;
    private Point pb;
    private Player owner;

    public Line() {
    }

    public Line(Point pa, Point pb) {
        this.pa = pa;
        this.pb = pb;
        this.owner = null;
    }

    // Getters y Setters
    public Point getPA() {
        return pa;
    }

    public void setPA(Point pa) {
        this.pa = pa;
    }

    public Point getPB() {
        return pb;
    }

    public void setPB(Point pb) {
        this.pb = pb;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
