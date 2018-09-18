/*
 * Passage.java
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
import io.github.drw.rules.characters.money.Credits;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public interface Passage {

    /**
     * Returns the class of {@link Accommodation} this Passage entitles the
     * holder to receive during the voyage.
     *
     * @return The Accommodation.
     */
    Accommodation getAccommodation();

    /**
     * Returns the standard of {@link Cuisine} this Passage entitles the holder
     * to receive during the voyage.
     *
     * @return The Cuisine standard.
     */
    Cuisine getCuisine();

    /**
     * Returns the total weight of baggage (in kilograms) this Passage entitles
     * the holder to bring on board.
     *
     * @return The baggage allowance in kilograms.
     */
    int baggageAllowance();

    /**
     * The purchase price of this Passage in {@link Credits}.
     *
     * @return The purchase price.
     */
    int getCost();

    public enum Type {
        Low,
        Middle,
        High;
    }

}
