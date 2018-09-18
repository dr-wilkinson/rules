/*
 * NameViewer.java
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

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class NameViewer {

    private static boolean firstInitial;
    private static boolean middleInitial;
    private static boolean lastInitial;

    public static NameViewer initials(boolean fInitial, boolean mInitial, boolean lInitial) {
        firstInitial = fInitial;
        middleInitial = mInitial;
        lastInitial = lInitial;
        return new NameViewer();
    }

    public static String display(Name name) {
        StringBuffer sb = new StringBuffer();
        if (firstInitial) {
            sb.append(initial(name.getFirst()));
        } else {
            sb.append(name.getFirst());
        }
        sb.append(" ");
        if (!name.getMiddle().isEmpty()) {
            if (middleInitial) {
                for (String part : name.getMiddle().split(" ")) {
                    sb.append(initial(part)).append(" ");
                }
            } else {
                sb.append(name.getMiddle()).append(" ");
            }
        }
        if (lastInitial) {
            sb.append(initial(name.getLast()));
        } else {
            sb.append(name.getLast());
        }
        return sb.toString();
    }

    private static String initial(String part) {
        return String.valueOf(part.charAt(0)).toUpperCase();
    }

}
