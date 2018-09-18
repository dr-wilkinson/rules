/*
 * CharacterViewer.java
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
package io.github.drw.rules.characters;

import io.github.drw.rules.characters.characteristics.CharacteristicConverter;
import io.github.drw.rules.characters.names.NameViewer;
import io.github.drw.rules.documentation.Document;
import io.github.drw.rules.tas.TAS;
import java.util.List;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class CharacterViewer {

    public static String view(Character character) {

        StringBuffer sb = new StringBuffer();

        String gender = character.getGender().getValue();
        sb.append("Gender: ").append(gender).append(System.lineSeparator());

        String name = NameViewer.initials(false, false, false).display(character.getName());
        sb.append("Name: ").append(name).append(System.lineSeparator());

        String age = String.valueOf(character.getAge().getValue());
        sb.append("Age: ").append(age).append(System.lineSeparator());

        String strength = new CharacteristicConverter().convert(character.getStrength());
        sb.append("Strength: ").append(strength).append(System.lineSeparator());
        String dexterity = new CharacteristicConverter().convert(character.getDexterity());
        sb.append("Dexterity: ").append(dexterity).append(System.lineSeparator());
        String endurance = new CharacteristicConverter().convert(character.getEndurance());
        sb.append("Endurance: ").append(endurance).append(System.lineSeparator());
        String intelligence = new CharacteristicConverter().convert(character.getIntelligence());
        sb.append("Intelligence: ").append(intelligence).append(System.lineSeparator());
        String education = new CharacteristicConverter().convert(character.getEducation());
        sb.append("Education: ").append(education).append(System.lineSeparator());
        String social = new CharacteristicConverter().convert(character.getSocial());
        sb.append("Social: ").append(social).append(System.lineSeparator());

        String title = character.getTitle().getValue();
        sb.append("Title: ").append(title).append(System.lineSeparator());

        String credits = String.valueOf(character.getCredits().getTotal());
        sb.append("Credits: ").append(credits).append(System.lineSeparator());

        if (character.getTas() != null) {
            TAS tas = character.getTas();
            String membership = tas.getMember() + " " + tas.getId();
            sb.append("TAS: ").append(membership).append(System.lineSeparator());
        }

        if (character.getDocuments() != null) {
            List<Document> ownershipDocuments = character.getDocuments().get("Ownership");
            for (Document document : ownershipDocuments) {
                sb.append(document.display()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

}
