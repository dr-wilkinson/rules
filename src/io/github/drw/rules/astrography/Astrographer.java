package io.github.drw.rules.astrography;

import io.github.drw.rules.worlds.World;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides astrography (star mapping) functionality.
 *
 * @author dr-wilkinson
 */
public class Astrographer {

    private static String message;

    private static Sectors sectors = new Sectors();
    private static SubSectors subSectors = new SubSectors();
    private static Hexectors hexectors = new Hexectors();
    private static Systems systems = new Systems();
    private static Stars stars = new Stars();
    private static Worlds worlds = new Worlds();
    private static List<Address> addresses = new ArrayList<>();

    /**
     * Adds a {@link Sector} to the playable space and returns its
     * {@link Address}.
     *
     * @param sector The Sector to add.
     * @return The Address.
     */
    public static Address addSector(Sector sector) {
        if (sectors.contains(sector.getName())) {
            throw new IllegalArgumentException(sector.getName() + " is already in use by a Sector!");
        } else {
            sectors.addSector(sector);
        }
        return new Address().append(sector.getName());
    }

    /**
     * Adds a {@link SubSector} with a given {@link Address} to the playable
     * space and returns its {@link Address}.
     *
     * @param address The SubSector Address.
     * @param subSector The SubSector to add.
     * @return The Address of the added SubSector.
     */
    public static Address addSubSector(Address address, SubSector subSector) {
        if (sectors.contains(address.getSectorName())) {
            if (subSectors.contains(subSector.getName())) {
                throw new IllegalArgumentException(subSector.getName() + " is already in use by a SubSector!");
            } else {
                subSectors.addSubSector(subSector);
            }
        } else {
            throw new IllegalArgumentException(address.getSectorName() + " does not exist!");
        }
        return address.append(subSector.getName());
    }

    /**
     * Adds a {@link Hexector} with a given {@link Address} to the playable
     * space and returns its {@link Address}.
     *
     * @param address The Hexector Address.
     * @param hexector The Hexector to add.
     * @return The Address of the added Hexector.
     */
    public static Address addHexector(Address address, Hexector hexector) {
        if (subSectors.contains(address.getSubSectorName())) {
            if (hexectors.contains(hexector.getName())) {
                throw new IllegalArgumentException(hexector.getName() + " is already in use by a Hexector!");
            } else {
                hexectors.addHexector(hexector);
            }
        } else {
            throw new IllegalArgumentException(address.getSubSectorName() + " does not exist!");
        }
        return address.append(hexector.getName());
    }

    /**
     * Adds a {@link System} with a given {@link Address} to the playable space
     * and returns its {@link Address}.
     *
     * @param address The System Address.
     * @param system The System to add.
     * @return The Address of the added System.
     */
    public static Address addSystem(Address address, System system) {
        if (hexectors.contains(address.getHexectorName())) {
            if (systems.contains(system.getName())) {
                throw new IllegalArgumentException(system.getName() + " is already in use by a System!");
            } else {
                systems.addSystem(system);
            }
        } else {
            throw new IllegalArgumentException(address.getHexectorName() + " does not exist!");
        }
        return address.append(system.getName());
    }

    /**
     * Adds a {@link Star} with the supplied {@link Address} to the playable
     * space.
     *
     * @param address The Address of the Star.
     * @param star The Star to add.
     * @throws IllegalArgumentException
     */
    public void addStar(Address address, Star star) throws IllegalArgumentException {
        stars.addStar(address, star);
    }

    /**
     * Adds a {@link BirthWorld} at the supplied {@link Address}.
     *
     * @param address The Address of the BirthWorld.
     * @param world The BirthWorld to add.
     * @return true if the BirthWorld was successfully added, otherwise false.
     */
    public boolean addWorld(Address address, World world) {
        if (!worlds.addWorld(address, world)) {
            message = worlds.getMessage();
            return false;
        }
        return true;
    }

    /**
     * Returns the message.
     *
     * @return The message.
     */
    public static String getMessage() {
        return message;
    }

}
