package io.github.drw.rules.worlds;

/**
 * Encapsulates the available planetary sizes.
 *
 * @author dr-wilkinson
 */
public enum GovernmentalType {

    GT0("0"),
    GT1("1"),
    GT2("2"),
    GT3("3"),
    GT4("4"),
    GT5("5"),
    GT6("6"),
    GT7("7"),
    GT8("8"),
    GT9("9"),
    GTA("A"),
    GTB("B"),
    GTC("C"),
    GTD("D");

    private GovernmentalType() {
        this.value = null;
    }

    private final String value;

    private GovernmentalType(String value) {
        this.value = value;
    }

    /**
     * Returns the value of this GovernmentalType.
     *
     * @return The value.
     */
    public String getValue() {
        return value;
    }
}
