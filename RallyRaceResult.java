import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the results of a rally race.
 * Implements the RaceResult interface.
 */
public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results; // Stores driver and their points

    /**
     * Constructor for the RallyRaceResult class.
     *
     * @param raceName The name of the race.
     * @param location The location of the race.
     */
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    /**
     * Gets the name of the race.
     *
     * @return The name of the race.
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * Gets the location of the race.
     *
     * @return The location of the race.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Records the result of a driver in the race.
     *
     * @param driver   The driver who participated in the race.
     * @param position The finishing position of the driver.
     * @param points   The points earned by the driver.
     */
    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points); // Also update driver's total points
    }

    /**
     * Gets the points earned by a driver in the race.
     *
     * @param driver The driver to get points for.
     * @return The points earned by the driver.
     */
    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0); // Return 0 if driver not found
    }

    /**
     * Gets a list of drivers who participated in the race, sorted by their finishing position.
     *
     * @return A list of drivers.
     */
    @Override
    public List<Driver> getResults() {
        // Sort drivers based on points (higher points first)
        List<Driver> sortedDrivers = new ArrayList<>(results.keySet());
        sortedDrivers.sort((d1, d2) -> results.get(d2).compareTo(results.get(d1)));
        return sortedDrivers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Race: ").append(raceName).append(" (").append(location).append(")\n");
        List<Driver> sortedResults = getResults();
        for (int i = 0; i < sortedResults.size(); i++) {
            Driver driver = sortedResults.get(i);
            sb.append("Position ").append(i + 1).append(": ").append(driver.getName()).append(" - ").append(results.get(driver)).append(" points\n");
        }
        return sb.toString();
    }
}