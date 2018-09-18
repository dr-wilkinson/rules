package io.github.drw.rules.io;

import java.util.Objects;

/**
 * Encapsulates name data from a names text file.
 *
 * @author dr-wilkinson
 */
public class NameData {

    private final String value;
    private final Gender gender;
    private final boolean lastName;

    /**
     * Constructs a new NameDate object.
     *
     * @param value The value - i.e. the name itself.
     * @param gender The {@link Gender}.
     * @param lastName Can this name be used as a last name?
     */
    public NameData(String value, Gender gender, boolean lastName) {
        this.value = value;
        this.gender = gender;
        this.lastName = lastName;
    }

    /**
     * Returns the value of this NameData object - i.e. the name.
     *
     * @return The name value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the {@link Gender} of this name.
     *
     * @return The Gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Determines whether this name can be used as a last name.
     *
     * @return true if it can, otherwise false.
     */
    public boolean canBeLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.value);
        hash = 53 * hash + Objects.hashCode(this.gender);
        hash = 53 * hash + Objects.hashCode(this.lastName);
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
        final NameData other = (NameData) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (this.lastName != other.lastName) {
            return false;
        }
        return true;
    }

    public enum Gender {
        BOTH,
        MALE,
        FEMALE;

        public static Gender convert(io.github.drw.rules.characters.genders.Gender gender) {
            Gender g = null;
            if (gender.getValue().equals("Male")) {
                g = Gender.MALE;
            } else if (gender.getValue().equals("Female")) {
                g = Gender.FEMALE;
            }
            return g;
        }

    }

}
