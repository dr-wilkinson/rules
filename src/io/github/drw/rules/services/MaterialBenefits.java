/*
 * MaterialBenefits.java
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
import io.github.drw.rules.characters.characteristics.Education;
import io.github.drw.rules.characters.characteristics.Intelligence;
import io.github.drw.rules.characters.characteristics.Social;
import io.github.drw.rules.characters.skills.BladeSpecialism;
import io.github.drw.rules.characters.skills.GunSpecialism;
import io.github.drw.rules.characters.skills.Skill;
import io.github.drw.rules.characters.skills.Skills;
import io.github.drw.rules.characters.weapons.Weapon;
import io.github.drw.rules.characters.weapons.Weapons;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.documentation.Ownership;
import io.github.drw.rules.passages.HighPassage;
import io.github.drw.rules.passages.LowPassage;
import io.github.drw.rules.passages.MiddlePassage;
import io.github.drw.rules.starships.FreeTrader;
import io.github.drw.rules.starships.Scout;
import io.github.drw.rules.tas.TAS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Encapsulates the material benefits available to {@link Character}s when they
 * leave a {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class MaterialBenefits {

    private static final Map<String, Table> tables = new HashMap<>();

    private static List<Benefit> benefits = new ArrayList<>();

    static {
        tables.put(new Navy().name(), new Table());
        tables.put(new Marines().name(), new Table());
        tables.put(new Army().name(), new Table());
        tables.put(new Scouts().name(), new Table());
        tables.put(new Merchants().name(), new Table());
        tables.put(new Other().name(), new Table());

        Table navy = tables.get(new Navy().name());
        navy.addBenefit(Benefit.LOW_PASSAGE);
        navy.addBenefit(Benefit.INTELLIGENCE_PLUS_1);
        navy.addBenefit(Benefit.EDUCATION_PLUS_2);
        navy.addBenefit(Benefit.BLADE);
        navy.addBenefit(Benefit.TAS);
        navy.addBenefit(Benefit.HIGH_PASSAGE);
        navy.addBenefit(Benefit.SOCIAL_PLUS_2);

        Table marines = tables.get(new Marines().name());
        marines.addBenefit(Benefit.LOW_PASSAGE);
        marines.addBenefit(Benefit.INTELLIGENCE_PLUS_2);
        marines.addBenefit(Benefit.EDUCATION_PLUS_1);
        marines.addBenefit(Benefit.BLADE);
        marines.addBenefit(Benefit.TAS);
        marines.addBenefit(Benefit.HIGH_PASSAGE);
        marines.addBenefit(Benefit.SOCIAL_PLUS_2);

        Table army = tables.get(new Army().name());
        army.addBenefit(Benefit.LOW_PASSAGE);
        army.addBenefit(Benefit.INTELLIGENCE_PLUS_1);
        army.addBenefit(Benefit.EDUCATION_PLUS_2);
        army.addBenefit(Benefit.GUN);
        army.addBenefit(Benefit.HIGH_PASSAGE);
        army.addBenefit(Benefit.MIDDLE_PASSAGE);
        army.addBenefit(Benefit.SOCIAL_PLUS_1);

        Table scouts = tables.get(new Scouts().name());
        scouts.addBenefit(Benefit.LOW_PASSAGE);
        scouts.addBenefit(Benefit.INTELLIGENCE_PLUS_2);
        scouts.addBenefit(Benefit.EDUCATION_PLUS_2);
        scouts.addBenefit(Benefit.BLADE);
        scouts.addBenefit(Benefit.GUN);
        scouts.addBenefit(Benefit.SCOUT);
        scouts.addBenefit(Benefit.NOTHING);

        Table merchants = tables.get(new Merchants().name());
        merchants.addBenefit(Benefit.LOW_PASSAGE);
        merchants.addBenefit(Benefit.INTELLIGENCE_PLUS_1);
        merchants.addBenefit(Benefit.EDUCATION_PLUS_1);
        merchants.addBenefit(Benefit.GUN);
        merchants.addBenefit(Benefit.BLADE);
        merchants.addBenefit(Benefit.LOW_PASSAGE);
        merchants.addBenefit(Benefit.MERCHANT);

        Table other = tables.get(new Other().name());
        other.addBenefit(Benefit.LOW_PASSAGE);
        other.addBenefit(Benefit.INTELLIGENCE_PLUS_1);
        other.addBenefit(Benefit.EDUCATION_PLUS_1);
        other.addBenefit(Benefit.GUN);
        other.addBenefit(Benefit.HIGH_PASSAGE);
        other.addBenefit(Benefit.NOTHING);
        other.addBenefit(Benefit.NOTHING);

    }

    private static void reset() {
        benefits = new ArrayList<>();
    }

    public static void process(Service service, int rolls, boolean addOneOption) {
        reset();
        Table table = tables.get(service.name());
        for (int i = 0; i < rolls; i++) {
            rollBenefit(table, addOneOption);
        }
    }

    private static void rollBenefit(Table table, boolean addOneOption) {
        int result = Dice.roll(1);
        if (addOneOption) {
            if (Dice.roll(1) <= 3) {
                result++;
            }
        }
        Benefit benefit = table.getBenefit(result);
        benefits.add(benefit);
    }

    public static void apply(Character character) {
        ListIterator<Benefit> listIterator = benefits.listIterator();
        while (listIterator.hasNext()) {
            Benefit benefit = listIterator.next();
            if (filterPassages(character, benefit)) {
                listIterator.remove();
            }
            if (filterCharacteristics(character, benefit)) {
                listIterator.remove();
            }
            if (filterWeapons(character, benefit)) {
                listIterator.remove();
            }
            if (filterTas(character, benefit)) {
                listIterator.remove();
            }
            if (filterShip(character, benefit)) {
                listIterator.remove();
            }
        }
    }

    private static boolean filterShip(Character character, Benefit benefit) {
        boolean b = false;
        if (benefit.equals(Benefit.SCOUT)) {
            b = true;
            Scout starship = new Scout();
            Ownership document = new Ownership(character, starship);
            character.getDocuments().add(document);
        } else if (benefit.equals(Benefit.MERCHANT)) {
            b = true;
            FreeTrader starship = new FreeTrader();
            Ownership document = new Ownership(character, starship);
            character.getDocuments().add(document);
        }
        return b;
    }

    private static boolean filterTas(Character character, Benefit benefit) {
        boolean b = false;
        if (benefit.equals(Benefit.TAS)) {
            if (character.getTas() == null) {
                character.setTas(new TAS(character));
                b = true;
            }
        }
        return b;
    }

    private static boolean filterWeapons(Character character, Benefit benefit) {
        boolean b = false;
        Weapons weapons = character.getWeapons();
        Skills skills = character.getSkills();
        switch (benefit) {
            case BLADE:
                for (Skill skill : skills.getList()) {
                    if (skill instanceof BladeSpecialism) {
                        Weapon weapon = ((BladeSpecialism) skill).getWeapon();
                        if (!weapons.getWeapons().contains(weapon)) {
                            weapons.add(weapon);
                        }
                    }
                }
                b = true;
                break;
            case GUN:
                for (Skill skill : skills.getList()) {
                    if (skill instanceof GunSpecialism) {
                        Weapon weapon = ((GunSpecialism) skill).getWeapon();
                        if (!weapons.getWeapons().contains(weapon)) {
                            weapons.add(weapon);
                        }
                    }
                }
                b = true;
                break;
        }
        return b;
    }

    private static boolean filterCharacteristics(Character character, Benefit benefit) {
        boolean b = false;
        switch (benefit) {
            case INTELLIGENCE_PLUS_1:
                character.getIntelligence().add(new Intelligence(1));
                b = true;
                break;
            case INTELLIGENCE_PLUS_2:
                character.getIntelligence().add(new Intelligence(2));
                b = true;
                break;
            case EDUCATION_PLUS_1:
                character.getEducation().add(new Education(1));
                b = true;
                break;
            case EDUCATION_PLUS_2:
                character.getEducation().add(new Education(2));
                b = true;
                break;
            case SOCIAL_PLUS_1:
                character.getSocial().add(new Social(1));
                b = true;
                break;
            case SOCIAL_PLUS_2:
                character.getSocial().add(new Social(2));
                b = true;
                break;
        }
        return b;
    }

    private static boolean filterPassages(Character character, Benefit benefit) {
        boolean b = false;
        switch (benefit) {
            case HIGH_PASSAGE:
                character.getPassages().add(new HighPassage());
                b = true;
                break;
            case MIDDLE_PASSAGE:
                character.getPassages().add(new MiddlePassage());
                b = true;
                break;
            case LOW_PASSAGE:
                character.getPassages().add(new LowPassage());
                b = true;
                break;
        }
        return b;
    }

    private static class Table {

        private Map<Integer, Benefit> map = new HashMap<>();

        void addBenefit(Benefit benefit) {
            int key = map.size() + 1;
            map.put(key, benefit);
        }

        Benefit getBenefit(int key) {
            return map.get(key);
        }

    }

    private enum Benefit {
        LOW_PASSAGE,
        INTELLIGENCE_PLUS_1,
        EDUCATION_PLUS_2,
        BLADE,
        TAS,
        HIGH_PASSAGE,
        SOCIAL_PLUS_2,
        INTELLIGENCE_PLUS_2,
        EDUCATION_PLUS_1,
        GUN,
        MIDDLE_PASSAGE,
        SOCIAL_PLUS_1,
        SCOUT,
        NOTHING,
        MERCHANT;
    }

}
