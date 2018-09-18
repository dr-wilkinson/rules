package io.github.drw.rules.worlds;

/**
 * Encapsulates the available planetary sizes.
 *
 * @author dr-wilkinson
 */
public enum PlanetarySize {

    PS0("0"),
    PS1("1"),
    PS2("2"),
    PS3("3"),
    PS4("4"),
    PS5("5"),
    PS6("6"),
    PS7("7"),
    PS8("8"),
    PS9("9"),
    PSA("A"),
    PSB("B"),
    PSC("C");

    private PlanetarySize() {
        this.value = null;
    }

    private final String value;

    private PlanetarySize(String value) {
        this.value = value;
    }

    /**
     * Returns the value of this PlanetarySize.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }
}
