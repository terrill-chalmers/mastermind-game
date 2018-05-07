package domain;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.when;

public class GameTest {
    private Game classToTest;
    private final Row solution = new Row(new Peg[]{Peg.BLK, Peg.GRN, Peg.YLO, Peg.RED});

    @Before
    public void setUp() {
        classToTest = new Game();
    }


    @Test
    public void enterColor() {
        Row guess = new Row(new Peg[]{Peg.BLK, Peg.RED, Peg.BLU, Peg.GRN});
        when(classToTest.enterGuess(1)).thenReturn(guess);
//        Row classToTest.enterGuess(1);
    }
}