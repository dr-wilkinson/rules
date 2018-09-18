/*
 * HighPassage.java
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
package io.github.drw.rules.passages;

import io.github.drw.rules.characters.expenses.Accommodation;
import io.github.drw.rules.characters.expenses.Cuisine;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class HighPassage implements Passage {

    private Accommodation accommodation = null;
    private Cuisine cuisine = null;

    @Override
    public Accommodation getAccommodation() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public Cuisine getCuisine() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public int baggageAllowance() {
        return 10000;
    }

    @Override
    public int getCost() {
        return 10000;
    }

}
