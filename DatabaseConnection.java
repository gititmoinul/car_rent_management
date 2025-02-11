package rentyourcar;


import java.sql.*;



public class DatabaseConnection {
        Connection c;
        Statement s;

    public DatabaseConnection() {
        try {
            // Explicitly load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///carrentalsystem", "root", "Bakerbhai130!");
            s =c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
    }
}

    