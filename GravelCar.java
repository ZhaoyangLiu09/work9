/**
 * Represents a rally car specifically designed for gravel surfaces.
 * Extends the RallyCar class.
 */
public class GravelCar extends RallyCar {
    private double suspensionTravel;

    /**
     * Constructor for the GravelCar class.
     *
     * @param make            The make of the car.
     * @param model           The model of the car.
     * @param horsepower      The horsepower of the car.
     * @param suspensionTravel The suspension travel of the car.
     */
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    /**
     * Gets the suspension travel of the car.
     *
     * @return The suspension travel of the car.
     */
    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    /**
     * Calculates the performance rating of the gravel car based on its horsepower and suspension travel.
     *
     * @return The performance rating of the car.
     */
    @Override
    public double calculatePerformance() {
        return getHorsepower() * (1 + suspensionTravel / 10);
    }

    @Override
    public String toString() {
        return "Gravel Car: " + super.toString() + " (Suspension Travel: " + suspensionTravel + ")";
    }
}