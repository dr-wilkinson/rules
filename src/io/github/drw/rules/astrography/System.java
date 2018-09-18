package io.github.drw.rules.astrography;

/**
 * A System is the key that binds {@link Star}s and {@link World}s together.
 *
 * @author dr-wilkinson
 */
class System {

    private final String name;

    /**
     * Returns a new System.
     *
     * @param name The name of the new System.
     */
    System(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this System.
     *
     * @return The name of this System.
     */
    String getName() {
        return name;
    }

}
