package io.github.drw.rules.astrography;

import java.util.ArrayList;
import java.util.List;

/**
 * A six {@link Edge}d hexagonal region of space.
 *
 * @author dr-wilkinson
 */
class Hexector implements Edged {

    private List<Edge> edges = new ArrayList<>(6);

    private final String name;
    private final HexAddress hexAddress;

    /**
     * Constructs a new Hexector with the supplied {@link HexAddress}.
     *
     * @param hexAddress The HexAddress of the new Hexector.
     */
    Hexector(HexAddress hexAddress) {
        this.name = hexAddress.asText();
        this.hexAddress = hexAddress;
        initEdges();
    }

    /**
     * Returns the name of this Hexector.
     *
     * @return The name of this Hexector.
     */
    String getName() {
        return name;
    }

    /**
     * Returns the {@link HexAddress} of this Hexector.
     *
     * @return This Hexectors HexAddress.
     */
    HexAddress getHexAddress() {
        return hexAddress;
    }

    /**
     * Returns the {@link Edge} identified by it's {@link Direction} key.
     *
     * @param direction The Direction of this Edge.
     * @return The Edge.
     */
    Edge getEdge(Direction direction) {
        for (Edge edge : edges) {
            if (edge.getDirection().equals(direction)) {
                return edge;
            }
        }
        return null;
    }

    private void initEdges() {
        edges.add(new Edge(Direction.D0, null, null));
        edges.add(new Edge(Direction.D1, null, null));
        edges.add(new Edge(Direction.D2, null, null));
        edges.add(new Edge(Direction.D3, null, null));
        edges.add(new Edge(Direction.D4, null, null));
        edges.add(new Edge(Direction.D5, null, null));
    }

}
