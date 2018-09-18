/*
 * Skill.java
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
 * A degree of expertise within a specific knowledge base or field of activity
 * acquired through completion of a training {@link Course} or through personal
 * experience.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public interface Skill {

    public String getName();

    public int getLevel();

    public void add(Skill skill);

    public void decrement();

    public String getDescription();

}
