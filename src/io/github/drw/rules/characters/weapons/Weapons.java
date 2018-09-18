/*
 * Weapons.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Weapons {

    private List<Blade> blades = new ArrayList<>();
    private List<Polearm> polearms = new ArrayList<>();
    private List<Gun> guns = new ArrayList<>();

    public void add(Weapon weapon) {
        if (weapon instanceof Blade) {
            blades.add((Blade) weapon);
        }
        if (weapon instanceof Polearm) {
            polearms.add((Polearm) weapon);
        }
        if (weapon instanceof Gun) {
            guns.add((Gun) weapon);
        }
    }

    public Weapon get(Weapon weapon) {
        Weapon instance = null;
        if (weapon instanceof Blade) {
            instance = blades.get(blades.indexOf(weapon));
        }
        if (weapon instanceof Polearm) {
            instance = polearms.get(polearms.indexOf(weapon));
        }
        if (weapon instanceof Gun) {
            instance = guns.get(guns.indexOf(weapon));
        }
        return instance;
    }

    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.addAll(blades);
        weapons.addAll(polearms);
        weapons.addAll(guns);
        return Collections.unmodifiableList(weapons);
    }

    public List<Blade> getBlades() {
        return Collections.unmodifiableList(blades);
    }

    public List<Polearm> getPolearms() {
        return Collections.unmodifiableList(polearms);
    }

    public List<Gun> getGuns() {
        return Collections.unmodifiableList(guns);
    }

}
