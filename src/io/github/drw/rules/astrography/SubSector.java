package io.github.drw.rules.astrography;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A four {@link Edged} rectangular region of space.
 *
 * @author dr-wilkinson
 */
class SubSector implements Edged {

    private Map<String, Hexector> map = new HashMap<>(8);
    private List<Edge> edges = new ArrayList<>(4);

    private final String name;

    /**
     * Constructs a new SubSector.
     *
     * @param name The name of the new SubSector.
     */
    SubSector(String name) {
        this.name = name;
        initEdges();
    }

    /**
     * Returns the name of the SubSector.
     *
     * @return The name of the SubSector.
     */
    String getName() {
        return name;
    }

    /**
     * Returns the {@link Edge} of this SubSector based on the supplied
     * {@link Direction}.
     *
     * @param direction The Direction that identifies the Edge to return.
     * @return The identified Edge.
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
