/*
 * Commission.java
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
import io.github.drw.rules.characters.ranks.Rank;
import io.github.drw.rules.characters.resume.ResumeWriter;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.dice.Modifier;
import io.github.drw.rules.dice.Result;
import io.github.drw.rules.dice.SavingThrow;
import io.github.drw.rules.services.Army;
import io.github.drw.rules.services.Marines;
import io.github.drw.rules.services.Merchants;
import io.github.drw.rules.services.Navy;
import io.github.drw.rules.services.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Allows a {@link Character} to attempt to gain a Commission within the
 * {@link Service} they are serving within.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Commission {

    /**
     * Ascertains whether the {@link Character} is entitled to attempt to gain a
     * Commission within their {@link Service} and if they are entitled,
     * administers the rules to determine whether their attempt is successful or
     * not.
     *
     * @param character
     */
    public static void attempt(Character character) {
        int term = character.getTerms().getTotal();
        Service.Entry entry = character.getService().getEntry();
        if (term == 0 && entry.equals(Service.Entry.Drafted)) {
            return;
        }
        Rank rank = character.getRank();
        if (!rank.isCommissioned()) {
            Service service = character.getService();
            SavingThrow savingThrow = null;
            List<Modifier> modifiers = new ArrayList<>();
            if (service instanceof Navy) {
                savingThrow = new SavingThrow(10, SavingThrow.Target.OVER);
                int social = character.getSocial().getValue();
                if (social >= 9) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (service instanceof Marines) {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                int education = character.getEducation().getValue();
                if (education >= 7) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (service instanceof Army) {
                savingThrow = new SavingThrow(5, SavingThrow.Target.OVER);
                int endurance = character.getEndurance().getValue();
                if (endurance >= 7) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (service instanceof Merchants) {
                savingThrow = new SavingThrow(4, SavingThrow.Target.OVER);
                int intelligence = character.getIntelligence().getValue();
                if (intelligence >= 6) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (savingThrow != null) {
                Result result = Dice.roll(2, savingThrow, modifiers);
                if (result.isSuccessful()) {
                    rank.setCommissioned(true);
                    rank.setLevel(1);
                    rank.setValue(service.getRankTitle(rank.getLevel()));
                    ResumeWriter.writeCommissionEntry(character);
                    Promotion.rankBenefits(character);
                }
            }
        }
    }

}
