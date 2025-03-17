package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    protected String raceName;
    protected String location;
    Map<Driver,Integer> results;

    public RallyRaceResult(String raceName,String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public void recordResult(Driver driver,int position,int points){
         results.put(driver, points);
         driver.addPoints(points);
    }
    @Override
    public int getDriverPoints(Driver driver){
        int point = results.get(driver);
        return point;
    }
    @Override
    public List<Driver> getResults(){
        //save keyset(driver) into arrayList, sort with points descend
        List<Driver> dscDrivers = new ArrayList<>(results.keySet());
        dscDrivers.sort((driver_b,driver_a)->Integer.compare(results.get(driver_a), results.get(driver_b)));
        //print results
        int i = 0;
        System.out.println("Race: "+getRaceName()+" ("+getLocation()+")");
        for (Driver currentDriver:dscDrivers){
            i++;
            System.out.println("  Position "+i+": "+currentDriver.getName()+" - "+results.get(currentDriver)+" points");
        }
        //System.out.println("\n");
        return dscDrivers;
    }
}
