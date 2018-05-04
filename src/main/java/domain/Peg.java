package domain;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Random;

public enum Peg {
    BLACK,
    WHITE,
    RED,
    BLUE,
    GREEN,
    YELLOW;

    public static Peg getRandomColor() {
        return values()[new Random().nextInt(values().length)];
    }
}
