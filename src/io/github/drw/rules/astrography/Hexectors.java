package io.github.drw.rules.astrography;

import java.util.HashMap;
import java.util.Map;

/**
 * A collection of all the {@link Hexector}s within playable space.
 *
 * @author dr-wilkinson
 */
class Hexectors {

    private final Map<String, Hexector> hexectors = new HashMap<>();

    /**
     * Adds a Hexector to this collection of Hexectors.
     *
     * @param hexector The Hexector to be added.
     * @return true if the Hexector was added, otherwise false.
     */
    boolean addHexector(Hexector hexector) {
        if (hexectors.containsKey(hexector.getName())) {
            return false;
        } else {
            hexectors.put(hexector.getName(), hexector);
        }
        return true;
    }

    /**
     * Determines whether a Hexector with the supplied name exists.
     *
     * @param name The name key to search with.
     * @return true if this collection contains a Hexector named by the supplied
     * key, otherwise false.
     */
    boolean contains(String name) {
        return hexectors.containsKey(name);
    }

    /**
     * Returns the Hexector with the key name.
     *
     * @param name The name key to search with.
     * @return The Hexector with the name key.
     */
    Hexector getHexector(String name) {
        return hexectors.get(name);
    }

}
