package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    Car car = new Car(91011, "Toyota", "Corolla", 2016, "Gray", "GHI789");

    @Test
    public void testGetSetID() {
        car.setID(1010);
        assertEquals(1010, car.getID());
    }

    @Test
    public void testGetSetMake() {
        car.setMake("Chevy");
        assertEquals("Chevy", car.getMake());
    }

    @Test
    public void testGetSetModel() {
        car.setModel("Camaro");
        assertEquals("Camaro", car.getModel());
    }

    @Test
    public void testGetSetYear() {
        car.setYear(2024);
        assertEquals(2024, car.getYear());
    }

    @Test
    public void testGetSetColor() {
        car.setColor("Yellow");
        assertEquals("Yellow", car.getColor());
    }

    @Test
    public void testGetSetVin() {
        car.setVin("BUMBLEB33");
        assertEquals("BUMBLEB33", car.getVin());
    }

}