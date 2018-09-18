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
package io.github.drw.rules.characters;

import io.github.drw.rules.characters.aging.Age;
import io.github.drw.rules.characters.characteristics.Dexterity;
import io.github.drw.rules.characters.characteristics.Education;
import io.github.drw.rules.characters.characteristics.Endurance;
import io.github.drw.rules.characters.characteristics.Intelligence;
import io.github.drw.rules.characters.characteristics.Social;
import io.github.drw.rules.characters.characteristics.Strength;
import io.github.drw.rules.characters.genders.Gender;
import io.github.drw.rules.characters.money.Credits;
import io.github.drw.rules.characters.names.Name;
import io.github.drw.rules.characters.ranks.Rank;
import io.github.drw.rules.characters.resume.Resume;
import io.github.drw.rules.characters.skills.Skills;
import io.github.drw.rules.characters.titles.Title;
import io.github.drw.rules.characters.weapons.Weapons;
import io.github.drw.rules.documentation.Documents;
import io.github.drw.rules.passages.Passages;
import io.github.drw.rules.services.Pension;
import io.github.drw.rules.services.Service;
import io.github.drw.rules.services.terms.Terms;
import io.github.drw.rules.tas.TAS;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;

    private Gender gender;
    private Strength strength;
    private Dexterity dexterity;
    private Endurance endurance;
    private Intelligence intelligence;
    private Education education;
    private Social social;
    private Name name = new Name();
    private Title title;
    private Service service;
    private Terms terms = new Terms();
    private Skills skills = new Skills();
    private Rank rank = new Rank();
    private Resume resume = new Resume();
    private boolean alive = true;
    private Age age = new Age(18);
    private boolean serving = false;
    private Credits credits = new Credits();
    private Passages passages = new Passages();
    private Weapons weapons = new Weapons();
    private TAS tas = null;
    private Pension pension;
    private Documents documents = new Documents();

    /**
     * Honours the {@link Serializable} interface.
     */
    public Character() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public Dexterity getDexterity() {
        return dexterity;
    }

    public void setDexterity(Dexterity dexterity) {
        this.dexterity = dexterity;
    }

    public Endurance getEndurance() {
        return endurance;
    }

    public void setEndurance(Endurance endurance) {
        this.endurance = endurance;
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Terms getTerms() {
        return terms;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean b) {
        this.alive = b;
    }

    public boolean isServing() {
        return serving;
    }

    public void setServing(boolean b) {
        this.serving = b;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Pension getPension() {
        return pension;
    }

    public void setPension(Pension pension) {
        this.pension = pension;
    }

    public Documents getDocuments() {
        return documents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.gender);
        hash = 73 * hash + Objects.hashCode(this.strength);
        hash = 73 * hash + Objects.hashCode(this.dexterity);
        hash = 73 * hash + Objects.hashCode(this.endurance);
        hash = 73 * hash + Objects.hashCode(this.intelligence);
        hash = 73 * hash + Objects.hashCode(this.education);
        hash = 73 * hash + Objects.hashCode(this.social);
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.service);
        hash = 73 * hash + Objects.hashCode(this.skills);
        hash = 73 * hash + Objects.hashCode(this.rank);
        hash = 73 * hash + Objects.hashCode(this.resume);
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
        final Character other = (Character) obj;
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.strength, other.strength)) {
            return false;
        }
        if (!Objects.equals(this.dexterity, other.dexterity)) {
            return false;
        }
        if (!Objects.equals(this.endurance, other.endurance)) {
            return false;
        }
        if (!Objects.equals(this.intelligence, other.intelligence)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.social, other.social)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        if (!Objects.equals(this.skills, other.skills)) {
            return false;
        }
        if (!Objects.equals(this.rank, other.rank)) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        return true;
    }

    public Credits getCredits() {
        return credits;
    }

    public Passages getPassages() {
        return passages;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public TAS getTas() {
        return tas;
    }

    public void setTas(TAS tas) {
        this.tas = tas;
    }

}
