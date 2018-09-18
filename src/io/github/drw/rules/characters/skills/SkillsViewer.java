/*
 * SkillsViewer.java
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
package io.github.drw.rules.characters.skills;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class SkillsViewer {

    public static String view(Skills skills) {
        StringBuilder sb = new StringBuilder();
        if (skills.getList().isEmpty()) {
            sb.append("No skills.").append(System.lineSeparator());
            return sb.toString();
        }
        sb.append("Skills:").append(System.lineSeparator());
        for (Skill skill : skills.getList()) {
            sb.append(skill.getName()).append(" ").append(skill.getLevel()).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
