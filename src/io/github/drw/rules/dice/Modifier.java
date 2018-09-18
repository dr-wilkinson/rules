package io.github.drw.rules.dice;

/**
 * A value to be applied to a die roll value before it is used.
 *
 * @author dr-wilkinson
 */
public class Modifier {

    private final int value;
    private final Sign sign;

    /**
     * Constructs a new Modifier.
     *
     * @param value The value of the new Modifier.
     * @param sign The sign (positive or negative) of the new Modifiers value.
     */
    public Modifier(int value, Sign sign) {
        this.value = value;
        this.sign = sign;
    }

    /**
     * Returns the value of this Modifier.
     *
     * @return This Modifiers value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the sign of this Modifier.
     *
     * @return This Modifiers sign - positive or negative.
     */
    public Sign getSign() {
        return sign;
    }

    /**
     * The sign (positive or negative).
     */
    public enum Sign {
        POSITIVE,
        NEGATIVE;
    }

}
