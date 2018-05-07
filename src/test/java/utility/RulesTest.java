package utility;

import domain.Peg;
import domain.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RulesTest {
    private final Row solution = new Row(new Peg[]{Peg.BLK, Peg.GRN, Peg.YLO, Peg.RED});

    @Test
    public void win() {
        Row currentRow = new Row(new Peg[]{Peg.BLK, Peg.GRN, Peg.YLO, Peg.RED});
        assertTrue(Rules.isWin(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_Three() {
        Row currentRow = new Row(new Peg[]{Peg.BLK, Peg.BLU, Peg.YLO, Peg.RED});
        assertEquals(3, Rules.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_RepeatedColor_OneCorrect() {
        Row currentRow = new Row(new Peg[]{Peg.BLK, Peg.BLU, Peg.BLK, Peg.BLK});
        assertEquals(1, Rules.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectPegs_Zero() {
        Row currentRow = new Row(new Peg[]{Peg.BLU, Peg.WHT, Peg.RED, Peg.GRN});
        assertEquals(0, Rules.countCorrectPegs(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Zero() {
        Row currentRow = new Row(new Peg[]{Peg.BLU, Peg.WHT, Peg.WHT, Peg.BLU});
        assertEquals(0, Rules.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Two() {
        Row currentRow = new Row(new Peg[]{Peg.BLK, Peg.WHT, Peg.RED, Peg.BLU});
        assertEquals(2, Rules.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_RepeatedColor() {
        Row currentRow = new Row(new Peg[]{Peg.BLK, Peg.BLK, Peg.RED, Peg.BLU});
        assertEquals(2, Rules.countCorrectColors(currentRow, solution));
    }

    @Test
    public void countCorrectColors_Four() {
        Row currentRow = new Row(new Peg[]{Peg.RED, Peg.BLK, Peg.GRN, Peg.YLO});
        assertEquals(4, Rules.countCorrectColors(currentRow, solution));
    }
}