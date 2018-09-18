/*
 * Rank.java
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
package io.github.drw.rules.characters.ranks;

import java.io.Serializable;
import java.util.Objects;

/**
 * A prefix available to {@link Character}s who have been commissioned and/or
 * promoted.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Rank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String value;
    private boolean commissioned;
    private int level;

    /**
     * Honours the {@link Serializable} interface.
     */
    public Rank() {
        commissioned = false;
    }

    /**
     * Constructs a new Rank using the supplied value.
     *
     * @param value The value.
     */
    public Rank(String value) {
        this.value = value;
        commissioned = false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCommissioned() {
        return commissioned;
    }

    public void setCommissioned(boolean commissioned) {
        this.commissioned = commissioned;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.value);
        hash = 67 * hash + (this.commissioned ? 1 : 0);
        hash = 67 * hash + this.level;
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
        final Rank other = (Rank) obj;
        if (this.commissioned != other.commissioned) {
            return false;
        }
        if (this.level != other.level) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rank{" + "value=" + value + ", commissioned=" + commissioned + ", level=" + level + '}';
    }

}
