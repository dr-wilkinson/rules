package io.github.drw.rules.worlds;

/**
 * Enumerates the available planetary atmospheres.
 *
 * @author dr-wilkinson
 */
public enum PlanetaryAtmosphere {

    PA0("0"),
    PA1("1"),
    PA2("2"),
    PA3("3"),
    PA4("4"),
    PA5("5"),
    PA6("6"),
    PA7("7"),
    PA8("8"),
    PA9("9"),
    PAA("A"),
    PAB("B"),
    PAC("C");

    private final String value;

    private PlanetaryAtmosphere(String value) {
        this.value = value;
    }

    /**
     * Returns the value of this PlanetaryAtmosphere.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }

}
