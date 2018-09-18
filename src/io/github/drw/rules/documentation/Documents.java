/*
 * Documents.java
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
package io.github.drw.rules.documentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A collection of {@link Document}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Documents {

    private List<Document> list = new ArrayList<>();

    public void add(Document document) {
        list.add(document);
    }

    public List<Document> get(String simpleName) {
        List<Document> documents = new ArrayList<>();
        for (Document document : list) {
            if (document.getClass().getSimpleName().equals(simpleName)) {
                documents.add(document);
            }
        }
        return Collections.unmodifiableList(documents);
    }

    public String show(List<Document> documents) {
        StringBuilder sb = new StringBuilder();
        for (Document document : documents) {
            sb.append(document.display());
        }
        return sb.toString();
    }

}
