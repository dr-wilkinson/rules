/*
 * TitleGenerator.java
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
package io.github.drw.rules.characters.titles;

import io.github.drw.rules.characters.Character;
import java.util.HashMap;
import java.util.Map;

/**
 * Generates a {@link Title} based on the supplied {@link Character}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class TitleGenerator {

    private final static Map<Integer, Title> male = new HashMap<>();
    private final static Map<Integer, Title> female = new HashMap<>();

    static {
        male.put(2, new Title("None"));
        male.put(3, new Title("None"));
        male.put(4, new Title("None"));
        male.put(5, new Title("None"));
        male.put(6, new Title("None"));
        male.put(7, new Title("None"));
        male.put(8, new Title("None"));
        male.put(9, new Title("None"));
        male.put(10, new Title("None"));
        male.put(11, new Title("Sir"));
        male.put(12, new Title("Baron"));
        male.put(13, new Title("Marquis"));
        male.put(14, new Title("Count"));
        male.put(15, new Title("Duke"));
        female.put(2, new Title("None"));
        female.put(3, new Title("None"));
        female.put(4, new Title("None"));
        female.put(5, new Title("None"));
        female.put(6, new Title("None"));
        female.put(7, new Title("None"));
        female.put(8, new Title("None"));
        female.put(9, new Title("None"));
        female.put(10, new Title("None"));
        female.put(11, new Title("Dame"));
        female.put(12, new Title("Baroness"));
        female.put(13, new Title("Marchioness"));
        female.put(14, new Title("Countess"));
        female.put(15, new Title("Duchess"));
    }

    public Character generate(Character character) {
        if (character.getGender().getValue().equals("Male")) {
            int social = character.getSocial().getValue();
            character.setTitle(male.get(social));
        }
        if (character.getGender().getValue().equals("Female")) {
            int social = character.getSocial().getValue();
            character.setTitle(female.get(social));
        }
        return character;
    }

}
