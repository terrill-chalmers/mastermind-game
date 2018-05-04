package domain;

import java.util.Random;

public enum Peg {
    BLACK("black", 0),
    WHITE("white", 1),
    RED("red", 2),
    BLUE("blue", 3),
    GREEN("green", 4),
    YELLOW("yellow", 5);

    private final String name;
    private final int index;

    Peg(final String name, final int index) { this.name = name; this.index = index; }

    public Peg getByName(String name) { return Peg.valueOf(name); }

    public int getIndex() { return index; }

    public static Peg getRandomColor() {
        return values()[new Random().nextInt(values().length)];
    }
}
