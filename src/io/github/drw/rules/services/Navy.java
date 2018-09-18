/*
 * Navy.java
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
package io.github.drw.rules.services;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.dice.Modifier;
import io.github.drw.rules.dice.Result;
import io.github.drw.rules.dice.SavingThrow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The naval {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Navy implements Service {

    private Entry entry;

    private final static Map<Integer, String> ranks = new HashMap<>(6);

    static {
        ranks.put(1, "Ensign");
        ranks.put(2, "Lieutenant");
        ranks.put(3, "Lt Commander");
        ranks.put(4, "Commander");
        ranks.put(5, "Captain");
        ranks.put(6, "Admiral");
    }

    @Override
    public boolean apply(Character character) {
        SavingThrow savingThrow = new SavingThrow(8, SavingThrow.Target.OVER);
        List<Modifier> modifiers = new ArrayList<>();
        int intelligence = character.getIntelligence().getValue();
        int education = character.getEducation().getValue();
        if (intelligence >= 8) {
            modifiers.add(new Modifier(1, Modifier.Sign.POSITIVE));
        }
        if (education >= 9) {
            modifiers.add(new Modifier(2, Modifier.Sign.POSITIVE));
        }
        Result result = Dice.roll(2, savingThrow, modifiers);
        return result.isSuccessful();
    }

    @Override
    public String name() {
        return "Navy";
    }

    @Override
    public Entry getEntry() {
        return entry;
    }

    @Override
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @Override
    public String getRankTitle(int key) {
        return ranks.get(key);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.entry);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Navy other = (Navy) obj;
        if (this.entry != other.entry) {
            return false;
        }
        return true;
    }

}
