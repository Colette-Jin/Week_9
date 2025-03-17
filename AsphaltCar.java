package main;

public class AsphaltCar extends RallyCar{
    private double downforce;

    public AsphaltCar(String make,String model,int horsepower,double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce(){
        return downforce;
    }
    @Override
    public double calculatePerformance(){
        double baseScore = 100.0;
        double horsepowerFactor = getHorsepower() * 0.5;
        double downforceFactor = getDownforce() * 2.0;
        double performanceScore = baseScore + horsepowerFactor + downforceFactor;
        return performanceScore;
    }
}
