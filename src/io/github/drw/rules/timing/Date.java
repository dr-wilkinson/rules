package io.github.drw.rules.timing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Defines a date in years and days with values bound from zero plus and 1 to
 * 365 respectively. Also the correct name for the specified day.
 *
 * @author dr-wilkinson
 */
public class Date {

    private int year;
    private int day;
    private String name;

    private List<String> days;
    private Map<Integer, String> calendar = new HashMap<>(365);

    /**
     * Constructs a new Date using the supplied year and day.
     *
     * @param year The year.
     * @param day The day.
     */
    public Date(int year, int day) {
        this.year = validate(year);
        this.day = validate(day, 366);
        initDays();
        initCalendar();
        this.name = name(this.day);
    }

    private int validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Error: Value cannot be less than zero!");
        }
        return value;
    }

    private int validate(int value, int bound) {
        if (value < 0) {
            throw new IllegalArgumentException("Error: Value cannot be less than zero!");
        } else {
            if (value >= bound) {
                throw new IllegalArgumentException("Error: Value outside upper bound!");
            }
        }
        return value;
    }

    /**
     * Returns the value of this Date as a {@link BigInteger}.
     *
     * @return The value of this Date.
     */
    BigInteger value() {
        BigInteger y = BigInteger.valueOf(year).multiply(BigInteger.valueOf(365)).multiply(BigInteger.valueOf(24)).multiply(BigInteger.valueOf(60)).multiply(BigInteger.valueOf(60));
        BigInteger d = BigInteger.valueOf(day).multiply(BigInteger.valueOf(24)).multiply(BigInteger.valueOf(60)).multiply(BigInteger.valueOf(60));
        return y.add(d);
    }

    private String name(int day) {
        return calendar.get(day);
    }

    private void initDays() {
        this.days = new ArrayList<>(7);
        days.add("Wonday");
        days.add("Tuday");
        days.add("Thirday");
        days.add("Forday");
        days.add("Fiday");
        days.add("Sixday");
        days.add("Senday");
    }

    /**
     * Return a read-only view of the days.
     *
     * @return List of days.
     */
    public List<String> days() {
        return Collections.unmodifiableList(days);
    }

    private void initCalendar() {
        calendar.put(1, "Holiday");
        int counter = 2;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 7; j++) {
                calendar.put(counter, days.get(j));
                counter++;
            }
        }
    }

    /**
     * Returns a textual view of this Date.
     *
     * @return A textual view.
     */
    String asText() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ");
        sb.append(format(day)).append(" ");
        sb.append(year);
        return sb.toString();
    }

    private String format(int number) {
        String value = String.valueOf(number);
        if (value.length() == 1) {
            value = "00" + value;
        }
        if (value.length() == 2) {
            value = "0" + value;
        }
        return value;
    }

    /**
     * Returns the year.
     *
     * @return The year.
     */
    int getYear() {
        return year;
    }

    /**
     * Returns the day
     *
     * @return The day.
     */
    int getDay() {
        return day;
    }

    /**
     * Returns the name.
     *
     * @return The name.
     */
    String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.year;
        hash = 67 * hash + this.day;
        hash = 67 * hash + Objects.hashCode(this.name);
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
        final Date other = (Date) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    protected Date clone() {
        return new Date(year, day);
    }

}
