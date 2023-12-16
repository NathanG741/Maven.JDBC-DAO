package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void  main (String[] args) throws SQLException {
        Dao_Class dao = new Dao_Class();
        ResultSet rs = (ResultSet) dao.findById(1234);
        if(rs.next())
        {

            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("model"));

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