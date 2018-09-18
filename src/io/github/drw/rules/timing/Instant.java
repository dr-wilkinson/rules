package io.github.drw.rules.timing;

import java.math.BigInteger;
import java.util.Objects;

/**
 * An Instant is a specific point in time defined by combining a {@link Time}
 * object and a {@link Date} object.
 *
 * @author dr-wilkinson
 */
public class Instant {

    private Date date;
    private Time time;

    /**
     * Constructs a new Instant. Arguments are validated internally and may
     * throw an {@link IllegalArgumentException} if invalid.
     *
     * @param year The year - must be equal to or greater than 0.
     * @param day The day - must be between 1 and 365 inclusive.
     * @param hour The hour - must be between 1 and 23 inclusive.
     * @param minute The minute - must be between 1 and 59 inclusive.
     * @param second The second - must be between 1 and 59 inclusive.
     */
    public Instant(int year, int day, int hour, int minute, int second) {
        try {
            this.date = new Date(year, day);
            this.time = new Time(hour, minute, second);
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }

    /**
     * Returns a new Instant based upon the supplied Instant. This is required
     * when the supplied Instants internal {@link Date} has a name value of null
     * because the day value is zero. Using this constructor forces the name
     * value to be set to the correct day name.
     *
     * @param instant A new Instant with a Date containing a correct named day.
     */
    public Instant(Instant instant) {
        if (instant.getDate().getName() == null) {
            this.date = instant.getDate().clone();
        } else {
            this.date = instant.getDate();
        }
        this.time = instant.getTime();
    }

    /**
     * Returns this Instant in textual form.
     *
     * @return For example 12:30:15 Holiday 001 45762
     */
    public String asText() {
        StringBuilder sb = new StringBuilder();
        sb.append(time.asText()).append(" ");
        sb.append(date.asText());
        return sb.toString();
    }

    /**
     * Returns the value of this Instant as a {@link BigInteger}.
     *
     * @return The value.
     */
    BigInteger value() {
        return date.value().add(time.value());
    }

    @Override
    public Instant clone() {
        return new Instant(date.getYear(), date.getDay(), time.getHour(), time.getMinute(), time.getSecond());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.date);
        hash = 29 * hash + Objects.hashCode(this.time);
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
        final Instant other = (Instant) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    /**
     * Returns the {@link Date} of this Instant.
     *
     * @return The Date.
     */
    public Date getDate() {
        return date.clone();
    }

    /**
     * Returns the {@link Time} of this Instant.
     *
     * @return The Time.
     */
    public Time getTime() {
        return time.clone();
    }

    /**
     * Returns the year of this Instant.
     *
     * @return The year.
     */
    public int getYear() {
        return date.getYear();
    }

    /**
     * Returns the name of this Instant.
     *
     * @return The name.
     */
    public String getName() {
        return date.getName();
    }

    /**
     * Returns the day of this Instant.
     *
     * @return The day.
     */
    public int getDay() {
        return date.getDay();
    }

    /**
     * Returns the hour of this Instant.
     *
     * @return The hour.
     */
    public int getHour() {
        return time.getHour();
    }

    /**
     * Returns the minute of this Instant.
     *
     * @return The minute.
     */
    public int getMinute() {
        return time.getMinute();
    }

    /**
     * Returns the second of this Instant.
     *
     * @return The second.
     */
    public int getSecond() {
        return time.getSecond();
    }

    /**
     * Returns a new Instant composed from the textual representation of an
     * Instant.
     *
     * @param string The textual representation.
     * @return A new Instant object.
     */
    public static Instant fromString(String string) {
        // name day year hour minute second
        // 7    3   5    2    2      2     5
        String[] elements = string.split(" ");
        int day = Integer.getInteger(elements[1]);
        int year = Integer.getInteger(elements[2]);
        int hour = Integer.getInteger(elements[3]);
        int minute = Integer.getInteger(elements[4]);
        int second = Integer.getInteger(elements[5]);
        return new Instant(year, day, hour, minute, second);
    }

}
