package cat.udl.tidic.amd.dotsboxes.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import cat.udl.tidic.amd.dotsboxes.models.Game;
import cat.udl.tidic.amd.dotsboxes.models.Player;

// TODO
public class GameViewModel extends ViewModel {
    private MutableLiveData<Player> currentPlayer;

    public LiveData<Player> getCurrentPlayer() {
        if (currentPlayer == null) {
            currentPlayer = new MutableLiveData<Player>();
        }
        return currentPlayer;

    }
}