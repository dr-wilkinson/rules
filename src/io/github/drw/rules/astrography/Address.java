package io.github.drw.rules.astrography;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Defines the full address of
 * {@link Sector}, {@link SubSector}, {@link Hexector}, {@link System}, {@link Star}
 * or {@link World}
 *
 * @author dr-wilkinson
 */
public class Address {

    private List<String> names = new ArrayList<>();

    /**
     * Appends the supplied name to this Address.
     *
     * @param name The name to add.
     * @return This Address with the appended name.
     */
    Address append(String name) {
        if (names.contains(name)) {
            throw new IllegalArgumentException(name + " already exists within this address!");
        }
        names.add(name);
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.names);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.names, other.names)) {
            return false;
        }
        return true;
    }

    /**
     * Returns the {@link Sector} name.
     *
     * @return The Sector name.
     */
    String getSectorName() {
        if (names.isEmpty()) {
            throw new IllegalStateException("A Sector name hasn't been added to this address yet!");
        } else {
            return names.get(0);
        }
    }

    /**
     * Returns the {@link SubSector} name.
     *
     * @return The SubSector name.
     */
    String getSubSectorName() {
        if (names.isEmpty() || names.size() == 1) {
            throw new IllegalStateException("A SubSector name hasn't been added to this address yet!");
        } else {
            return names.get(1);
        }
    }

    /**
     * Returns the {@link Hexector} name.
     *
     * @return The Hexector name.
     */
    String getHexectorName() {
        if (names.isEmpty() || names.size() == 2) {
            throw new IllegalStateException("A Hexector name hasn't been added to this address yet!");
        } else {
            return names.get(2);
        }
    }

    /**
     * Returns the {@link System} name.
     *
     * @return The System name.
     */
    String getSystemName() {
        if (names.isEmpty() || names.size() == 3) {
            throw new IllegalStateException("A System name hasn't been added to this address yet!");
        } else {
            return names.get(3);
        }
    }

    /**
     * Returns a textual view of this Address.
     *
     * @return A textual view of this Address.
     */
    String asText() {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(":");
        }
        return sb.toString().replace(':', ' ').trim();
    }

}
