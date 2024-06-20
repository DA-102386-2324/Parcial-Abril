package cat.udl.tidic.amd.dotsboxes.models;

import android.graphics.Point;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Square> squares;
    private int M;
    private int N;
    private int xMargin;
    private int yMargin;
    private int xDistance;
    private int yDistance;

    public Board(int M, int N) {
        this.M = M;
        this.N = N;
        this.squares = new ArrayList<>();
        build();
    }

    public void setBoardDimensions(int xMargin, int yMargin, int xDistance, int yDistance) {
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.xDistance = xDistance;
        this.yDistance = yDistance;
    }

    public void build() {
        squares.clear();
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                Square square = new Square(


                );
                squares.add(square);
            }
        }
    }

    public List<Square> getSquares() {
        return squares;
    }

    public Point getPoint(Point current) {
        for (Square square : squares) {
            for (Line line : square.getLines()) {
                if (line.getPA().equals(current)) {
                    return line.getPB();
                } else if (line.getPB().equals(current)) {
                    return line.getPA();
                }
            }
        }
        return null;
    }

    public MoveState isValidElection(Pair<Point, Point> election) {
        Point p1 = election.first;
        Point p2 = election.second;

        for (Square square : squares) {
            for (Line line : square.getLines()) {
                if (line.getPA().equals(p1) && line.getPB().equals(p2) && line.getOwner() == null) {
                    return new MoveState(true, "Valid move");
                }
            }
        }
        return new MoveState(false, "Invalid move");
    }

    public boolean update(Player player) {
        boolean completedSquare = false;
        for (Square square : squares) {
            for (Line line : square.getLines()) {
                if (line.getPA().equals(player.getElection().first) && line.getPB().equals(player.getElection().second)) {
                    line.setOwner(player);
                    if (square.isCompleted()) {
                        square.setOwner(player);
                        completedSquare = true;
                    }
                }
            }
        }
        return completedSquare;
    }

    public void updateSquare(Square square) {
        for (Square s : squares) {
            if (s.getP1().equals(square.getP1()) && s.getP2().equals(square.getP2())) {
                s.setLines(square.getLines());
                s.setOwner(square.getOwner());
            }
        }
    }
}
