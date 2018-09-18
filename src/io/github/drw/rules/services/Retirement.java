/*
 * Retirement.java
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
import io.github.drw.rules.characters.resume.ResumeWriter;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.timing.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Retirement {

    private final static Map<Integer, Integer> pensions = new HashMap<>(4);

    static {
        pensions.put(5, 4000);
        pensions.put(6, 6000);
        pensions.put(7, 8000);
        pensions.put(8, 10000);
    }

    public static void process(Character character) {
        boolean retired = false;
        int terms = character.getTerms().getTotal();
        if (terms == 7) {
            retired = true;
        } else if (terms > 5) {
            int result = Dice.roll(1);
            if (result < 2) {
                retired = true;
            }
        }
        if (retired) {
            character.setServing(false);
            assignPension(character);
            ResumeWriter.writeRetirementEntry(character);
        }
    }

    private static void assignPension(Character character) {
        int terms = character.getTerms().getTotal();
        int amount = pensions.get(terms);
        if (terms > 8) {
            for (int i = 0; i < terms - 8; i++) {
                amount += 2000;
            }
        }
        Pension pension = new Pension(new Date(1, 1), amount);
        character.setPension(pension);
    }

}
