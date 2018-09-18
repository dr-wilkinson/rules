/*
 * ValueBound.java
 *
 * Copyright (c) 2018 dr wilkinson <dr-wilkinson@users.noreply.github.com>.
 *
 * This file is part of Traveller.
 *
 * Traveller is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Traveller is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Traveller.  If not, see <http ://www.gnu.org/licenses/>.
 */
package io.github.drw.rules.characters.characteristics;

/**
 * Ensures that any {@link Characteristic} value is kept within the allowed
 * range (inclusive).
 * <p>
 * This class is used within {@link Characteristic} objects to ensure the
 * constructor and setter methods maintain the value within the permitted range
 * of 1 to 15 inclusive.</p>
 * <p>
 * This class is also used when initially rolling new {@link Characteristic}s
 * with a range of 2 to 12 inclusive, to ensure initial Characteristics are
 * within the permitted range.</p>
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class ValueBound {

    private final int lower;
    private final int upper;

    public ValueBound(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int validate(int value) {
        if (value >= lower && value <= upper) {
            return value;
        } else {
            if (value < lower) {
                value = lower;
            }
            if (value > upper) {
                value = upper;
            }
        }
        return value;
    }

}
