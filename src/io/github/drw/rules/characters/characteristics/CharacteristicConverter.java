/*
 * CharacteristicConverter.java
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
 * Converts the value of a {@link Characteristic} into a String.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class CharacteristicConverter {

    public String convert(Characteristic characteristic) {
        String value = null;
        if (characteristic.getValue() <= 9) {
            value = Integer.toString(characteristic.getValue());
        }
        switch (characteristic.getValue()) {
            case 10:
                value = "A";
                break;
            case 11:
                value = "B";
                break;
            case 12:
                value = "C";
                break;
            case 13:
                value = "D";
                break;
            case 14:
                value = "E";
                break;
            case 15:
                value = "F";
                break;
        }
        return value;
    }

}
