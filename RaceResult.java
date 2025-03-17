import java.util.List;

/**
 * Interface for recording and retrieving race results.
 * Demonstrates Interface Segregation Principle.
 */
public interface RaceResult {
    /**
     * Records the result of a driver in a race.
     *
     * @param driver   The driver who participated in the race.
     * @param position The finishing position of the driver.
     * @param points   The points earned by the driver.
     */
    void recordResult(Driver driver, int position, int points);

    /**
     * Gets the points earned by a driver in the race.
     *
     * @param driver The driver to get points for.
     * @return The points earned by the driver.
     */
    int getDriverPoints(Driver driver);

    /**
     * Gets a list of drivers who participated in the race.
     *
     * @return A list of drivers.
     */
    List<Driver> getResults();
}