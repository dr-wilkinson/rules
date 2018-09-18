package io.github.drw.rules.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates dice roll results of various kinds.
 *
 * @author dr-wilkinson
 */
public class Dice {

    private static Random random = new Random(System.currentTimeMillis());

    private static List<Integer> rolls = new ArrayList<>();

    private static boolean isVerbose = false;

    public static void setVerbose(boolean b) {
        isVerbose = b;
    }

    /**
     * Simply returns an integer value as the result of rolling one or more
     * dice.
     *
     * @param numberOfDie The number of dice to roll. Clamped to a minimum of
     * one die.
     * @return The value of rolling the dice.
     */
    public static int roll(int numberOfDie) {
        rolls.clear();
        if (numberOfDie <= 0) {
            numberOfDie = 1;
        }
        int total = 0;
        for (int i = 0; i < numberOfDie; i++) {
            int roll = random.nextInt(6) + 1;
            total += roll;
            rolls.add(roll);
        }
        return total;
    }

    /**
     * Returns a {@link Result} object which encapsulates the combination of the
     * value of rolling one or more dice against a {@link SavingThrow} with
     * {@link Modifier}s applied.
     *
     * @param numberOfDie The total number of die to roll. Clamped to a minimum
     * of one.
     * @param savingThrow The SavingThrow to be used.
     * @param modifiers A List of Modifiers.
     * @return The Result.
     */
    public static Result roll(int numberOfDie, SavingThrow savingThrow, List<Modifier> modifiers) {
        Result result = new Result(Dice.roll(numberOfDie), savingThrow, modifiers).process();
        if (isVerbose) {
            StringBuilder sb = new StringBuilder();
            sb.append("Rolls: ");
            for (Integer roll : rolls) {
                sb.append(roll.intValue()).append(" ");
            }
            sb.append("SavingThrow: ").append(savingThrow.getValue()).append(" ").append(savingThrow.getTarget().name()).append(" ");
            sb.append("Modifiers: ");
            for (Modifier modifier : modifiers) {
                sb.append(modifier.getSign().name()).append(" ").append(modifier.getValue()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        return result;
    }

}
