package io.github.drw.rules.worlds;

/**
 * The base data that defines a world.
 *
 * @author dr-wilkinson
 */
public class WorldUPP {

    private final StarportType starportType;
    private final PlanetarySize planetarySize;
    private final PlanetaryAtmosphere planetaryAtmosphere;
    private final HydrographicPercentage hydrographicPercentage;
    private final PopulationTotal populationTotal;
    private final GovernmentalType governmentalType;
    private final LawLevel lawLevel;

    /**
     * Constructs a new WorldUPP.
     *
     * @param starportType The star port type.
     * @param planetarySize The size of the planet.
     * @param planetaryAtmosphere The planets size.
     * @param hydrographicPercentage The percentage of surface covered by water
     * (liquid).
     * @param populationTotal The total population.
     * @param governmentalType The type of government.
     * @param lawLevel The law level.
     */
    public WorldUPP(StarportType starportType, PlanetarySize planetarySize, PlanetaryAtmosphere planetaryAtmosphere, HydrographicPercentage hydrographicPercentage, PopulationTotal populationTotal, GovernmentalType governmentalType, LawLevel lawLevel) {
        this.starportType = starportType;
        this.planetarySize = planetarySize;
        this.planetaryAtmosphere = planetaryAtmosphere;
        this.hydrographicPercentage = hydrographicPercentage;
        this.populationTotal = populationTotal;
        this.governmentalType = governmentalType;
        this.lawLevel = lawLevel;
    }

    /**
     * Returns the star port type.
     *
     * @return The star port type.
     */
    public StarportType getStarportType() {
        return starportType;
    }

    /**
     * Returns the size of the planet.
     *
     * @return The size of the planet.
     */
    public PlanetarySize getPlanetarySize() {
        return planetarySize;
    }

    /**
     * Returns the planets atmosphere.
     *
     * @return The planets atmosphere.
     */
    public PlanetaryAtmosphere getPlanetaryAtmosphere() {
        return planetaryAtmosphere;
    }

    /**
     * Returns the percentage of the surface covered with water (liquid).
     *
     * @return The percentage of water (liquid) coverage.
     */
    public HydrographicPercentage getHydrographicPercentage() {
        return hydrographicPercentage;
    }

    /**
     * Returns the total population.
     *
     * @return The population total.
     */
    public PopulationTotal getPopulationTotal() {
        return populationTotal;
    }

    /**
     * Returns the type of government.
     *
     * @return The type of government.
     */
    public GovernmentalType getGovernmentalType() {
        return governmentalType;
    }

    /**
     * Returns the law level.
     *
     * @return The law level.
     */
    public LawLevel getLawLevel() {
        return lawLevel;
    }

    /**
     * Returns this worlds characteristics as a UPP.
     *
     * @return This worlds UPP.
     */
    public String asUPP() {
        StringBuilder sb = new StringBuilder();
        sb.append(starportType.getValue());
        sb.append(planetarySize.getValue());
        sb.append(planetaryAtmosphere.getValue());
        sb.append(hydrographicPercentage.getValue());
        sb.append(populationTotal.getValue());
        sb.append(governmentalType.getValue());
        sb.append(lawLevel.getValue());
        return sb.toString();
    }

}
