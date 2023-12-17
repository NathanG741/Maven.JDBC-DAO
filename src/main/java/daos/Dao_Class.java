package daos;

import models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao_Class implements DAO_Interface {

    @Override
    public Object findById(int id) {
        Connection connection = Main.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Car_Info WHERE id=" + id);
            while (rs.next()) {
                Car car = new Car(rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("vin"));
                return car;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List findAll() {
        Connection connection = Main.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Car_Info");

            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = new Car(rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("vin"));
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Object update(Object dto) {
        Connection connection = Main.getConnection();
        Car car = (Car) dto;

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate(String.format("UPDATE Car_Info SET make=\"%s\", model=\"%s\", year=%d, color=\"%s\", vin=\"%s\" WHERE id=%d",
                    car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getVin(), car.getID()));
            return car;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Object create(Object dto) {
        Connection connection = Main.getConnection();
        Car car = (Car) dto;

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate(String.format("INSERT INTO Car_Info Values (%d, \"%s\", \"%s\", %d, \"%s\", \"%s\")",
                    car.getID(), car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getVin()));
            return car;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Connection connection = Main.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Car_Info WHERE id=" + id);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
