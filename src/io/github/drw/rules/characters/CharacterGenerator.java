/*
 * CharacterGenerator.java
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
package io.github.drw.rules.characters;

import io.github.drw.rules.characters.characteristics.Dexterity;
import io.github.drw.rules.characters.characteristics.Education;
import io.github.drw.rules.characters.characteristics.Endurance;
import io.github.drw.rules.characters.characteristics.Intelligence;
import io.github.drw.rules.characters.characteristics.Social;
import io.github.drw.rules.characters.characteristics.Strength;
import io.github.drw.rules.characters.genders.Gender;
import io.github.drw.rules.characters.names.NameGenerator;
import io.github.drw.rules.characters.titles.TitleGenerator;
import io.github.drw.rules.dice.Dice;

/**
 * Generates {@link Character}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class CharacterGenerator {

    public static void roll(Character character) {
        rollGender(character);
        rollStrength(character);
        rollDexterity(character);
        rollEndurance(character);
        rollIntelligence(character);
        rollEducation(character);
        rollSocial(character);
        rollName(character);
        rollTitle(character);
    }

    private static void rollGender(Character character) {
        if (character.getGender() == null) {
            int result = Dice.roll(1);
            if (result <= 3) {
                character.setGender(new Gender("Male"));
            } else {
                character.setGender(new Gender("Female"));
            }
        }
    }

    private static void rollStrength(Character character) {
        if (character.getStrength() == null) {
            int result = Dice.roll(2);
            character.setStrength(new Strength(result));
        }
    }

    private static void rollDexterity(Character character) {
        if (character.getDexterity() == null) {
            int result = Dice.roll(2);
            character.setDexterity(new Dexterity(result));
        }
    }

    private static void rollEndurance(Character character) {
        if (character.getEndurance() == null) {
            int result = Dice.roll(2);
            character.setEndurance(new Endurance(result));
        }
    }

    private static void rollIntelligence(Character character) {
        if (character.getIntelligence() == null) {
            int result = Dice.roll(2);
            character.setIntelligence(new Intelligence(result));
        }
    }

    private static void rollEducation(Character character) {
        if (character.getEducation() == null) {
            int result = Dice.roll(2);
            character.setEducation(new Education(result));
        }
    }

    private static void rollSocial(Character character) {
        if (character.getSocial() == null) {
            int result = Dice.roll(2);
            character.setSocial(new Social(result));
        }
    }

    private static void rollName(Character character) {
        new NameGenerator().generate(character);
    }

    private static void rollTitle(Character character) {
        new TitleGenerator().generate(character);
    }

}
