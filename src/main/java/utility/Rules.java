package utility;

import domain.Peg;
import domain.Row;

public class Rules {

    public static boolean isWin(Row currentRow, Row solution) {
        return 4 == countCorrectPegs(currentRow, solution);
    }

    public static int countCorrectPegs(Row currentRow, Row solution) {
        int total = 0;

        for (int i = 0; i < solution.getPattern().length; i++) {
            if (currentRow.getPattern()[i] == solution.getPattern()[i]) {
                total += 1;
            }
        }

        return total;
    }

    public static int countCorrectColors(Row currentRow, Row solution) {
        int total = 0;

        int[] currentRowColorCount = createColorCountArray(currentRow);
        int[] solutionColorCount = createColorCountArray(solution);

        for (int i = 0; i < Peg.values().length; i++) {
            total += Math.min(currentRowColorCount[i], solutionColorCount[i]);
        }

        return total;
    }

    private static int[] createColorCountArray(Row row) {
        int[] colorTotals = new int[Peg.values().length];

        for (int i = 0; i < row.getPattern().length; i++) {
            colorTotals[row.getPattern()[i].getIndex()] += 1;
        }

        return colorTotals;
    }
}

