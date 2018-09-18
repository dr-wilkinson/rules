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

import java.util.Objects;

/**
 * A Campaign organises a group of {@link Adventure}s into a coherent narrative
 * form.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Campaign {

    private final int id;
    private String title;

    /**
     * Constructs a new Campaign object.
     *
     * @param id The final, immutable id of the Campaign.
     * @param title The mutable title of the Campaign.
     */
    Campaign(int id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Returns the unique immutable id of this Campaign.
     *
     * @return The id.
     */
    public int getId() {
        return id;
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
    void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.title);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Campaign{" + "id=" + id + ", title=" + title + '}';
    }

}
