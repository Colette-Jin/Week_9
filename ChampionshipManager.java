package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private static List<Driver> drivers;
    private List<RallyRaceResult> races;
    static int totalDrivers;
    static int totalRaces;

    public ChampionshipManager(){
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance(){
        //CM should be a singleton
        if(instance ==null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers +=1;
    }

    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces +=1;
    }

    public List<Driver> getDriversStandings(){
        drivers.sort((driver_02,driver_01)->Integer.compare(driver_01.getPoints(), driver_02.getPoints()));
        int i = 0;
        for(Driver currentDriver : drivers) {
            i++;
            System.out.println(i+". "+currentDriver.getName()+" ("+currentDriver.getCountry()+"): "+currentDriver.getPoints()+" points");
        }
        return drivers;
    }

    static Driver getLeadingDriver(){
        drivers.sort((driver_02,driver_01)->Integer.compare(driver_01.getPoints(), driver_02.getPoints()));
        if (!drivers.isEmpty()) {
            Driver leadDriver = drivers.get(0);
            return leadDriver;
        } else {
            System.out.println("No registered driver exits!");
            return null;
        }
    }

    static int getTotalChampionShipPoints(){
        int totalPoints = 0;
        for(Driver eachDriver : drivers) {
            int point = eachDriver.getPoints();
            totalPoints = totalPoints + point;
        }
        return totalPoints;
    }
}
