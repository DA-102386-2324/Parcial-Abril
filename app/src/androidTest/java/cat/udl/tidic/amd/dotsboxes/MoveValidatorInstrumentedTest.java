package cat.udl.tidic.amd.dotsboxes;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Pair;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import cat.udl.tidic.amd.dotsboxes.models.Board;
import cat.udl.tidic.amd.dotsboxes.models.MoveState;
import cat.udl.tidic.amd.dotsboxes.models.Player;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MoveValidatorInstrumentedTest {

    Board board = new Board(4,4);
    Context context;

    @Before
    public void setUp(){
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        board.build();
    }

    // Legend of board points
    // (122,169) (367,169) (612,169) (857,169)
    // (122,508) (367,508) (612,508) (857,508)
    // (122,847) (367,847) (612,847) (857,847)
    // (122,1186) (367,1186) (612,1186) (857,1186)

    @Test
    public void line_isDiagonal(){

    }

    @Test
    public void line_isNotDiagonal(){

    }

    @Test
    public void isNotALineSamePoints(){

    }

    @Test
    public void theLineIsOwnedByTheOtherPlayer(){

    }

    @Test
    public void isACorrectLineDiffPoints(){

    }




}