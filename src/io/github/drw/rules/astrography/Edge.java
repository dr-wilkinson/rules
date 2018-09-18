package io.github.drw.rules.astrography;

/**
 * An edge is a connection between two {@link Edged} regions of space.
 *
 * @author dr-wilkinson
 */
class Edge {

    private final Direction direction;
    private final Edged a;
    private final Edged b;

    /**
     * Constructs a new Edge with a defining {@link Direction} and two
     * {@link Edged} regions of space.
     *
     * @param direction The defining Direction.
     * @param a An Edged region of space.
     * @param b An Edged region of space.
     */
    Edge(Direction direction, Edged a, Edged b) {
        this.direction = direction;
        this.a = a;
        this.b = b;
    }

    /**
     * Returns {@link Edged} region of space #A.
     *
     * @return The Edged region of space.
     */
    Edged getA() {
        return a;
    }

    /**
     * Returns {@link Edged} region of space #B.
     *
     * @return The Edged region of space.
     */
    Edged getB() {
        return b;
    }

    /**
     * Returns this Edges {@link Direction}.
     *
     * @return The Direction.
     */
    Direction getDirection() {
        return direction;
    }

}
