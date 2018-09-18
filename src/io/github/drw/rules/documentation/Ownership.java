/*
 * Ownership.java
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
package io.github.drw.rules.documentation;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.names.NameViewer;
import io.github.drw.rules.starships.Starship;

/**
 * Connects the a {@link Starship} registration id and a {@link Character} who
 * is the owner of the Starship.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Ownership implements Document {

    private String name;
    private String type;
    private String registration;

    public Ownership(Character character, Starship starship) {
        this.name = NameViewer.display(character.getName());
        this.type = starship.getType();
        this.registration = starship.getRegistration();
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("Starship Document.").append(System.lineSeparator());
        sb.append("Type: ").append(type).append(System.lineSeparator());
        sb.append("ID: ").append(registration).append(System.lineSeparator());
        sb.append("Owner: ").append(name).append(System.lineSeparator());
        return sb.toString();
    }

}
