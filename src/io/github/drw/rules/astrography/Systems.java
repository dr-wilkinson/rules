package io.github.drw.rules.astrography;

import java.util.HashMap;
import java.util.Map;

/**
 * A collection of all the {@link System}s within playable space.
 *
 * @author dr-wilkinson
 */
class Systems {

    private final Map<String, System> systems = new HashMap<>();

    /**
     * Adds a {@link System} to the Systems.
     *
     * @param system The System to add.
     * @return true if added, otherwise false.
     */
    boolean addSystem(System system) {
        if (systems.containsKey(system.getName())) {
            return false;
        } else {
            systems.put(system.getName(), system);
        }
        return true;
    }

    /**
     * Returns the presence of a {@link System} within this collection of
     * {@link System}s.
     *
     * @param name The name of the System to search for.
     * @return true if the named System is present, otherwise false.
     */
    boolean contains(String name) {
        return systems.containsKey(name);
    }

    /**
     * Returns the {@link System} with the supplied name.
     *
     * @param name The name to search with.
     * @return The named System.
     */
    System getSystem(String name) {
        return systems.get(name);
    }

}
