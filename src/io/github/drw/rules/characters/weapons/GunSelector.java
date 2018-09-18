/*
 * GunSelector.java
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
package io.github.drw.rules.characters.weapons;

import io.github.drw.rules.characters.skills.BladeSpecialism;
import io.github.drw.rules.characters.skills.GunCombatSkill;
import io.github.drw.rules.characters.skills.GunSpecialism;
import io.github.drw.rules.characters.skills.Skill;
import io.github.drw.rules.characters.skills.Skills;
import io.github.drw.rules.dice.Dice;
import java.util.HashMap;
import java.util.Map;

/**
 * A GunSelector is used to assign a {@link GunCombatSkill} to a specific
 * {@link Gun} {@link Weapon}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class GunSelector {

    private static final Map<Integer, Weapon> map = new HashMap<>();

    static {
        map.put(2, new BodyPistol());
        map.put(3, new AutomaticPistol());
        map.put(4, new Revolver());
        map.put(5, new Carbine());
        map.put(6, new Rifle());
        map.put(7, new LaserCarbine());
        map.put(8, new LaserRifle());
        map.put(9, new AutomaticRifle());
        map.put(10, new SMG());
        map.put(11, new Shotgun());
    }

    public static void select(Skills skills, GunCombatSkill gunCombatSkill) {
        Weapon weapon = null;
        while (weapon == null) {
            weapon = map.get(Dice.roll(2));
        }
        GunSpecialism specialism = new GunSpecialism(weapon);
        boolean added = false;
        for (Skill skill : skills.getList()) {
            if (skill instanceof BladeSpecialism) {
                if (skill.getName().equals(specialism.getName())) {
                    skill.add(gunCombatSkill);
                    added = true;
                    break;
                }
            }
        }
        if (!added) {
            skills.addSkill(specialism);
        }
    }

}
