/*
 * Age.java
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
package io.github.drw.rules.characters.aging;

import java.io.Serializable;

/**
 * The number of years a {@link Character} has been alive.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Age implements Serializable {

    private static final long serialVersionUID = 1L;

    private int value;

    /**
     * Honours the {@link Serializable} interface.
     */
    public Age() {
    }

    /**
     * Constructs a new Age with the supplied value.
     *
     * @param value The value.
     */
    public Age(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.value;
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
        final Age other = (Age) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Age{" + "value=" + value + '}';
    }

}
