package main;

public class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model,int horsepower,double suspensionTravel){
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel(){
        return suspensionTravel;
    }

    @Override
    public double calculatePerformance(){
        double baseScore = 100.0;
        double horsepowerFactor = getHorsepower() * 0.5;
        double suspensionFactor = suspensionTravel * 2.0;
        double performanceScore = baseScore + horsepowerFactor + suspensionFactor;
        return performanceScore;
    }
}
