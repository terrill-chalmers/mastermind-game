package domain;

import exception.UnknownPegException;
import utility.Rules;

import java.util.Scanner;

import static domain.Row.createRandomSolution;

public class Game {
    private Row solution;
    private Row[] board;
    private int[][] feedback;

    public Game() {
        this.solution = createRandomSolution();
        board = new Row[12];
        feedback = new int[12][2];
    }

    public void playGame() {
        boolean winGame = false;
        displayWelcome();

        for (int turn = 1; turn <= 12; turn++) {
            Row currentGuess = enterGuess(turn);

            if (Rules.isWin(currentGuess, solution)) {
                winGame = displayWin(turn);
                break;
            }

            loadTurn(turn, currentGuess);
            displayBoard(turn);
        }

        displayLoss(winGame);
    }

    private void displayWelcome() {
        System.out.println("Welcome to Mastermind.");
    }

    private boolean displayWin(int turn) {
        System.out.println("You win in " + turn + " turns. The solution is " + solution.toReadableString());
        return true;
    }

    private void displayLoss(boolean winGame) {
        if (!winGame) {
            System.out.println("You lose. The correct answer is " + solution.toReadableString());
        }
    }

    protected Row enterGuess(int turn) {
        Peg[] pegs = new Peg[4];
        System.out.println("\nBlack = k, Blue = u, White = w, Red = r, Green = g, Yellow = y");
        for (int pegNumber = 1; pegNumber <= 4; pegNumber++) {
            pegNumber = enterPeg(turn, pegs, pegNumber);
        }
        System.out.println("\n");

        Row guess = new Row();
        guess.setPattern(pegs);

        return guess;
    }

    private int enterPeg(int turn, Peg[] pegs, int pegNumber) {
        try {
            System.out.print("Turn #" + turn + ": Enter a color for peg " + pegNumber + ": ");
            Scanner scanner = new Scanner(System.in);
            pegs[pegNumber - 1] = Peg.convertEntryToPeg(scanner.nextLine());
        } catch (UnknownPegException e) {
            pegNumber--;
        }
        return pegNumber;
    }

    private void loadTurn(int turn, Row currentGuess) {
        board[turn - 1] = currentGuess;
        feedback[turn - 1][0] = Rules.countCorrectPegs(currentGuess, solution);
        feedback[turn - 1][1] = Rules.countCorrectColors(currentGuess, solution);
    }

    private void displayBoard(int currentTurn) {
        for (int turn = 0; turn < currentTurn; turn++) {
            System.out.println("Turn #" + (turn + 1) + ": " +
                    board[turn].toReadableString() + " | " +
                    "Correct pegs: " + feedback[turn][0] + " | " +
                    "Correct colors: " + feedback[turn][1]);
        }
    }
}