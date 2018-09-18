/*
 * Training.java
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
import io.github.drw.rules.services.Army;
import io.github.drw.rules.services.Marines;
import io.github.drw.rules.services.Merchants;
import io.github.drw.rules.services.Navy;
import io.github.drw.rules.services.Other;
import io.github.drw.rules.services.Scouts;
import io.github.drw.rules.services.Service;

/**
 * Provides {@link Service} specific {@link Course}s for serving
 * {@link Character}s to complete and gain {@link Skill}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Training {

    public static void train(Character character) {
        Service service = character.getService();
        Courses courses = null;
        if (service instanceof Navy) {
            courses = new NavyCourses();
        } else if (service instanceof Marines) {
            courses = new MarineCourses();
        } else if (service instanceof Army) {
            courses = new ArmyCourses();
        } else if (service instanceof Scouts) {
            courses = new ScoutCourses();
        } else if (service instanceof Merchants) {
            courses = new MerchantCourses();
        } else if (service instanceof Other) {
            courses = new OtherCourses();
        }
        courses.train(character);
    }

}
