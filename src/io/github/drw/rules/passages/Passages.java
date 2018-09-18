/*
 * Passages.java
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
package io.github.drw.rules.passages;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Passages {

    private List<Passage> list = new ArrayList<>();

    public void add(Passage passage) {
        list.add(passage);
    }

    public Passage get(Passage.Type type) {
        Passage passage = null;
        switch (type) {
            case Low:
                for (Passage p : list) {
                    if (p instanceof LowPassage) {
                        passage = p;
                        break;
                    }
                }
                break;
            case Middle:
                for (Passage p : list) {
                    if (p instanceof MiddlePassage) {
                        passage = p;
                        break;
                    }
                }
                break;
            case High:
                for (Passage p : list) {
                    if (p instanceof HighPassage) {
                        passage = p;
                        break;
                    }
                }
                break;
        }
        return passage;
    }

}
