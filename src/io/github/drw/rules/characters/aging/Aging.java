/*
 * Aging.java
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
package io.github.drw.rules.characters.aging;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.characteristics.Characteristic;
import io.github.drw.rules.characters.characteristics.Dexterity;
import io.github.drw.rules.characters.characteristics.Endurance;
import io.github.drw.rules.characters.characteristics.Intelligence;
import io.github.drw.rules.characters.characteristics.Strength;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.dice.Modifier;
import io.github.drw.rules.dice.Result;
import io.github.drw.rules.dice.SavingThrow;
import java.util.ArrayList;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Aging {

    /**
     * Ages the supplied {@link Character} by the supplied number of years and
     * applies the effect of aging on the Characters {@link Characteristic}s..
     *
     * @param character The Character to age.
     * @param years The number of years.
     */
    public static void age(Character character, int years) {
        int age = character.getAge().getValue();
        character.getAge().setValue(age + years);
        assess(character.getAge().getValue(), character.getStrength());
        assess(character.getAge().getValue(), character.getDexterity());
        assess(character.getAge().getValue(), character.getEndurance());
        assess(character.getAge().getValue(), character.getIntelligence());
    }

    private static void assess(int age, Characteristic characteristic) {
        SavingThrow savingThrow = null;
        Characteristic reduction = null;
        if (characteristic instanceof Strength) {
            if (age >= 34 && age < 50) {
                savingThrow = new SavingThrow(8, SavingThrow.Target.OVER);
                reduction = new Strength(-1);
            } else if (age >= 50 && age < 66) {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                reduction = new Strength(-1);
            } else {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                reduction = new Strength(-2);
            }
        }
        if (characteristic instanceof Dexterity) {
            if (age >= 34 && age < 50) {
                savingThrow = new SavingThrow(7, SavingThrow.Target.OVER);
                reduction = new Dexterity(-1);
            } else if (age >= 50 && age < 66) {
                savingThrow = new SavingThrow(8, SavingThrow.Target.OVER);
                reduction = new Dexterity(-1);
            } else {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                reduction = new Dexterity(-2);
            }
        }
        if (characteristic instanceof Endurance) {
            if (age >= 34 && age < 50) {
                savingThrow = new SavingThrow(8, SavingThrow.Target.OVER);
                reduction = new Endurance(-1);
            } else if (age >= 50 && age < 66) {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                reduction = new Endurance(-1);
            } else {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                reduction = new Endurance(-2);
            }
        }
        if (characteristic instanceof Intelligence) {
            if (age >= 66) {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                reduction = new Intelligence(-1);
            }
        }
        if (savingThrow != null) {
            Result result = Dice.roll(2, savingThrow, new ArrayList<Modifier>());
            if (!result.isSuccessful()) {
                characteristic.add(reduction);
            }
        }
    }

}
