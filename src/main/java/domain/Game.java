package domain;

public class Game {
    private Row solution;
    private Row[] board;

    public Game(Row solution) {
        this.solution = solution;
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

        for(int i=0; i < solution.getPattern().length; i++) {
            if(currentRow.getPattern()[i] == solution.getPattern()[i]) {
                total += 1;
            }
        }

        return total;
    }

    public int countCorrectColors(Row currentRow, Row solution) {
        int total = 0;

        ColorTotals currentColorTotals = addRowColorTotals(currentRow);
        ColorTotals solutionColorTotals = addRowColorTotals(solution);

        sumEachColor(currentColorTotals, solutionColorTotals);

        return total;
    }

    private int sumEachColor(ColorTotals currentColorTotals, ColorTotals solutionColorTotals) {
        int total = 0;

        if(currentColorTotals.getBlackPegs() == solutionColorTotals.getBlackPegs()) {
            //
        }

        return total;
    }

    private ColorTotals addRowColorTotals(Row row) {
        ColorTotals colorTotals = new ColorTotals();
        for(int i=0; i < row.getPattern().length; i++) {
            colorTotals.incrementColor(row.getPattern()[i]);
        }

        return colorTotals;
    }
}
