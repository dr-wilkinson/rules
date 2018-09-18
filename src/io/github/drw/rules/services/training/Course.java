/*
 * Course.java
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
package io.github.drw.rules.services.training;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.skills.Skill;

/**
 * A period of time spent studying an area of expertise under instruction that
 * results in the acquisition of a {@link Skill}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public interface Course {

    /**
     * Returns the title of the Course.
     *
     * @return The title.
     */
    public String getTitle();

    /**
     * Allows a {@link Character} to take this Course.
     *
     * @param character The Character that is taking this Course.
     */
    public void take(Character character);

}
