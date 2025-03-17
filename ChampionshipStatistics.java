package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {
    static double calculateAveragePointsPerDriver(List<Driver> drivers){
        int count = 0;
        int totalPoints = 0;
        for(Driver currentDriver:drivers){
            totalPoints += currentDriver.getPoints();
            count++;
        }
        return totalPoints/count;
    }

    //define a hashmap to save countries and their totalPoints respectively
    //country with most points will be returned
    static String findMostSuccessfulCountry(List<Driver> drivers){
        String country;
        int point;
        Map<String,Integer> countryPoints = new HashMap<>();
        for(Driver currentDriver:drivers){
            country = currentDriver.getCountry();
            point = currentDriver.getPoints();
            if (!countryPoints.containsKey(country)) {
                countryPoints.put(country, point);
            }
            else{
                countryPoints.put(country, countryPoints.get(country)+point);
            }
        }
        List<String> countryList = new ArrayList<>(countryPoints.keySet());
        countryList.sort((c2,c1)->Integer.compare(countryPoints.get(c1),countryPoints.get(c2)));
        country = countryList.get(0);
        return country;
    }
    
    static int getTotalRacesHeld(){
        return ChampionshipManager.totalRaces;
    }
}
