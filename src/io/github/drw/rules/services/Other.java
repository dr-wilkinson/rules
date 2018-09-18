/*
 * Other.java
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
import java.util.List;

/**
 * Any other {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Other implements Service {

    private Entry entry;

    @Override
    public boolean apply(Character character) {
        SavingThrow savingThrow = new SavingThrow(3, SavingThrow.Target.OVER);
        List<Modifier> modifiers = new ArrayList<>();
        Result result = Dice.roll(2, savingThrow, modifiers).process();
        return result.isSuccessful();
    }

    @Override
    public String name() {
        return "Other";
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
    public String getRankTitle(int level) {
        return null;
    }

}
