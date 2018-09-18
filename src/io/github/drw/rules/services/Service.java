/*
 * Service.java
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
package io.github.drw.rules.services;

import io.github.drw.rules.characters.Character;

/**
 * One of the various military and commercial careers that a {@link Character}
 * can apply into.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public interface Service {

    /**
     * Allows a {@link Character} to attempt to apply in this Service.
     *
     * @param character The Character trying to apply.
     * @return {@code true} if enlisted, otherwise {@code false}.
     */
    public boolean apply(Character character);

    /**
     * Returns the name of this Service.
     *
     * @return The name.
     */
    public String name();

    /**
     * Returns the method of entry (enlistment or draft) into this Service.
     *
     * @return The method of entry.
     */
    public Service.Entry getEntry();

    /**
     * Sets the method of entry into this Service.
     *
     * @param entry The method of entry.
     */
    public void setEntry(Service.Entry entry);

    /**
     * Returns the title of the {@link Rank} gained from this Service.
     *
     * @param level The level to use as the key.
     * @return The title of the Rank assigned to the level key.
     */
    public String getRankTitle(int level);

    /**
     * The method of entry into the {@link Service}.
     */
    enum Entry {
        Enlisted,
        Drafted;
    }

}
