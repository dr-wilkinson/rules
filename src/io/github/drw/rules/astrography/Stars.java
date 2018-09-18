package io.github.drw.rules.astrography;

import java.util.HashMap;
import java.util.Map;

/**
 * A collection of all the {@link Star}s within playable space.
 *
 * @author dr-wilkinson
 */
class Stars {

    private final Map<Address, Star> stars = new HashMap<>();

    /**
     * Adds the supplied {@link Star} at the given {@link Address} to this
     * collection of {@link Star}s.
     *
     * @param address The Address of the added Star.
     * @param star The Star to add.
     */
    void addStar(Address address, Star star) {
        if (contains(address)) {
            throw new IllegalArgumentException("There is already a Star at Address: " + address.asText());
        } else {
            stars.put(address, star);
        }
    }

    /**
     * Determines whether this collection of {@link Star}s contains a
     * {@link Star} at the given {@link Address}.
     *
     * @param address The Address to use as the search key.
     * @return true if a Star is present with the supplied Address.
     */
    boolean contains(Address address) {
        return stars.containsKey(address);
    }

    /**
     * Returns the {@link Star} with the supplied {@link Address} as key.
     *
     * @param address The Address to use as the search key.
     * @return The Star with the search key Address.
     */
    Star getStar(Address address) {
        return stars.get(address);
    }

}
