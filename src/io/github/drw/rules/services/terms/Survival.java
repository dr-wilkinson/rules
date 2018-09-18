/*
 * Survival.java
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
package io.github.drw.rules.services.terms;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.resume.ResumeWriter;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.dice.Modifier;
import io.github.drw.rules.dice.Result;
import io.github.drw.rules.dice.SavingThrow;
import io.github.drw.rules.services.Army;
import io.github.drw.rules.services.Marines;
import io.github.drw.rules.services.Merchants;
import io.github.drw.rules.services.Navy;
import io.github.drw.rules.services.Other;
import io.github.drw.rules.services.Scouts;
import io.github.drw.rules.services.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Determines whether the {@link Character} serving a {@link Term} survives or
 * not.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Survival {

    public static void determine(Character character) {
        Service service = character.getService();
        List<Modifier> modifiers = new ArrayList<>();
        if (service instanceof Navy) {
            int intelligence = character.getIntelligence().getValue();
            if (intelligence >= 7) {
                Modifier modifier = new Modifier(2, Modifier.Sign.POSITIVE);
                modifiers.add(modifier);
            }
            SavingThrow savingThrow = new SavingThrow(5, SavingThrow.Target.OVER);
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (!result.isSuccessful()) {
                character.setAlive(false);
                ResumeWriter.writeSurvivalEntry(character);
            }
            return;
        }
        if (service instanceof Marines) {
            int endurance = character.getEndurance().getValue();
            if (endurance >= 8) {
                Modifier modifier = new Modifier(2, Modifier.Sign.POSITIVE);
                modifiers.add(modifier);
            }
            SavingThrow savingThrow = new SavingThrow(6, SavingThrow.Target.OVER);
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (!result.isSuccessful()) {
                character.setAlive(false);
                ResumeWriter.writeSurvivalEntry(character);
            }
            return;
        }
        if (service instanceof Army) {
            int education = character.getEducation().getValue();
            if (education >= 6) {
                Modifier modifier = new Modifier(2, Modifier.Sign.POSITIVE);
                modifiers.add(modifier);
            }
            SavingThrow savingThrow = new SavingThrow(5, SavingThrow.Target.OVER);
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (!result.isSuccessful()) {
                character.setAlive(false);
                ResumeWriter.writeSurvivalEntry(character);
            }
            return;
        }
        if (service instanceof Scouts) {
            int endurance = character.getEndurance().getValue();
            if (endurance >= 9) {
                Modifier modifier = new Modifier(2, Modifier.Sign.POSITIVE);
                modifiers.add(modifier);
            }
            SavingThrow savingThrow = new SavingThrow(7, SavingThrow.Target.OVER);
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (!result.isSuccessful()) {
                character.setAlive(false);
                ResumeWriter.writeSurvivalEntry(character);
            }
            return;
        }
        if (service instanceof Merchants) {
            int intelligence = character.getIntelligence().getValue();
            if (intelligence >= 7) {
                Modifier modifier = new Modifier(2, Modifier.Sign.POSITIVE);
                modifiers.add(modifier);
            }
            SavingThrow savingThrow = new SavingThrow(5, SavingThrow.Target.OVER);
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (!result.isSuccessful()) {
                character.setAlive(false);
                ResumeWriter.writeSurvivalEntry(character);
            }
            return;
        }
        if (service instanceof Other) {
            int intelligence = character.getIntelligence().getValue();
            if (intelligence >= 9) {
                Modifier modifier = new Modifier(2, Modifier.Sign.POSITIVE);
                modifiers.add(modifier);
            }
            SavingThrow savingThrow = new SavingThrow(5, SavingThrow.Target.OVER);
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (!result.isSuccessful()) {
                character.setAlive(false);
                ResumeWriter.writeSurvivalEntry(character);
            }
            return;
        }
    }

}
