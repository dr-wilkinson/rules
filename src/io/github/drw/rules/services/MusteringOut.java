/*
 * MusteringOut.java
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
import io.github.drw.rules.characters.skills.GamblingSkill;
import io.github.drw.rules.characters.skills.Skill;
import io.github.drw.rules.characters.skills.Skills;
import io.github.drw.rules.dice.Dice;

/**
 * Encapsulates the process of leaving a {@link Service} after retirement or not
 * re-enlisting.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class MusteringOut {

    private static int materialRolls = 0;
    private static int cashRolls = 0;
    private static boolean addOneMaterial = false;
    private static boolean addOneCash = false;

    private static void reset() {
        materialRolls = 0;
        cashRolls = 0;
        addOneMaterial = false;
        addOneCash = false;
    }

    public static void process(Character character) {
        reset();
        Service service = character.getService();
        int terms = character.getTerms().getTotal();
        int rank = character.getRank().getLevel();
        boolean gambling = hasGambling(character);
        setBenefitRolls(terms, rank, gambling);
        for (int i = 0; i < materialRolls; i++) {
            MaterialBenefits.process(service, materialRolls, addOneMaterial);
        }
        MaterialBenefits.apply(character);
        for (int i = 0; i < cashRolls; i++) {
            CashBenefits.process(service, cashRolls, addOneCash);
        }
        CashBenefits.apply(character);
    }

    private static void setBenefitRolls(int terms, int rank, boolean gambling) {
        int total = terms;
        if (rank <= 2) {
            total += 1;
        } else if (rank <= 4) {
            total += 2;
        } else if (rank <= 6) {
            total += 2;
            addOneMaterial = true;
        }
        if (gambling) {
            addOneCash = true;
        }
        for (int i = 0; i < total; i++) {
            int result = Dice.roll(1);
            if (result <= 3) {
                if (materialRolls != 3) {
                    materialRolls++;
                }
            } else {
                cashRolls++;
            }
        }
    }

    private static boolean hasGambling(Character character) {
        boolean b = false;
        Skills skills = character.getSkills();
        for (Skill skill : skills.getList()) {
            if (skill.getName().equals(new GamblingSkill().getName())) {
                b = true;
                break;
            }
        }
        return b;
    }

}
