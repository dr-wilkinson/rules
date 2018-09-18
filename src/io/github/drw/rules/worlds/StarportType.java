package io.github.drw.rules.worlds;

/**
 * Enumerates the types of {@link Startport} that are available.
 *
 * @author dr-wilkinson
 */
public enum StarportType {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    X("X");

    private final String value;

    private StarportType(String value) {
        this.value = value;
    }

    /**
     * Returns the value of this StarportType.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }

}
