/*
 * Strength.java
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
 * A general evaluation of the {@link Character}s physical ability and a
 * specific measure of force which may be applied in combat situations.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Strength implements Characteristic, Serializable {

    private static final long serialVersionUID = 1L;

    private int value;

    /**
     * No argument constructor to honour the {@link Serializable} interface.
     */
    public Strength() {
    }

    /**
     * Constructs a new Strength {@link Characteristic} using the supplied
     * value.
     *
     * @param value The value.
     */
    public Strength(int value) {
        this.value = new ValueBound(1, 15).validate(value);
    }

    /**
     * Returns the value of this Strength {@link Characteristic}.
     *
     * @return The value.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this Strength {@link Characteristic} to the supplied
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
        int hash = 5;
        hash = 59 * hash + this.value;
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
        final Strength other = (Strength) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Strength{" + "value=" + value + '}';
    }

    @Override
    public void add(Characteristic characteristic) {
        if (characteristic instanceof Strength) {
            setValue(getValue() + characteristic.getValue());
        }
    }

}
