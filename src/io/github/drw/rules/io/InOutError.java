/*
 * InOutError.java
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
package io.github.drw.rules.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates an error during IO operations. Stores a collection of messages
 * that explain the cause(s) of the InOutError.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class InOutError {

    private List<String> messages = new ArrayList<>();

    /**
     * Adds a message.
     *
     * @param message The message.
     */
    public void addMessage(String message) {
        messages.add(message);
    }

    /**
     * Returns a String containing the message(s).
     *
     * @return The message(s).
     */
    public String getMessages() {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
