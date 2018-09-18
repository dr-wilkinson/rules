package io.github.drw.rules.astrography;

/**
 * Enumerates the directions for space navigation.
 *
 * @author dr-wilkinson
 */
enum Direction {

    SPINWARD("Spinward"),
    TRAILING("Trailing"),
    COREWARD("Coreward"),
    RIMWARD("Rimward"),
    D0("0"),
    D1("1"),
    D2("2"),
    D3("3"),
    D4("4"),
    D5("5");

    private final String value;

    private Direction(String value) {
        this.value = value;
    }

}
