package io.github.drw.rules.astrography;

/**
 * A star within a {@link System}.
 *
 * @author dr-wilkinson
 */
class Star {

    private final String name;

    /**
     * Constructs a new Star.
     *
     * @param name The name of the new Star.
     */
    Star(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this Star.
     *
     * @return The name of the Star.
     */
    String getName() {
        return name;
    }

}
