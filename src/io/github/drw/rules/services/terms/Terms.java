/*
 * Terms.java
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
package io.github.drw.rules.services.terms;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of {@link Term}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Terms {

    private List<Term> list = new ArrayList<>();

    public void addTerm(Term term) {
        list.add(term);
    }

    public int getTotal() {
        return list.size();
    }

    public int getYears() {
        int total = 0;
        for (Term term : list) {
            total += term.getYears();
        }
        return total;
    }

}
