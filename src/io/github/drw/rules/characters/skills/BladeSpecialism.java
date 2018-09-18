/*
 * BladeSpecialism.java
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

import io.github.drw.rules.characters.weapons.Blade;
import io.github.drw.rules.characters.weapons.Polearm;
import io.github.drw.rules.characters.weapons.Weapon;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class BladeSpecialism implements Skill {

    private Weapon weapon;
    private int level = 1;

    public BladeSpecialism(Weapon weapon) {
        if (weapon instanceof Blade || weapon instanceof Polearm) {
            this.weapon = weapon;
        } else {
            throw new IllegalArgumentException("Weapon must be an instance of Blade or Polearm!");
        }
    }

    @Override
    public String getName() {
        return weapon.getName() + " Combat";
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void add(Skill skill) {
        if (skill instanceof BladeCombatSkill) {
            level += skill.getLevel();
        }
    }

    @Override
    public void decrement() {
        level--;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(Descriptions.get(this.getClass())).append(weapon.getName()).append(" weapon.");
        return sb.toString();
    }

}
