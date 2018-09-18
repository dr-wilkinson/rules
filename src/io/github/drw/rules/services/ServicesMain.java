/*
 * ServicesMain.java
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
import io.github.drw.rules.characters.CharacterGenerator;
import io.github.drw.rules.characters.CharacterViewer;
import io.github.drw.rules.characters.resume.ResumeViewer;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class ServicesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Character character = new Character();
            CharacterGenerator.roll(character);
            System.out.println(CharacterViewer.view(character));
            Recruitment.recruit(character);
            System.out.println(ResumeViewer.view(character.getResume()));
        }
    }

}
