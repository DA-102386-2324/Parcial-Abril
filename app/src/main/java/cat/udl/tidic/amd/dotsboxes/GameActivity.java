package cat.udl.tidic.amd.dotsboxes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.models.Player;
import cat.udl.tidic.amd.dotsboxes.models.Square;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

import android.util.Log;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this, null);
        setContentView(gameView);


    }


}
