package domain;

import static domain.Peg.getRandomColor;

public class Row {
    private Peg[] pattern;

    Row() { }
    public Row(Peg[] pattern) { this.pattern = pattern; }

    static Row createRandomSolution() {
        Peg[] pattern = new Peg[4];
        for(int i=0; i < pattern.length; i++) {
            pattern[i] = getRandomColor();
        }

        return new Row(pattern);
    }

    public Peg[] getPattern() { return pattern; }

    public void setPattern(Peg[] pattern) { this.pattern = pattern; }

    public String toReadableString() {
        return this.getPattern()[0] + "  " + this.getPattern()[1] + "  " + this.getPattern()[2] + "  " + this.getPattern()[3];
    }
}
