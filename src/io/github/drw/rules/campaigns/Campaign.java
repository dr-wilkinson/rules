/*
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
package io.github.drw.rules.campaigns;

import io.github.drw.rules.adventures.Adventure;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A Campaign organises a group of {@link Adventure}s into a coherent narrative
 * form.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Campaign implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private List<Adventure> adventures = new ArrayList<>();

    public Campaign(String title) {
        this.title = title;
    }

    /**
     * Returns the title of this Campaign.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this Campaign to the supplied title.
     *
     * @param title The new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.title);
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
        final Campaign other = (Campaign) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    /**
     * Adds the supplied {@link Adventure} to this Campaign.
     *
     * @param adventure The Adventure to add.
     */
    public void addAdventure(Adventure adventure) {
        if (!adventures.contains(adventure)) {
            adventures.add(adventure);
        }
    }

    /**
     * Returns an unmodifiable {@link List} of the {@link Adventure}s in this
     * Campaign.
     *
     * @return The Adventures in this Campaign.
     */
    public List<Adventure> getAdventures() {
        return Collections.unmodifiableList(adventures);
    }

}
