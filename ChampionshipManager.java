import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Manages the rally championship, including drivers and race results.
 * Implemented as a Singleton to ensure only one instance exists.
 */
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    public List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private ChampionshipManager() {
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of the ChampionshipManager.
     *
     * @return The singleton instance.
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    /**
     * Registers a new driver in the championship.
     *
     * @param driver The driver to register.
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    /**
     * Adds a race result to the championship.
     *
     * @param result The race result to add.
     */
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    /**
     * Gets the championship standings, sorted by points.
     *
     * @return A list of drivers sorted by points.
     */
    public List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(drivers);
        standings.sort(Comparator.comparingInt(Driver::getPoints).reversed());
        return standings;
    }

    /**
     * Gets the leading driver in the championship.
     *
     * @return The leading driver.
     */
    public static Driver getLeadingDriver() {
        if (instance == null || instance.drivers.isEmpty()) {
            return null;
        }
        return instance.drivers.stream().max(Comparator.comparingInt(Driver::getPoints)).orElse(null);
    }

    /**
     * Gets the total championship points awarded.
     *
     * @return The total championship points.
     */
    public static int getTotalChampionshipPoints() {
        if (instance == null) {
            return 0;
        }
        return instance.drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    /**
     * Gets the total number of drivers registered.
     *
     * @return The total number of drivers.
     */
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    /**
     * Gets the total number of races held.
     *
     * @return The total number of races.
     */
    public static int getTotalRaces() {
        return totalRaces;
    }
}