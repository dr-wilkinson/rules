package io.github.drw.rules.worlds;

/**
 * Encapsulates the available planetary sizes.
 *
 * @author dr-wilkinson
 */
public enum LawLevel {

    LL0("0"),
    LL1("1"),
    LL2("2"),
    LL3("3"),
    LL4("4"),
    LL5("5"),
    LL6("6"),
    LL7("7"),
    LL8("8"),
    LL9("9");

    private LawLevel() {
        this.value = null;
    }

    private final String value;

    private LawLevel(String value) {
        this.value = value;
    }

    /**
     * Returns the value of this LawLevel.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }
}
