package domain;

import lombok.Getter;
import lombok.Setter;

import static domain.Peg.getRandomColor;

public class Row {
    private Peg[] pattern;

    public Row(Peg[] pattern) { this.pattern = pattern; }

    public static Row createRandomRow() {
        Peg[] pattern = new Peg[4];
        for(int i=0; i < pattern.length; i++) {
            pattern[i] = getRandomColor();
        }

        return new Row(pattern);
    }

    public Peg[] getPattern() { return pattern; }

    public void setPattern(Peg[] pattern) { this.pattern = pattern; }
}
