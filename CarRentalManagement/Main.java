package CarRentalManagement;

import java.nio.channels.Pipe.SourceChannel;
import java.text.NumberFormat.Style;
import java.util.ArrayList;
import java.util.Scanner;

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

class CarRentalSystem{
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car); 
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car,Customer customer,int days){
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else{
            System.out.println("The car is not available for rent ..........");
        }
    }

    public void returnCar(Car car){
        Rental rentalToRemove = null;
        
        for(Rental rental : rentals){
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returned Successfully........!");
        }
        else{
            System.out.println("Car was not Rented");
        }

        car.returnCar();
    }
}

class Menu{

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*********** Car rental System ***********");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");
            System.out.println("Enter Your choice : ");

            int ch = sc.nextInt();

            if (ch ==  1) {
                System.out.println("\n*** Rent a Car ***");
                System.out.println("Enter Your Name : ");
                String custName = sc.nextLine();

                System.out.println("Available Cars -- ");
                for(Car car : cars){

                }
            }
        }
}

public class Main{

    public static void main(String[] args) {
        System.out.println("Car Rental Management System......");
    }
}