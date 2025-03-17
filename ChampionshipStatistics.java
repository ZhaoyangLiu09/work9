import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utility class for calculating championship statistics.
 * Demonstrates the use of static methods.
 */
public class ChampionshipStatistics {

    /**
     * Calculates the average points per driver in the championship.
     *
     * @param drivers The list of drivers.
     * @return The average points per driver.
     */
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers.isEmpty()) {
            return 0;
        }
        return drivers.stream().mapToInt(Driver::getPoints).average().orElse(0);
    }

    /**
     * Finds the most successful country in the championship based on total points.
     *
     * @param drivers The list of drivers.
     * @return The most successful country.
     */
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers.isEmpty()) {
            return "N/A";
        }

        Map<String, Integer> countryPoints = drivers.stream()
                .collect(Collectors.groupingBy(Driver::getCountry, Collectors.summingInt(Driver::getPoints)));

        return countryPoints.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

    /**
     * Gets the total number of races held in the championship.
     *
     * @return The total number of races held.
     */
    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}