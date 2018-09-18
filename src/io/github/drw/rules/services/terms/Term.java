/*
 * Term.java
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
import io.github.drw.rules.characters.aging.Aging;
import io.github.drw.rules.characters.resume.ResumeWriter;
import io.github.drw.rules.services.training.Training;

/**
 * A four year tour of duty within a {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Term {

    private final int years = 4;

    public int getYears() {
        return years;
    }

    /**
     * Serving a Term passes the {@link Character} through
     * {@link Survival}, {@link Commission}, {@link Promotion}, {@link Training}
     * and {@link Aging}.
     *
     * @param character The Character serving this Term.
     */
    public void serve(Character character) {
        Survival.determine(character);
        if (character.isAlive()) {
            Commission.attempt(character);
            Promotion.attempt(character);
            Training.train(character);
            Aging.age(character, years);
            character.getTerms().addTerm(this);
            ResumeWriter.writeTermEntry(character);
        }
    }

}
