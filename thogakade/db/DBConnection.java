/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.db;

import java.sql.*;

/**
 *
 * @author HESHAN
 */
public class DBConnection {

    private Connection connection;
    private static DBConnection dBConnection;

    private DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "12345678");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
