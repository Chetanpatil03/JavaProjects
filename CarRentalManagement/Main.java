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
    private String Custid;
    private int phone;
    
    public Customer(String CustName, String Custid,int phone){
        this.CustName = CustName;
        this.Custid = Custid;
        this.phone = phone;
    }

    public String getCustName(){
        return CustName;
    }
    public String getCustId(){
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
            //System.out.println("Car returned Successfully........!");
        }
        else{
            //System.out.println("Car was not Rented");
        }

        car.returnCar();
    }


    public void Menu(){

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*********** Car rental System ***********");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");
            System.out.println("Enter Your choice : ");

            int ch = sc.nextInt();
            sc.nextLine(); //for new line

            if (ch ==  1) {
                System.out.println("\n*** Rent a Car ***");
                System.out.println("Enter Your Name : ");
                String custName = sc.nextLine();
                System.out.println("Enter Your Mobile : ");
                int custNo = sc.nextInt();


                System.out.println("Available Cars -- ");
                for(Car car : cars){
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getCarBrand() + " " + car.getCarModel());
                    }
                }

                System.out.println("Enter the carId you want to rent : ");
                String carId = sc.nextLine();

                System.out.println("Enter number of days for rent: ");
                int rentalDays = sc.nextInt();
                sc.nextLine(); //consume new line

                Customer newCustomer = new Customer(custName,"CUS"+customers.size()+1, custNo);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car: cars){
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;  
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);

                    System.out.println("\n == Rental information ==\n");
                    System.out.println("Customer ID : "+newCustomer.getCustId());
                    System.out.println("Customer Name : "+newCustomer.getCustName());
                    System.out.println("Customer Number : "+newCustomer.getCustPhone());
                    System.out.println("Car : "+selectedCar.getCarBrand() +" "+selectedCar.getCarModel());
                    System.out.println("Rental Days : "+rentalDays);
                    System.out.println("Total price : $%.2f%n "+totalPrice);

                    System.out.println("\n Confirm Rental [Y/N] : ");
                    String confirmString = sc.nextLine();

                    if (confirmString.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented successfully.....\n");
                    }
                    else{
                        System.out.println("\nRental canceled..");
                    }
                }
                else{
                    System.out.println("\nInvalid car selection or car not available for rent");
                }
            }
            if (ch == 2) {
                System.out.println("\n*** Return a Car ***");
                System.out.println("Enter Car id : ");
                String carIdString = sc.nextLine();

                Car carToReturn = null;
                
                for(Car car : cars){
                    if (car.getCarId().equals(carIdString) && car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                Customer customer = null;
                if (carToReturn != null) 
                {
                    
                    for(Rental rental:rentals){
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                

                    if (customer != null) {
                        returnCar(carToReturn);
                    System.out.println("Car returned Successfully by "+customer.getCustName());
                    }
                    else{
                    System.out.println("Car was not rented or information is missing.....");
                    }
                }
                else{
                    System.out.println("Invalid car ID or car was not rented");
                }
            }
            else if (ch==3) {
                break;
            }
            else{
                System.out.println("Invalid choice!, Please enter valid option.");
            }

        }
        System.out.println("Thank you for using Car Retal System.");
    }
}

public class Main{

    public static void main(String[] args) {
        System.out.println("Car Rental Management System......");
    }
}