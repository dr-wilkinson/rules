package io.github.drw.rules.worlds;

/**
 * Enumerates the size of the population.
 *
 * @author dr-wilkinson
 */
public enum PopulationTotal {

    PT0("0"),
    PT1("1"),
    PT2("2"),
    PT3("3"),
    PT4("4"),
    PT5("5"),
    PT6("6"),
    PT7("7"),
    PT8("8"),
    PT9("9"),
    PTA("A");

    private final String value;

    private PopulationTotal(String value) {
        this.value = value;
    }

    /**
     * Returns the value of this PopulationTotal.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }

}
