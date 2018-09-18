/*
 * AdminCourse.java
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
import io.github.drw.rules.characters.skills.AdminSkill;
import io.github.drw.rules.characters.skills.Skill;

/**
 * This course enable a serving {@link Character} to gain the
 * {@link AdminSkill}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class AdminCourse implements Course {

    @Override
    public String getTitle() {
        return "Administration Course";
    }

    @Override
    public void take(Character character) {
        Skill skill = new AdminSkill();
        character.getSkills().addSkill(skill);
    }

}
