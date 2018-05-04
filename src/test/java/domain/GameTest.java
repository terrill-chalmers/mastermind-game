package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {
    private Game classToTest;
    private final Row solution = new Row(new Peg[]{Peg.BLACK, Peg.GREEN, Peg.YELLOW, Peg.RED});

    @Before
    public void setUp() {
        classToTest = new Game(solution);
    }

    @Test
    public void win() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.GREEN, Peg.YELLOW, Peg.RED});
        assertTrue(classToTest.isWin(currentRow));
    }

    @Test
    public void countCorrectPegs_Three() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.BLUE, Peg.YELLOW, Peg.RED});
        assertEquals(3, classToTest.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_Zero() {
        Row currentRow = new Row(new Peg[]{Peg.BLUE, Peg.WHITE, Peg.RED, Peg.GREEN});
        assertEquals(0, classToTest.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Zero() {
        Row currentRow = new Row(new Peg[]{Peg.BLUE, Peg.WHITE, Peg.WHITE, Peg.BLUE});
        assertEquals(0, classToTest.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Two() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.WHITE, Peg.RED, Peg.BLUE});
        assertEquals(2, classToTest.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_RepeatedColor() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.BLACK, Peg.RED, Peg.BLUE});
        assertEquals(2, classToTest.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Four() {
        Row currentRow = new Row(new Peg[]{Peg.RED, Peg.BLACK, Peg.GREEN, Peg.YELLOW});
        assertEquals(4, classToTest.countCorrectColors(currentRow, solution));
    }
}