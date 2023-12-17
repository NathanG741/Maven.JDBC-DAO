package daos;

import models.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void  main (String[] args) {
        Dao_Class dao = new Dao_Class();

        // CREATE
        Car car = new Car(91011, "Toyota", "Corolla", 2016, "Gray", "GHI789");
        dao.create(car);

        // READ
        Car findCar = (Car) dao.findById(car.getID());
        System.out.println("Find By ID = " + findCar.getID());

        // UPDATE
        car.setColor("Silver");
        Car updateCar = (Car) dao.update(car);
        System.out.println("Update = " + updateCar.getID() + " " + updateCar.getColor());

        // DELETE
        dao.delete(car.getID());

        // READ ALL
        List<Car> carList = dao.findAll();
        for (Car carObj : carList) {
            System.out.println("Find All = " + carObj.getID());
        }

    }

    public static Connection getConnection(){
        String username = "nate";
        String password = "nate123";
        String dbUrl = "jdbc:mysql://localhost:3306/DAOLAB";
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("Connection Established to MYSQL Database");

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        }
        return conn;
    }
}