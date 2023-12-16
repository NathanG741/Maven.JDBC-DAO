package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Dao_Class implements DAO_Interface {

    @Override
    public Object findById(int id) {
        Connection connection = Main.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Car_Info WHERE id=" + id);
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object create(Object dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
