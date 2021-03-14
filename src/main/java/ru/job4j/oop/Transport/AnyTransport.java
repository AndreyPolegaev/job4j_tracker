package ru.job4j.oop.Transport;

public class AnyTransport {
    public static void main(String[] args) {
        Vehicle airPlane = new AirPlane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[] {airPlane, train, bus};
        for (Vehicle temp : vehicles) {
            temp.move();
        }
    }
}
