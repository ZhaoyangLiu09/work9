/**
 * Abstract class representing a generic rally car.
 * Demonstrates the Single Responsibility Principle by defining base properties.
 * Demonstrates the Open/Closed Principle as subclasses extend functionality.
 */
public abstract class RallyCar {
    private String make;
    private String model;
    private int horsepower;

    /**
     * Constructor for the RallyCar class.
     *
     * @param make       The make of the car.
     * @param model      The model of the car.
     * @param horsepower The horsepower of the car.
     */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    /**
     * Gets the make of the car.
     *
     * @return The make of the car.
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the horsepower of the car.
     *
     * @return The horsepower of the car.
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Abstract method to calculate the performance rating of the car.
     * Each subclass must implement this method based on specific attributes.
     *
     * @return The performance rating of the car.
     */
    public abstract double calculatePerformance();

    @Override
    public String toString() {
        return make + " " + model + " (Horsepower: " + horsepower + ")";
    }
}