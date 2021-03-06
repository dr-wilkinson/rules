/*
 * Merchants.java
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

/**
 * The merchants {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Merchants implements Service {

    private Entry entry;

    private final static Map<Integer, String> ranks = new HashMap<>(6);

    static {
        ranks.put(1, "5th Officer");
        ranks.put(2, "4th Officer");
        ranks.put(3, "3rd Officer");
        ranks.put(4, "2nd Officer");
        ranks.put(5, "1st Officer");
        ranks.put(6, "Captain");
    }

    @Override
    public boolean apply(Character character) {
        SavingThrow savingThrow = new SavingThrow(7, SavingThrow.Target.OVER);
        List<Modifier> modifiers = new ArrayList<>();
        int strength = character.getStrength().getValue();
        int intelligence = character.getIntelligence().getValue();
        if (strength >= 7) {
            modifiers.add(new Modifier(1, Modifier.Sign.POSITIVE));
        }
        if (intelligence >= 6) {
            modifiers.add(new Modifier(2, Modifier.Sign.POSITIVE));
        }
        Result result = Dice.roll(2, savingThrow, modifiers).process();
        return result.isSuccessful();
    }

    @Override
    public String name() {
        return "Merchants";
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

}
