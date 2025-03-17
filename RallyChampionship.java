package main;

import java.util.List;

/*



 */
public class RallyChampionship 
{
    public static void main( String[] args )
    {
        //1. Creates and configures the ChampionshipManager singleton
        ChampionshipManager CManager = ChampionshipManager.getInstance();

        //2. Create and register drivers with appropriate cars
        RallyCar gravelcar_Ogier = new GravelCar("Toyota", "Yaris", 380, 200);
        RallyCar gravelcar_Rovanperä = new GravelCar("Toyota", "Yaris", 380, 200);
        RallyCar asphaltCar_Tänak = new AsphaltCar("Hyundai", "i20", 380, 150);
        RallyCar asphaltCar_Neuville = new AsphaltCar("Hyundai", "i20", 380, 150);

        Driver driver_01 = new Driver("Sébastien Ogier", "France", gravelcar_Ogier);
        Driver driver_02 = new Driver("Kalle Rovanperä", "Finland", gravelcar_Rovanperä);
        Driver driver_03 = new Driver("Ott Tänak", "Estonia", asphaltCar_Tänak);
        Driver driver_04 = new Driver("Thierry Neuville", "Belgium", asphaltCar_Neuville);
        CManager.registerDriver(driver_01);
        CManager.registerDriver(driver_02);
        CManager.registerDriver(driver_03);
        CManager.registerDriver(driver_04);


        //5. Demonstrate car switching between races
        //Simulate gravel race
        RallyRaceResult rallyFinland = new RallyRaceResult("Rally Finland", "Jyväskylä");
        driver_03.setCar(asphaltCar_Neuville);
        driver_04.setCar(asphaltCar_Neuville);
        rallyFinland.recordResult(driver_01, 1, 25);
        rallyFinland.recordResult(driver_03, 2, 18);
        rallyFinland.recordResult(driver_02, 3, 15);
        rallyFinland.recordResult(driver_04, 4, 12);
        CManager.addRaceResult(rallyFinland);
        
        //Simulate asphalt race
        RallyRaceResult montecarloRally = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        driver_01.setCar(gravelcar_Ogier);
        driver_02.setCar(gravelcar_Rovanperä);
        driver_03.setCar(asphaltCar_Neuville);
        driver_04.setCar(asphaltCar_Neuville);
        montecarloRally.recordResult(driver_02, 1, 25);
        montecarloRally.recordResult(driver_04, 2, 18);
        montecarloRally.recordResult(driver_01, 3, 15);
        montecarloRally.recordResult(driver_03, 4, 12);
        CManager.addRaceResult(montecarloRally);

        
        
        //4. Display championship standings, statistics, and race results
        List<Driver> drivers = CManager.getDriversStandings();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leadDriver = ChampionshipManager.getLeadingDriver();
        System.out.println(leadDriver.getName()+" with "+leadDriver.getPoints()+" points");
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: "+ChampionshipManager.totalDrivers);
        System.out.println("Total Races: "+ChampionshipManager.totalRaces);
        System.out.println("Average Points Per Driver: "+ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
        System.out.println("Most Successful Country: "+ChampionshipStatistics.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship Points: "+ChampionshipManager.getTotalChampionShipPoints());
        System.out.println("\n===== RACE RESULTS =====");
        rallyFinland.getResults();
        montecarloRally.getResults();
        //6. Show performance calculations for different car types
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: "+((GravelCar) gravelcar_Ogier).calculatePerformance());
        System.out.println("Asphalt Car Performance: "+((AsphaltCar) asphaltCar_Neuville).calculatePerformance());
    }
}
