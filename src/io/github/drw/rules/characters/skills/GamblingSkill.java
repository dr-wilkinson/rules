/*
 * GamblingSkill.java
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
package io.github.drw.rules.characters.skills;

/**
 * This {@link Skill} allows a {@link Character} to gamble proficiently.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class GamblingSkill implements Skill {

    private int level = 1;

    @Override
    public String getName() {
        return "Gambling Skill";
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void add(Skill skill) {
        if (skill instanceof GamblingSkill) {
            level += skill.getLevel();
        }
    }

    @Override
    public void decrement() {
        level--;
    }

    @Override
    public String getDescription() {
        return Descriptions.get(this.getClass());
    }

}
