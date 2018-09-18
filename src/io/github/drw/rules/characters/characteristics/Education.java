/*
 * Education.java
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

import java.io.Serializable;

/**
 * Indicates the {@link Character}s highest level of attained schooling.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Education implements Characteristic, Serializable {

    private static final long serialVersionUID = 1L;

    private int value;

    /**
     * No argument constructor to honour the {@link Serializable} interface.
     */
    public Education() {
    }

    /**
     * Constructs a new Education {@link Characteristic} using the supplied
     * value.
     *
     * @param value The value.
     */
    public Education(int value) {
        this.value = new ValueBound(1, 15).validate(value);
    }

    /**
     * Returns the value of this Education {@link Characteristic}.
     *
     * @return The value.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this Education {@link Characteristic} to the supplied
     * value.
     *
     * @param value The new value.
     */
    @Override
    public void setValue(int value) {
        this.value = new ValueBound(1, 15).validate(value);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.value;
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
        final Education other = (Education) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Education{" + "value=" + value + '}';
    }

    @Override
    public void add(Characteristic characteristic) {
        if (characteristic instanceof Education) {
            setValue(getValue() + characteristic.getValue());
        }
    }

}
