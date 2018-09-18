/*
 * Recruitment.java
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
import io.github.drw.rules.characters.skills.BladeSpecialism;
import io.github.drw.rules.characters.skills.GunSpecialism;
import io.github.drw.rules.characters.skills.PilotSkill;
import io.github.drw.rules.characters.skills.Skill;
import io.github.drw.rules.characters.weapons.Cutlass;
import io.github.drw.rules.characters.weapons.Rifle;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.dice.Modifier;
import io.github.drw.rules.dice.Result;
import io.github.drw.rules.dice.SavingThrow;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Enables {@link Character}s to enlist or be drafted into one of six
 * {@link Service}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Recruitment {

    /**
     * Returns a randomly selected {@link Service}.
     *
     * @return The Service.
     */
    public static Service random() {
        Service service = null;
        int result = Dice.roll(1);
        switch (result) {
            case 1:
                service = new Navy();
                break;
            case 2:
                service = new Marines();
                break;
            case 3:
                service = new Army();
                break;
            case 4:
                service = new Scouts();
                break;
            case 5:
                service = new Merchants();
                break;
            case 6:
                service = new Other();
                break;
        }
        return service;
    }

    public static void recruit(Character character) {
        Service service = random();
        if (!Enlistment.attempt(character, service)) {
            Draft.character(character);
        }
        character.setServing(true);
        ResumeWriter.writeRecruitmentEntry(character);
        serviceBenefits(character);
    }

    public static void reenlist(Character character) {
        if (character.isAlive()) {
            SavingThrow savingThrow = null;
            List<Modifier> modifiers = new ArrayList<>();
            Service service = character.getService();
            if (service instanceof Navy) {
                savingThrow = new SavingThrow(6, SavingThrow.Target.OVER);
            }
            if (service instanceof Marines) {
                savingThrow = new SavingThrow(6, SavingThrow.Target.OVER);
            }
            if (service instanceof Army) {
                savingThrow = new SavingThrow(7, SavingThrow.Target.OVER);
            }
            if (service instanceof Scouts) {
                savingThrow = new SavingThrow(3, SavingThrow.Target.OVER);
            }
            if (service instanceof Merchants) {
                savingThrow = new SavingThrow(4, SavingThrow.Target.OVER);
            }
            if (service instanceof Other) {
                savingThrow = new SavingThrow(5, SavingThrow.Target.OVER);
            }
            Result result = Dice.roll(2, savingThrow, modifiers);
            if (result.getTotal() == 12) {
                ResumeWriter.writeReenlistmentEntry(character);
                return;
            }
            if (result.isSuccessful()) {
                ResumeWriter.writeReenlistmentEntry(character);
            } else {
                character.setServing(false);
                ResumeWriter.writeMusteringOutEntry(character);
            }
        }
    }

    /**
     * Recruits the {@link Character} into a specific {@link Service} using a
     * selected {@link Service.Entry} method.
     *
     * @param character The Character to recruit.
     * @param service The preferred Service.
     * @param entry The preferred method of entry.
     */
    public static void recruit(Character character, Service service, Service.Entry entry) {
        service.setEntry(entry);
        character.setService(service);
        character.setServing(true);
        ResumeWriter.writeRecruitmentEntry(character);
        serviceBenefits(character);
    }

    /**
     * Recruits the {@link Character} into a specific {@link Service}.
     *
     * @param character The Character to recruit.
     * @param service The preferred Service.
     */
    public static void recruit(Character character, Service service) {
        character.setService(service);
        if (new Random().nextBoolean()) {
            service.setEntry(Service.Entry.Enlisted);
        } else {
            service.setEntry(Service.Entry.Drafted);
        }
        character.setServing(true);
        ResumeWriter.writeRecruitmentEntry(character);
        serviceBenefits(character);
    }

    private static void serviceBenefits(Character character) {
        Service service = character.getService();
        Skill skill = null;
        if (service instanceof Marines) {
            skill = new BladeSpecialism(new Cutlass());
            character.getSkills().addSkill(skill);
        }
        if (service instanceof Army) {
            skill = new GunSpecialism(new Rifle());
            character.getSkills().addSkill(skill);
        }
        if (service instanceof Scouts) {
            skill = new PilotSkill();
            character.getSkills().addSkill(skill);
        }
        if (skill != null) {
            ResumeWriter.writeServiceBenefitEntry(character, skill);
        }
    }

}
