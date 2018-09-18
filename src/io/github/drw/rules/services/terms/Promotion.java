/*
 * Promotion.java
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
import io.github.drw.rules.characters.characteristics.Characteristic;
import io.github.drw.rules.characters.characteristics.Social;
import io.github.drw.rules.characters.ranks.Rank;
import io.github.drw.rules.characters.resume.ResumeWriter;
import io.github.drw.rules.characters.skills.GunSpecialism;
import io.github.drw.rules.characters.skills.PilotSkill;
import io.github.drw.rules.characters.skills.Skill;
import io.github.drw.rules.characters.weapons.Revolver;
import io.github.drw.rules.characters.weapons.SMG;
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
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
class Promotion {

    static void attempt(Character character) {
        if (character.getRank().isCommissioned() && character.getRank().getLevel() < 6) {
            Rank rank = character.getRank();
            int level = rank.getLevel();
            Service service = character.getService();
            SavingThrow savingThrow = null;
            List<Modifier> modifiers = new ArrayList<>();
            if (service instanceof Navy) {
                savingThrow = new SavingThrow(8, SavingThrow.Target.OVER);
                int education = character.getEducation().getValue();
                if (education >= 8) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (service instanceof Marines) {
                savingThrow = new SavingThrow(9, SavingThrow.Target.OVER);
                int social = character.getSocial().getValue();
                if (social >= 8) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (service instanceof Army) {
                savingThrow = new SavingThrow(6, SavingThrow.Target.OVER);
                int education = character.getEducation().getValue();
                if (education >= 7) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (service instanceof Merchants) {
                savingThrow = new SavingThrow(10, SavingThrow.Target.OVER);
                int intelligence = character.getIntelligence().getValue();
                if (intelligence >= 9) {
                    Modifier modifier = new Modifier(1, Modifier.Sign.POSITIVE);
                    modifiers.add(modifier);
                }
            }
            if (savingThrow != null) {
                Result result = Dice.roll(2, savingThrow, modifiers);
                if (result.isSuccessful()) {
                    rank.setLevel(level + 1);
                    rank.setValue(service.getRankTitle(rank.getLevel()));
                    ResumeWriter.writePromotionEntry(character);
                    rankBenefits(character);
                }
            }
        }
    }

    static void rankBenefits(Character character) {
        Service service = character.getService();
        Rank rank = character.getRank();
        int level = rank.getLevel();
        Characteristic characteristic = null;
        Skill skill = null;
        if (service instanceof Navy) {
            if (level == 5 || level == 6) {
                characteristic = new Social(1);
                character.getSocial().add(characteristic);
            }
        }
        if (service instanceof Marines) {
            if (level == 1) {
                skill = new GunSpecialism(new Revolver());
                character.getSkills().addSkill(skill);
            }
        }
        if (service instanceof Army) {
            if (level == 1) {
                skill = new GunSpecialism(new SMG());
                character.getSkills().addSkill(skill);
            }
        }
        if (service instanceof Merchants) {
            if (level == 4) {
                skill = new PilotSkill();
                character.getSkills().addSkill(skill);
            }
        }
        if (skill != null || characteristic != null) {
            ResumeWriter.writePromotionBenefitEntry(character, skill, characteristic);
        }
    }

}
