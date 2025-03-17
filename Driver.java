/**
 * Represents a rally driver with their name, country, points, and car.
 */
public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    /**
     * Constructor for the Driver class.
     *
     * @param name    The name of the driver.
     * @param country The country of the driver.
     * @param car     The rally car assigned to the driver.
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    /**
     * Gets the name of the driver.
     *
     * @return The name of the driver.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the country of the driver.
     *
     * @return The country of the driver.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the total points of the driver.
     *
     * @return The total points of the driver.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Gets the rally car assigned to the driver.
     *
     * @return The rally car of the driver.
     */
    public RallyCar getCar() {
        return car;
    }

    /**
     * Sets the rally car for the driver.
     *
     * @param car The new rally car for the driver.
     */
    public void setCar(RallyCar car) {
        this.car = car;
    }

    /**
     * Adds points to the driver's total.
     *
     * @param points The points to add.
     */
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return name + " (" + country + "): " + points + " points";
    }
}