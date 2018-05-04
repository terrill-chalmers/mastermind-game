package domain;

import org.pmw.tinylog.Logger;

import java.io.Console;

public class Game {
    private Row solution;
    private Row[] board;
    Console console = System.console();

    public Game(Row solution) {
        this.solution = solution;
        Logger.info(solution.toReadableString());
        board = new Row[12];
    }

    public Row getSolution() { return solution; }

    public Row[] getBoard() { return board; }

    public void setBoard(Row[] board) { this.board = board; }

    public boolean isWin(Row currentRow) {
        return 4 == countCorrectPegs(currentRow, solution);
    }

    protected int countCorrectPegs(Row currentRow, Row solution) {
        int total = 0;

        for (int i = 0; i < solution.getPattern().length; i++) {
            if (currentRow.getPattern()[i] == solution.getPattern()[i]) {
                total += 1;
            }
        }

        return total;
    }

    protected int countCorrectColors(Row currentRow, Row solution) {
        int total = 0;

        int[] currentRowColorCount = createColorCountArray(currentRow);
        int[] solutionColorCount = createColorCountArray(solution);

        for (int i = 0; i < Peg.values().length; i++) {
            total += Math.min(currentRowColorCount[i], solutionColorCount[i]);
        }

        return total;
    }

    private int[] createColorCountArray(Row row) {
        int[] colorTotals = new int[Peg.values().length];

        for (int i = 0; i < row.getPattern().length; i++) {
            colorTotals[row.getPattern()[i].getIndex()] += 1;
        }

        return colorTotals;
    }

    protected Peg enterColor() {
        return console.readLine();
    }
}
