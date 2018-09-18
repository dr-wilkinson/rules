/*
 * Guns.java
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
 * A collection of {@link Gun} weapons.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Guns {

    private final List<Gun> list = new ArrayList<>();

    public void add(Gun gun) {
        list.add(gun);
    }

    public Gun get(Gun gun) {
        return list.get(list.indexOf(gun));
    }

    public int getTotal() {
        return list.size();
    }

    List<Gun> getGuns() {
        return Collections.unmodifiableList(list);
    }

}
