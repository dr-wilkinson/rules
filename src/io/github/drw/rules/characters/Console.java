/*
 * Console.java
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

import io.github.drw.rules.characters.resume.ResumeViewer;
import io.github.drw.rules.characters.skills.SkillsViewer;
import io.github.drw.rules.characters.weapons.WeaponsViewer;
import io.github.drw.rules.services.Career;
import io.github.drw.rules.services.Recruitment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Console {

    private static List<Character> alive = new ArrayList<>();
    private static List<Character> dead = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        while (alive.size() < 100) {
            Character character = new Character();
            CharacterGenerator.roll(character);
            Recruitment.recruit(character);
            Career.pursue(character);
            if (character.isAlive()) {
                alive.add(character);
            } else {
                dead.add(character);
            }
        }

        System.out.println("Dead: " + dead.size());

        for (Character character : alive) {
            System.out.println(CharacterViewer.view(character));
            System.out.println(SkillsViewer.view(character.getSkills()));
            System.out.println(WeaponsViewer.view(character.getWeapons()));
            System.out.println(ResumeViewer.view(character.getResume()));
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }

    }

}
