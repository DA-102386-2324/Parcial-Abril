package cat.udl.tidic.amd.dotsboxes.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cat.udl.tidic.amd.dotsboxes.models.Board;
import cat.udl.tidic.amd.dotsboxes.models.Game;
import cat.udl.tidic.amd.dotsboxes.models.Line;
import cat.udl.tidic.amd.dotsboxes.models.MoveState;
import cat.udl.tidic.amd.dotsboxes.models.Square;
import cat.udl.tidic.amd.dotsboxes.models.GamePoint;


public class GameView extends View {

    static String TAG = "GameView";
    static int M = 4;
    static int N = 4;

    private DatabaseReference databaseReference;

    Game game;
    Board board;

    private int yDistance;
    private int xDistance;
    private List<Point> points;
    private boolean endTurn = false;
    protected Paint paint;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        points = new ArrayList<>();


        board = new Board(M, N);

        game = new Game(board);


        paint = new Paint();


        databaseReference = FirebaseDatabase.getInstance().getReference();


        databaseReference.child("game").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Game loadedGame = snapshot.getValue(Game.class);
                    if (loadedGame != null) {
                        game = loadedGame;
                        board = game.getBoard();
                        invalidate();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.e(TAG, "Failed to load game state from Firebase", error.toException());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (game.currentPlayer() == null) {
            yDistance = getMeasuredHeight() / M;
            xDistance = getMeasuredWidth() / N;
            int xMargin = xDistance / 2;
            int yMargin = yDistance / 2;
            this.game.getBoard().setBoardDimensions(xMargin, yMargin, xDistance, yDistance);
            this.game.getBoard().build();
        }

        board.getSquares().forEach((Square square) -> {
            square.getLines().forEach((Line l) -> {

                Point p1 = l.getPA();
                Point p2 = l.getPB();

                if (l.getOwner() == game.getPlayerRed()) {
                    paint.setColor(Color.RED);
                    paint.setStrokeWidth(30);
                    canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
                } else if (l.getOwner() == game.getPlayerBlue()) {
                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(30);
                    canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
                } else {
                    paint.setColor(Color.BLACK);
                }

                paint.setColor(Color.BLACK);
                canvas.drawCircle(p1.x, p1.y, 30, paint);
                canvas.drawCircle(p2.x, p2.y, 30, paint);
            });

            if (square.isCompleted()) {
                paint.setTextSize(300);
                paint.setColor(square.getOwner().getColor());

                canvas.drawText(square.getOwner().getName(),
                        square.getP2().x + xDistance / 7,
                        square.getP2().y - yDistance / 5, paint);
            }
        });

        if (game.currentPlayer() == null) {
            game.getPlayerBlue().setPlaying(true);
        } else {
            if (endTurn) {
                game.nextPlayer();
            }
        }
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Point current = new Point(x, y);
        Log.d("GameView", game.currentPlayer().getName());
        Point p = board.getPoint(current);

        if (p != null) {
            if (game.currentPlayer().getElection() == null) {
                game.currentPlayer().setElection(new Pair<>(p, new Point()));
                Log.d("GameView", game.currentPlayer().getElection().toString());
            } else {
                game.currentPlayer().getElection().second.set(p.x, p.y);
                Log.d("GameView", game.currentPlayer().getElection().toString());
                MoveState moveState = board.isValidElection(game.currentPlayer().getElection());
                if (moveState.isValid) {
                    endTurn = !board.update(game.currentPlayer());
                    if (!endTurn) {
                        game.currentPlayer().setSquares(game.currentPlayer().getSquares() + 1);
                    }
                    updateFirebaseGame();
                } else {
                    endTurn = false;
                }
                invalidate();
                game.currentPlayer().setElection(null);
            }
        }
        performClick();
        return false;
    }

    private void updateFirebaseGame() {
        databaseReference.child("game").setValue(game).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d(TAG, "Game state updated in Firebase");
            } else {
                Log.e(TAG, "Failed to update game state in Firebase", task.getException());
            }
        });
    }
}