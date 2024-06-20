package cat.udl.tidic.amd.dotsboxes.viewmodels;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cat.udl.tidic.amd.dotsboxes.models.Game;
import cat.udl.tidic.amd.dotsboxes.models.Player;


public class GameViewModel extends ViewModel {
    private MutableLiveData<Integer> scorePlayer1;
    private MutableLiveData<Integer> scorePlayer2;
    private Game game;

    public GameViewModel() {
        this.scorePlayer1 = new MutableLiveData<>(0);
        this.scorePlayer2 = new MutableLiveData<>(0);
    }

    public MutableLiveData<Integer> getScorePlayer1() {
        return scorePlayer1;
    }

    public MutableLiveData<Integer> getScorePlayer2() {
        return scorePlayer2;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void increaseScorePlayer1() {
        int currentScore = scorePlayer1.getValue() != null ? scorePlayer1.getValue() : 0;
        scorePlayer1.setValue(currentScore + 1);
    }

    public void increaseScorePlayer2() {
        int currentScore = scorePlayer2.getValue() != null ? scorePlayer2.getValue() : 0;
        scorePlayer2.setValue(currentScore + 1);
    }

    public void updateScore(Player player) {
        if (player.getColor() == Color.RED) {
            increaseScorePlayer1();
        } else if (player.getColor() == Color.BLUE) {
            increaseScorePlayer2();
        }
    }
}
