package io.github.drw.rules.worlds;

/**
 * Enumerates the hydrographic (land/water) percentages.
 *
 * @author dr-wilkinson
 */
public enum HydrographicPercentage {

    HP0("0"),
    HP1("1"),
    HP2("2"),
    HP3("3"),
    HP4("4"),
    HP5("5"),
    HP6("6"),
    HP7("7"),
    HP8("8"),
    HP9("9"),
    HPA("A");

    private final String value;

    private HydrographicPercentage(String value) {
        this.value = value;
    }

    /**
     * Returns the percentage of water (liquid) coverage.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }

}
