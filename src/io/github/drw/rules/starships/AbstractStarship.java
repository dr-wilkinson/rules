/*
 * AbstractStarship.java
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
package io.github.drw.rules.starships;

import java.util.Random;
import java.util.UUID;

/**
 * Provides functionality common to all {@link Starship}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
abstract class AbstractStarship implements Starship {

    protected String type;
    private String registration;

    AbstractStarship() {
        setRegistration();
    }

    private void setRegistration() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String string = "";
        for (int i = 0; i < 14; i++) {
            string += uuid.charAt(i);
        }
        string += "-";
        Random random = new Random();
        string += String.valueOf(random.nextInt(1000) + 1000);
        registration = string;
    }

    @Override
    public String getRegistration() {
        return registration;
    }

    @Override
    public String getType() {
        return type;
    }

}
