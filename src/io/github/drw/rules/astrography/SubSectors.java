package io.github.drw.rules.astrography;

import java.util.HashMap;
import java.util.Map;

/**
 * A collection of all {@link SubSector}s within playable space.
 *
 * @author dr-wilkinson
 */
public class SubSectors {

    private final Map<String, SubSector> subSectors = new HashMap<>();

    /**
     * Adds a {@link SubSector} to this collection of {@link SubSector}s.
     *
     * @param subSector The SubSector to add.
     * @return true if the SubSector was added, otherwise false.
     */
    boolean addSubSector(SubSector subSector) {
        if (subSectors.containsKey(subSector.getName())) {
            return false;
        } else {
            subSectors.put(subSector.getName(), subSector);
        }
        return true;
    }

    /**
     * Determines whether this collection of {@link SubSector}s contains a
     * {@link SubSector} with the given name.
     *
     * @param name The name to search with.
     * @return true if the named SubSector is present, otherwise false.
     */
    boolean contains(String name) {
        return subSectors.containsKey(name);
    }

    /**
     * Returns the {@link SubSector} with the supplied name.
     *
     * @param name The name to search with.
     * @return The SubSector with the supplied name.
     */
    SubSector getSubSector(String name) {
        return subSectors.get(name);
    }

}
