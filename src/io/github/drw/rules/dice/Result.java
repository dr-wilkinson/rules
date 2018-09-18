package io.github.drw.rules.dice;

import java.util.List;

/**
 * The result of applying one or more {@link Modifier}s to the value of the roll
 * of one or more {@link Dice} as compared with the value and
 * {@link SavingThrow.Target} of a {@link SavingThrow}.
 *
 * @author dr-wilkinson
 */
public class Result {

    private int total;
    private final SavingThrow savingThrow;
    private final List<Modifier> modifiers;
    private boolean successful;
    private int margin;

    /**
     * Constructs a new Result.
     *
     * @param total The total value of the result of one or more dice rolls.
     * @param savingThrow The SavingThrow to be rolled against.
     * @param modifiers A List of Modifiers to be applied to the dice roll
     * value.
     */
    public Result(int total, SavingThrow savingThrow, List<Modifier> modifiers) {
        this.total = total;
        this.savingThrow = savingThrow;
        this.modifiers = modifiers;
    }

    /**
     * Processes this Result and returns itself.
     * <p>
     * Used as a chain e.g.
     * <p>
     * {@code Result result = new Result(5, savingThrow, modifiers).process();}
     * <p>
     * ...creates a new Result, processes it and returns the Result.
     *
     * @return
     */
    public Result process() {
        for (Modifier modifier : modifiers) {
            if (modifier.getSign().equals(Modifier.Sign.NEGATIVE)) {
                total -= modifier.getValue();
            }
            if (modifier.getSign().equals(Modifier.Sign.POSITIVE)) {
                total += modifier.getValue();
            }
        }
        Outcome outcome = null;
        switch (savingThrow.getTarget()) {
            case OVER:
                if (total >= savingThrow.getValue()) {
                    outcome = Outcome.SUCCESS;
                } else {
                    outcome = Outcome.FAILURE;
                }
                break;
            case EXACTLY:
                if (total == savingThrow.getValue()) {
                    outcome = Outcome.SUCCESS;
                } else {
                    outcome = Outcome.FAILURE;
                }
                break;
            case UNDER:
                if (total <= savingThrow.getValue()) {
                    outcome = Outcome.SUCCESS;
                } else {
                    outcome = Outcome.FAILURE;
                }
                break;
        }
        margin = Math.abs(savingThrow.getValue() - total);
        successful = outcome.getBoolean();
        return this;
    }

    /**
     * Does this Result indicate a success or a failure?
     *
     * @return True if success, otherwise false for failure.
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Returns the margin of success or failure.
     *
     * @return The margin of success or failure.
     */
    public int getMargin() {
        return margin;
    }

    public int getTotal() {
        return total;
    }

    /**
     * An outcome - success or failure.
     */
    private enum Outcome {

        SUCCESS(true),
        FAILURE(false);

        private final boolean b;

        private Outcome(boolean b) {
            this.b = b;
        }

        /**
         * Returns the boolean value of this Outcome.
         *
         * @return This Outcome as a boolean value.
         */
        boolean getBoolean() {
            return b;
        }
    }

}
