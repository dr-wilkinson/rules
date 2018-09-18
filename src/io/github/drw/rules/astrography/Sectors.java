package io.github.drw.rules.astrography;

import java.util.HashMap;
import java.util.Map;

/**
 * The collection of all {@link Sector}s within playable space.
 *
 * @author dr-wilkinson
 */
class Sectors {

    private final Map<String, Sector> sectors = new HashMap<>();

    /**
     * Adds the supplied {@link Sector} to this collection of {@link Sector}s.
     *
     * @param sector The Sector to add.
     * @return true if the Sector was added, otherwise false.
     */
    boolean addSector(Sector sector) {
        if (sectors.containsKey(sector.getName())) {
            return false;
        } else {
            sectors.put(sector.getName(), sector);
        }
        return true;
    }

    /**
     * Determines whether this collection of {@link Sector}s contains a
     * {@link Sector} with the supplied search key name.
     *
     * @param name The name to use as the search key.
     * @return true if a {@link Sector} with the search key name is present,
     * otherwise false.
     */
    boolean contains(String name) {
        return sectors.containsKey(name);
    }

    /**
     * Returns the {@link Sector} identified by the search key name.
     *
     * @param name The name to use as the search key name.
     * @return The Sector identified by the supplied search key name.
     */
    Sector getSector(String name) {
        return sectors.get(name);
    }

}
