package io.github.drw.rules.timing;

import java.math.BigInteger;

/**
 * Defines the length or duration of time between two {@link Instant}s. Also
 * provides the facility to add two {@link Instant}s together and subtract one
 * {@link Instant} from another.
 *
 * @author dr-wilkinson
 */
public class Period {

    private int years;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;

    private static int year = 365 * 24 * 60 * 60;
    private static int day = 24 * 60 * 60;
    private static int hour = 60 * 60;
    private static int minute = 60;
    private static int second = 1;

    private Period(int years, int days, int hours, int minutes, int seconds) {
        this.years = years;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    static Instant getInstant() {
        return new Instant(year, day, hour, minute, second);
    }

    /**
     * Returns the value of this Period as a {@link BigInteger}.
     *
     * @return The value.
     */
    BigInteger value() {
        BigInteger y = BigInteger.valueOf(years).multiply(BigInteger.valueOf(year));
        BigInteger d = BigInteger.valueOf(days).multiply(BigInteger.valueOf(day));
        BigInteger h = BigInteger.valueOf(hours).multiply(BigInteger.valueOf(hour));
        BigInteger m = BigInteger.valueOf(minutes).multiply(BigInteger.valueOf(minute));
        BigInteger s = BigInteger.valueOf(seconds).multiply(BigInteger.valueOf(second));
        return y.add(d).add(h).add(m).add(s);
    }

    /**
     * Adds both {@link Instant}s together and returns a Period.
     *
     * @param instantA The Instant to be added to.
     * @param instantB The Instant to add.
     * @return The sum the two Instants as a Period.
     */
    public static Period add(Instant instantA, Instant instantB) {
        BigInteger valueA = instantA.value();
        BigInteger valueB = instantB.value();
        BigInteger seconds = valueA.add(valueB);
        return normalise(seconds);
    }

    /**
     * Subtracts {@link Instant} #B from {@link Instant} #A if the value of
     * {@link Instant} #B is less than the value of {@link Instant} #A,
     * otherwise an {@link IllegalArgumentException } is thrown.
     *
     * @param instantA The Instant that has a value greater than instantB.
     * @param instantB The Instant that has a value less than or equal to
     * instantA.
     * @return The difference between the two Instants as a Period.
     */
    public static Period subtract(Instant instantA, Instant instantB) {
        if (instantB.value().compareTo(instantA.value()) == 1) {
            throw new IllegalArgumentException("Error: Instant #B must be less than or equal to Instant #A!");
        }
        BigInteger seconds = instantA.value().subtract(instantB.value());
        return normalise(seconds);
    }

    private static Period normalise(BigInteger seconds) {
        BigInteger years = seconds.divide(BigInteger.valueOf(year));
        seconds = seconds.mod(BigInteger.valueOf(year));

        BigInteger days = seconds.divide(BigInteger.valueOf(day));
        seconds = seconds.mod(BigInteger.valueOf(day));

        BigInteger hours = seconds.divide(BigInteger.valueOf(hour));
        seconds = seconds.mod(BigInteger.valueOf(hour));

        BigInteger minutes = seconds.divide(BigInteger.valueOf(minute));
        seconds = seconds.mod(BigInteger.valueOf(minute));

        if (seconds.equals(BigInteger.valueOf(60))) {
            minutes = minutes.add(BigInteger.ONE);
            seconds = BigInteger.ZERO;
        }

        if (minutes.equals(BigInteger.valueOf(60))) {
            hours = hours.add(BigInteger.ONE);
            minutes = BigInteger.ZERO;
        }

        if (hours.equals(BigInteger.valueOf(24))) {
            days = days.add(BigInteger.ONE);
            hours = BigInteger.ZERO;
        }

        if (days.equals(BigInteger.valueOf(366))) {
            years = years.add(BigInteger.ONE);
            days = BigInteger.ONE;
        }

        return new Period(
                years.intValueExact(),
                days.intValueExact(),
                hours.intValueExact(),
                minutes.intValueExact(),
                seconds.intValueExact()
        );
    }

    /**
     * Returns a textual view of this Period.
     *
     * @return A textual view.
     */
    public String asText() {
        StringBuilder sb = new StringBuilder();
        sb.append(years);
        if (years == 1) {
            sb.append(" year ");
        } else {
            sb.append(" years ");
        }
        sb.append(days);
        if (days == 1) {
            sb.append(" day ");
        } else {
            sb.append(" days ");
        }
        sb.append(hours);
        if (hours == 1) {
            sb.append(" hour ");
        } else {
            sb.append(" hours ");
        }
        sb.append(minutes);
        if (minutes == 1) {
            sb.append(" minute ");
        } else {
            sb.append(" minutes ");
        }
        sb.append(seconds);
        if (seconds == 1) {
            sb.append(" second");
        } else {
            sb.append(" seconds");
        }
        return sb.toString();
    }

    /**
     * Returns the years.
     *
     * @return The years.
     */
    public int getYears() {
        return years;
    }

    /**
     * Return the days.
     *
     * @return The days.
     */
    public int getDays() {
        return days;
    }

    /**
     * Return the hours.
     *
     * @return The hours.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Return the minutes.
     *
     * @return The minutes.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Return the seconds.
     *
     * @return The seconds.
     */
    public int getSeconds() {
        return seconds;
    }

}
