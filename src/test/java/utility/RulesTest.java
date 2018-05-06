package utility;

import domain.Peg;
import domain.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RulesTest {
    private final Row solution = new Row(new Peg[]{Peg.BLACK, Peg.GREEN, Peg.YELLOW, Peg.RED});

    @Test
    public void win() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.GREEN, Peg.YELLOW, Peg.RED});
        assertTrue(Rules.isWin(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_Three() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.BLUE, Peg.YELLOW, Peg.RED});
        assertEquals(3, Rules.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_RepeatedColor_OneCorrect() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.BLUE, Peg.BLACK, Peg.BLACK});
        assertEquals(1, Rules.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_Zero() {
        Row currentRow = new Row(new Peg[]{Peg.BLUE, Peg.WHITE, Peg.RED, Peg.GREEN});
        assertEquals(0, Rules.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Zero() {
        Row currentRow = new Row(new Peg[]{Peg.BLUE, Peg.WHITE, Peg.WHITE, Peg.BLUE});
        assertEquals(0, Rules.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Two() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.WHITE, Peg.RED, Peg.BLUE});
        assertEquals(2, Rules.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_RepeatedColor() {
        Row currentRow = new Row(new Peg[]{Peg.BLACK, Peg.BLACK, Peg.RED, Peg.BLUE});
        assertEquals(2, Rules.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Four() {
        Row currentRow = new Row(new Peg[]{Peg.RED, Peg.BLACK, Peg.GREEN, Peg.YELLOW});
        assertEquals(4, Rules.countCorrectColors(currentRow, solution));
    }
}