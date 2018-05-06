package utility;

import domain.Peg;
import domain.Row;

public class Rules {

    public static boolean isWin(Row currentRow, Row solution) {
        return solution.getPattern().length == countCorrectPegs(currentRow, solution);
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

        for (int colorIndex = 0; colorIndex < Peg.values().length; colorIndex++) {
            total += Math.min(currentRowColorCount[colorIndex], solutionColorCount[colorIndex]);
        }

        return total;
    }

    private static int[] createColorCountArray(Row row) {
        int[] colorTotals = new int[Peg.values().length];

        for (int rowIndex = 0; rowIndex < row.getPattern().length; rowIndex++) {
            colorTotals[row.getPattern()[rowIndex].getIndex()] += 1;
        }

        return colorTotals;
    }
}

