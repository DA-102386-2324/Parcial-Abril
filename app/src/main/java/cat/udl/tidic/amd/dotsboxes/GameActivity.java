package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.widget.TextView;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;
import cat.udl.tidic.amd.dotsboxes.models.Player;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private  GameViewModel gameViewModel;

    private TextView currentPlayerTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        currentPlayerTV = findViewById(R.id.currentPlayerTV);

        initDataBinding();
        gameView = findViewById(R.id.gameView);

        gameViewModel.getCurrentPlayer().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player currentPlayer) {
                updateCurrentPlayer(currentPlayer);
            }
        });
    }

    private void initDataBinding() {
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
    }

    private void updateCurrentPlayer(Player currentPlayer) {
        currentPlayerTV.setText(currentPlayer.getName());
    }


}
