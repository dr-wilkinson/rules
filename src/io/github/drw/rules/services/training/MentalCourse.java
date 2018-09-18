/*
 * MentalCourse.java
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

import io.github.drw.rules.characters.characteristics.Education;
import io.github.drw.rules.characters.characteristics.Intelligence;
import io.github.drw.rules.characters.characteristics.Social;
import io.github.drw.rules.dice.Dice;

/**
 * This {@link Course} focuses upon developing a {@link Character}s mental
 * capabilities.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class MentalCourse implements Course {

    @Override
    public String getTitle() {
        return "Mental Course";
    }

    @Override
    public void take(io.github.drw.rules.characters.Character character) {
        int result = Dice.roll(1);
        if (result <= 2) {
            character.getIntelligence().add(new Intelligence(1));
        } else if (result <= 4) {
            character.getEducation().add(new Education(1));
        } else {
            character.getSocial().add(new Social(1));
        }
    }

}
