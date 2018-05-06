package domain;

import exception.UnknownPegException;

import java.util.Random;

public enum Peg {
    BLACK(0),
    WHITE(1),
    RED(2),
    BLUE(3),
    GREEN(4),
    YELLOW(5);

    private final int index;

    Peg(final int index) { this.index = index; }

    public int getIndex() { return index; }

    public static Peg getRandomColor() {
        return values()[new Random().nextInt(values().length)];
    }

    public static Peg convertEntryToPeg(String entry) throws UnknownPegException {
        if(entry.toUpperCase().equals("RED") || entry.toUpperCase().equals("R")){
            return Peg.RED;
        } else if(entry.toUpperCase().equals("BLACK") || entry.toUpperCase().equals("K")){
            return Peg.BLACK;
        } else if(entry.toUpperCase().equals("BLUE") || entry.toUpperCase().equals("U")){
            return Peg.BLUE;
        } else if(entry.toUpperCase().equals("WHITE") || entry.toUpperCase().equals("W")){
            return Peg.WHITE;
        } else if(entry.toUpperCase().equals("GREEN") || entry.toUpperCase().equals("G")){
            return Peg.GREEN;
        } else if(entry.toUpperCase().equals("YELLOW") || entry.toUpperCase().equals("Y")){
            return Peg.YELLOW;
        } else {
            throw new UnknownPegException();
        }
    }
}
