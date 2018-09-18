/*
 * ResumeWriter.java
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
package io.github.drw.rules.characters.resume;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.characteristics.Characteristic;
import io.github.drw.rules.characters.names.NameViewer;
import io.github.drw.rules.characters.skills.Skill;
import io.github.drw.rules.services.Service;
import io.github.drw.rules.services.Service.Entry;
import io.github.drw.rules.services.training.Course;

/**
 * Writes entries into a {@link Character}s {@link Resume}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class ResumeWriter {

    /**
     * Writes the method by which the {@link Character} was recruited into the
     * {@link Service}.
     *
     * @param character The recruited Character.
     */
    public static void writeRecruitmentEntry(Character character) {
        Service service = character.getService();
        Entry entry = service.getEntry();
        StringBuilder sb = new StringBuilder();
        if (entry.equals(Service.Entry.Enlisted)) {
            sb.append("Enlisted in the ");
        }
        if (entry.equals(Service.Entry.Drafted)) {
            sb.append("Drafted into the ");
        }
        sb.append(service.name()).append(" service.");
        character.getResume().addEntry(sb.toString());
    }

    public static void writeTrainingEntry(Character character, Course course) {
        String entry = "Completed the " + character.getService().name() + " " + course.getTitle() + ".";
        character.getResume().addEntry(entry);
    }

    public static void writeSurvivalEntry(Character character) {
        String name = NameViewer.initials(false, true, false).display(character.getName());
        String rank = character.getRank().getValue();
        StringBuilder sb = new StringBuilder();
        if (rank != null) {
            sb.append(rank).append(" ");
        }
        sb.append(name).append(" died at ").append(character.getAge().getValue()).append(" years of age.");
        String entry = sb.toString();
        character.getResume().addEntry(entry);
    }

    public static void writeCommissionEntry(Character character) {
        String entry = "Commissioned with the rank of " + character.getRank().getValue() + ".";
        character.getResume().addEntry(entry);
    }

    public static void writePromotionEntry(Character character) {
        String entry = "Promoted to " + character.getRank().getValue();
        character.getResume().addEntry(entry);
    }

    public static void writeReenlistmentEntry(Character character) {
        String entry = "Reenlisted.";
        character.getResume().addEntry(entry);
    }

    public static void writeMusteringOutEntry(Character character) {
        String lastName = character.getName().getLast();
        String rank = character.getRank().getValue();
        StringBuilder sb = new StringBuilder();
        if (rank != null) {
            sb.append(rank).append(" ");
        }
        sb.append(lastName).append(" mustered out.");
        String entry = sb.toString();
        character.getResume().addEntry(entry);
    }

    public static void writeTermEntry(Character character) {
        int term = character.getTerms().getTotal();
        String entry = "Completed Term " + term;
        character.getResume().addEntry(entry);
    }

    public static void writeRetirementEntry(Character character) {
        StringBuilder sb = new StringBuilder();
        sb.append("Retired");
        if (character.getPension() != null) {
            sb.append(" with a pension of Cr").append(character.getPension().getAmount()).append(" per annum.");
        } else {
            sb.append(".");
        }
        String entry = sb.toString();
        character.getResume().addEntry(entry);
    }

    public static void writeServiceBenefitEntry(Character character, Skill skill) {
        StringBuilder sb = new StringBuilder();
        sb.append("Received ").append(skill.getName()).append(" skill as a service benefit.");
        String entry = sb.toString();
        character.getResume().addEntry(entry);
    }

    public static void writePromotionBenefitEntry(Character character, Skill skill, Characteristic characteristic) {
        StringBuilder sb = new StringBuilder();
        sb.append("Received ");
        if (skill != null) {
            sb.append(skill.getName()).append(" skill as a promotion benefit.");
        }
        if (characteristic != null) {
            sb.append(" improved Social as a promotion benefit.");
        }
        String entry = sb.toString();
        character.getResume().addEntry(entry);
    }

}
