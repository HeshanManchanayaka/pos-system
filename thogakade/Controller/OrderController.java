/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import thogakade.db.DBConnection;

/**
 *
 * @author HESHAN
 */
public class OrderController {

    public static String getLastOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT id FROM Orders ORDER BY id DESC LiMIT 1");
        return rst.next()?rst.getString("id"):null;
    }
    
}
