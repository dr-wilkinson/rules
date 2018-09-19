/*
 * Copyright (C) 2018 dr wilkinson <dr-wilkinson@users.noreply.github.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.drw.rules.adventures;

import io.github.drw.rules.timing.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * An Adventure is a collection of {@link Encounter}s. One or more Adventures
 * are collected into a {@link Campaign}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Adventure implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private Instant instant;

    public Adventure() {
    }

    public Adventure(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.title);
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
        final Adventure other = (Adventure) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

}
