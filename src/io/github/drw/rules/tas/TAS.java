/*
 * TAS.java
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
package io.github.drw.rules.tas;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.names.Name;
import io.github.drw.rules.characters.names.NameViewer;

/**
 * Membership of the Travellers Aid Society.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class TAS {

    private final long id;
    private final Character character;

    public TAS(Character character) {
        this.character = character;
        id = System.currentTimeMillis();
    }

    public String getId() {
        return Long.toString(id);
    }

    public String getMember() {
        Name name = character.getName();
        return NameViewer.initials(false, true, false).display(name);
    }

}
