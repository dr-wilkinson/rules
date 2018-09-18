/*
 * Career.java
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
import io.github.drw.rules.services.terms.Term;

/**
 * Encapsulates the process of serving {@link Term}s within a {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Career {

    /**
     * Allows a {@link Character} to pursue a Career within the {@link Service}
     * they have been recruited into.
     *
     * @param character The Character pursuing the Career.
     */
    public static void pursue(Character character) {
        while (character.isAlive() && character.isServing()) {
            new Term().serve(character);
            Retirement.process(character);
            if (character.isServing()) {
                Recruitment.reenlist(character);
            }
        }
        if (character.isAlive()) {
            MusteringOut.process(character);
        }
    }

}
