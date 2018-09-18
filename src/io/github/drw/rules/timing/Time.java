package io.github.drw.rules.timing;

import java.math.BigInteger;

/**
 * Defines a time in hours, minutes and seconds with values bound to zero to 23,
 * zero to 59 and zero to 59 respectively.
 *
 * @author dr-wilkinson
 */
class Time {

    private int hour;
    private int minute;
    private int second;

    /**
     * Constructs a new Time using the supplied hour, minutes and second.
     *
     * @param hour The hour.
     * @param minute The minute.
     * @param second The second.
     */
    Time(int hour, int minute, int second) {
        this.hour = validate(hour, 24);
        this.minute = validate(minute, 60);
        this.second = validate(second, 60);
    }

    private int validate(int value, int bound) {
        if (value < 0) {
            throw new IllegalArgumentException("Error: A time value cannot be less than zero!");
        } else {
            if (value >= bound) {
                throw new IllegalArgumentException("Error: Time value outside upper bound!");
            }
        }
        return value;
    }

    /**
     * Returns the value of this Time as a {@link BigInteger}.
     *
     * @return The value of this Time.
     */
    BigInteger value() {
        BigInteger h = BigInteger.valueOf(hour).multiply(BigInteger.valueOf(60)).multiply(BigInteger.valueOf(60));
        BigInteger m = BigInteger.valueOf(minute).multiply(BigInteger.valueOf(60));
        BigInteger s = BigInteger.valueOf(second);
        return h.add(m).add(s);
    }

    /**
     * Returns a textual view of this Time.
     *
     * @return A textual view of this Time.
     */
    String asText() {
        StringBuilder sb = new StringBuilder();
        sb.append(format(hour)).append(":");
        sb.append(format(minute)).append(":");
        sb.append(format(second));
        return sb.toString();
    }

    private String format(int number) {
        String value = String.valueOf(number);
        if (value.length() == 1) {
            value = "0" + value;
        }
        return value;
    }

    /**
     * The hour.
     *
     * @return The hour.
     */
    int getHour() {
        return hour;
    }

    /**
     * The minute.
     *
     * @return The minute.
     */
    int getMinute() {
        return minute;
    }

    /**
     * The second.
     *
     * @return The second.
     */
    int getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.hour;
        hash = 79 * hash + this.minute;
        hash = 79 * hash + this.second;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Time other = (Time) obj;
        if (this.hour != other.hour) {
            return false;
        }
        if (this.minute != other.minute) {
            return false;
        }
        if (this.second != other.second) {
            return false;
        }
        return true;
    }

    @Override
    protected Time clone() {
        return new Time(hour, minute, second);
    }

}
