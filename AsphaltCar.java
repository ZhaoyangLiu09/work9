/**
 * Represents a rally car specifically designed for asphalt surfaces.
 * Extends the RallyCar class.
 */
public class AsphaltCar extends RallyCar {
    private double downforce;

    /**
     * Constructor for the AsphaltCar class.
     *
     * @param make       The make of the car.
     * @param model      The model of the car.
     * @param horsepower The horsepower of the car.
     * @param downforce  The downforce of the car.
     */
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /**
     * Gets the downforce of the car.
     *
     * @return The downforce of the car.
     */
    public double getDownforce() {
        return downforce;
    }

    /**
     * Calculates the performance rating of the asphalt car based on its horsepower and downforce.
     *
     * @return The performance rating of the car.
     */
    @Override
    public double calculatePerformance() {
        return getHorsepower() * (1 + downforce / 10);
    }

    @Override
    public String toString() {
        return "Asphalt Car: " + super.toString() + " (Downforce: " + downforce + ")";
    }
}