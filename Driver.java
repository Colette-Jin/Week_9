package main;

public class Driver {
    private String name;
    private String country;
    private int point;
    protected RallyCar car;

    public Driver(String name,String country,RallyCar car){
        //injecting a RallyCar
        this.name = name;
        this.country = country;
        this.car = car;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public int getPoints(){
        return point;
    }

    public RallyCar getCar(){
        return car;
    }


    
    public void setCar(RallyCar car){
        //switch car
        try {
            if (!(car instanceof GravelCar)) {
                    // Create a new GravelCar instance
                    GravelCar gravelCar = new GravelCar(car.getMake(), car.getModel(), car.getHorsepower(), 200); 
                    this.car = gravelCar;
            }
            else if (!(car instanceof AsphaltCar)) {
                    // Create a new AsphaltCar instance
                    AsphaltCar asphaltCar = new AsphaltCar(car.getMake(), car.getModel(), car.getHorsepower(), 150); 
                    this.car = asphaltCar;
            }
            else{
                System.out.println("Wrong car type!");
            }
            
        } catch (NumberFormatException e) {
            // TODO: handle exception
            System.out.println("Invalid integer!");
        }
    }

    public void addPoints(int points){
        point = point+points;
    }
}
