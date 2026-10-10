import java.util.*;

abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return days * 80;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        rentVehicle(sedan, "Customer 1", 3);
        rentVehicle(sedan, "Customer 2", 2);
        returnVehicle(sedan, "Customer 1");
        rentVehicle(suv, "Customer 3", 5);
    }

    static void rentVehicle(Vehicle v, String customer, int days) {
        if (v.available) {
            v.available = false;
            System.out.println(v.name + " rented by " + customer);
            System.out.println("Rental charge: $" +
                    v.calculateCharge(days));
        } else {
            System.out.println(v.name + " is unavailable");
        }
    }

    static void returnVehicle(Vehicle v, String customer) {
        v.available = true;
        System.out.println(v.name + " returned by " + customer);
    }
}