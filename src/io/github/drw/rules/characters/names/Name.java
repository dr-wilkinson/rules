/*
 * Name.java
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
package io.github.drw.rules.characters.names;

import java.io.Serializable;
import java.util.Objects;

/**
 * The name of a character. Must have at least a first and last name. Middle
 * names are optional.
 *
 * @author dr-wilkinson
 */
public class Name implements Serializable {

    private static final long serialVersionUID = 1L;

    private String first;
    private String middle;
    private String last;

    /**
     * Honours the {@link Serializable} contract.
     */
    public Name() {
    }

    /**
     * Returns a new CharacterName.
     *
     * @param first The first part.
     * @param middle The middle parts.
     * @param last The last part.
     */
    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.first);
        hash = 97 * hash + Objects.hashCode(this.middle);
        hash = 97 * hash + Objects.hashCode(this.last);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Name other = (Name) obj;
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.middle, other.middle)) {
            return false;
        }
        if (!Objects.equals(this.last, other.last)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name{" + "first=" + first + ", middle=" + middle + ", last=" + last + '}';
    }

}
