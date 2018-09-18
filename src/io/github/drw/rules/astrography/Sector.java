package io.github.drw.rules.astrography;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of eight {@link SubSector}s.
 *
 * @author dr-wilkinson
 */
class Sector implements Edged {

    private List<Edge> edges = new ArrayList<>(4);

    private final String name;

    /**
     * Constructs a new Sector.
     *
     * @param name The Sector name.
     */
    Sector(String name) {
        this.name = name;
        initEdges();
    }

    /**
     * Returns the name of this Sector.
     *
     * @return The name.
     */
    String getName() {
        return name;
    }

    /**
     * Returns this Sectors {@link Edge} as determined by the supplied
     * {@link Direction}.
     *
     * @param direction The Direction key.
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
        edges.add(new Edge(Direction.COREWARD, null, null));
        edges.add(new Edge(Direction.RIMWARD, null, null));
        edges.add(new Edge(Direction.SPINWARD, null, null));
        edges.add(new Edge(Direction.TRAILING, null, null));
    }

}
