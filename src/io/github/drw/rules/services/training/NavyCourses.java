/*
 * NavyCourses.java
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
package io.github.drw.rules.services.training;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.characters.resume.ResumeWriter;
import io.github.drw.rules.dice.Dice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class NavyCourses implements Courses {

    private static final List<Course> personalTable = new ArrayList<>();
    private static final List<Course> serviceTable = new ArrayList<>();
    private static final List<Course> educationTable = new ArrayList<>();
    private static final List<Course> advancedTable = new ArrayList<>();

    static {
        personalTable.add(new PhysicalCourse());
        personalTable.add(new PhysicalCourse());
        personalTable.add(new PhysicalCourse());
        personalTable.add(new MentalCourse());
        personalTable.add(new MentalCourse());
        personalTable.add(new MentalCourse());
        serviceTable.add(new ShipsBoatCourse());
        serviceTable.add(new VacuumSuitCourse());
        serviceTable.add(new ForwardObserverCourse());
        serviceTable.add(new BladeCombatCourse());
        serviceTable.add(new GunCombatCourse());
        serviceTable.add(new GunneryCourse());
        educationTable.add(new VacuumSuitCourse());
        educationTable.add(new MechanicalCourse());
        educationTable.add(new ElectronicsCourse());
        educationTable.add(new EngineeringCourse());
        educationTable.add(new GunneryCourse());
        educationTable.add(new JOATCourse());
        advancedTable.add(new MedicalCourse());
        advancedTable.add(new NavigationCourse());
        advancedTable.add(new EngineeringCourse());
        advancedTable.add(new ComputerCourse());
        advancedTable.add(new PilotCourse());
        advancedTable.add(new AdminCourse());
    }

    public void train(Character character) {
        List<Course> table = null;
        int result = Dice.roll(3);
        if (result <= 6) {
            table = personalTable;
        } else if (result <= 10) {
            table = serviceTable;
        } else if (result <= 14) {
            table = educationTable;
        } else {
            if (character.getEducation().getValue() >= 8) {
                table = advancedTable;
            } else {
                table = educationTable;
            }
        }
        result = Dice.roll(1);
        Course course = table.get(result - 1);
        course.take(character);
        ResumeWriter.writeTrainingEntry(character, course);
    }

}
