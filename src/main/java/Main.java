import domain.Game;
import domain.Peg;

import static domain.Row.createRandomRow;

public class Main {
    public static void main(String[] args) {
        new Game(createRandomRow());
    }
}
