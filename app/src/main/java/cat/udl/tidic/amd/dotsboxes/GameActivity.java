package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private  GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initDataBinding();
        gameView = (GameView) findViewById(R.id.gameView);
        //

    }

    //TODO
    private void initDataBinding() {
    }
    //
}