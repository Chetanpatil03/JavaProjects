package CarRentalManagement;

class Car {

    //encapsulation all data members are private.

    private String carId;
    private String carModel;
    private String carBrand;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId,String carModel,String carBrand,double basePricePerDay,boolean isAvailable){
        this.carId = carId;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId(){
        return carId;
    }

    public String getCarModel(){
        return carModel;
    }

    public String getCarBrand(){
        return carBrand;
    }

    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays; 
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void rent(){
        isAvailable = false;
    }

    public void returnCar(){
        isAvailable = true;
    }

}

class Customer{
    //Encapsultion and abstraction are implemented
    private String CustName;
    private int Custid;
    private int phone;
    
    public Customer(String CustName, int Custid,int phone){
        this.CustName = CustName;
        this.Custid = Custid;
        this.phone = phone;
    }

    public String getCustName(){
        return CustName;
    }
    public int getCustId(){
        return Custid;
    }

    public int getCustPhone(){
        return phone;
    }
}

class Rental{

    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car,Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){
        return car;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getDays(){
        return days;
    }
}



public class Main{

    public static void main(String[] args) {
        System.out.println("Car Rental management System in java");
    }
}