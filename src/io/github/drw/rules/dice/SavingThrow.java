package io.github.drw.rules.dice;

/**
 * The value that one or more dice must be rolled under, equal to or over in
 * order for the roll to be successful or not.
 *
 * @author dr-wilkinson
 */
public class SavingThrow {

    private final int value;
    private final Target target;

    /**
     * Constructs a new SavingThrow.
     *
     * @param value The value to be compared.
     * @param target The Target that the value will be compared to.
     */
    public SavingThrow(int value, Target target) {
        this.value = value;
        this.target = target;
    }

    /**
     * Returns the value of this SavingThrow.
     *
     * @return This SavingThrows value.
     */
    public int getValue() {
        return value;
    }

    /**
     * The Target of this SavingThrow.
     *
     * @return This SavingThrows Target.
     */
    public Target getTarget() {
        return target;
    }

    /**
     * A Target - over, exactly or under.
     */
    public enum Target {
        OVER,
        EXACTLY,
        UNDER;
    }

}
