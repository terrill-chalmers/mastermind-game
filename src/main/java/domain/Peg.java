package domain;

import exception.UnknownPegException;

import java.util.Random;

public enum Peg {
    BLK(0),
    WHT(1),
    RED(2),
    BLU(3),
    GRN(4),
    YLO(5);

    private final int index;

    Peg(final int index) { this.index = index; }

    public int getIndex() { return index; }

    public static Peg getRandomColor() {
        return values()[new Random().nextInt(values().length)];
    }

    public static Peg convertEntryToPeg(String entry) throws UnknownPegException {
        if(entry.toUpperCase().equals("RED") || entry.toUpperCase().equals("R")){
            return Peg.RED;
        } else if(entry.toUpperCase().equals("BLK") || entry.toUpperCase().equals("K")){
            return Peg.BLK;
        } else if(entry.toUpperCase().equals("BLU") || entry.toUpperCase().equals("U")){
            return Peg.BLU;
        } else if(entry.toUpperCase().equals("WHT") || entry.toUpperCase().equals("W")){
            return Peg.WHT;
        } else if(entry.toUpperCase().equals("GRN") || entry.toUpperCase().equals("G")){
            return Peg.GRN;
        } else if(entry.toUpperCase().equals("YLO") || entry.toUpperCase().equals("Y")){
            return Peg.YLO;
        } else {
            throw new UnknownPegException();
        }
    }
}
