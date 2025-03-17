/**
 * Main class to demonstrate the Rally Championship Management System.
 */
public class RallyChampionship {
    public static void main(String[] args) {
        // 1. Create and configure the ChampionshipManager singleton
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // 2. Create and register drivers with appropriate cars
        RallyCar gravelCar1 = new GravelCar("Ford", "Fiesta", 380, 25.0);
        RallyCar asphaltCar1 = new AsphaltCar("Toyota", "Yaris", 400, 30.0);
        Driver driver1 = new Driver("Sébastien Ogier", "France", gravelCar1);
        manager.registerDriver(driver1);

        RallyCar gravelCar2 = new GravelCar("Hyundai", "i20", 390, 24.5);
        RallyCar asphaltCar2 = new AsphaltCar("Hyundai", "i20", 410, 31.0);
        Driver driver2 = new Driver("Thierry Neuville", "Belgium", asphaltCar2);
        manager.registerDriver(driver2);

        RallyCar gravelCar3 = new GravelCar("Toyota", "GR Yaris", 400, 26.0);
        RallyCar asphaltCar3 = new AsphaltCar("Toyota", "GR Yaris", 420, 32.0);
        Driver driver3 = new Driver("Kalle Rovanperä", "Finland", gravelCar3);
        manager.registerDriver(driver3);

        RallyCar gravelCar4 = new GravelCar("Ford", "Puma", 370, 23.0);
        RallyCar asphaltCar4 = new AsphaltCar("Ford", "Puma", 390, 29.0);
        Driver driver4 = new Driver("Ott Tänak", "Estonia", gravelCar4);
        manager.registerDriver(driver4);


        // 3. Simulate at least two races with different surfaces
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        race1.recordResult(driver3, 1, 25);
        race1.recordResult(driver4, 2, 18);
        race1.recordResult(driver1, 3, 15);
        race1.recordResult(driver2, 4, 12);
        manager.addRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(driver1, 1, 25);
        race2.recordResult(driver2, 2, 18);
        race2.recordResult(driver3, 3, 15);
        race2.recordResult(driver4, 4, 12);
        manager.addRaceResult(race2);

        // 4. Display championship standings, statistics, and race results
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        for (Driver driver : manager.getDriverStandings()) {
            System.out.println(driver);
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = ChampionshipManager.getLeadingDriver();
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        } else {
            System.out.println("No drivers registered.");
        }

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.races) {
            System.out.println(race);
        }

        // 5. Demonstrate car switching between races
        System.out.println("\n===== CAR SWITCHING =====");
        System.out.println("Before car switch: " + driver1.getName() + " - " + driver1.getCar());
        driver1.setCar(asphaltCar1);
        System.out.println("After car switch: " + driver1.getName() + " - " + driver1.getCar());

        // 6. Show performance calculations for different car types
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar1.calculatePerformance());
    }
}