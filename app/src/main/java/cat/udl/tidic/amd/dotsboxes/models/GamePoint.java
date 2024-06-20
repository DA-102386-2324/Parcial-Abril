package cat.udl.tidic.amd.dotsboxes.models;

public class GamePoint {
    private int x;
    private int y;

    public GamePoint() {
        this.x = 0;
        this.y = 0;
    }

    public GamePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters y Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
