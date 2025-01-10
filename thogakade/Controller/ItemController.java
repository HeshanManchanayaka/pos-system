/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.Controller;

import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import thogakade.db.DBConnection;
import thogakade.model.Item;

/**
 *
 * @author HESHAN
 */
public class ItemController {

    public static Iterable<String> loadAllItemCodes() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().prepareStatement("SELECT code FROM item").executeQuery();
        ArrayList<String> ids = new ArrayList<>();
        while(rst.next()){
            ids.add(rst.getString(1));
        }
        return ids;
    }

    public static Item searchItem(String Code) throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * from Item where Code='" + Code + "'");
        while (rst.next()) {
            return new Item(rst.getString("code"), rst.getString("description"), rst.getDouble("unitPrice"), rst.getInt("qtyOnHand"));
        }
        return null;  
    }
    
}
