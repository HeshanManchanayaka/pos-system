/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.Controller;

import java.sql.*;
import java.util.ArrayList;
import thogakade.model.Customer;
import thogakade.db.DBConnection;

/**
 *
 * @author HESHAN
 */
public class CustomerController {

    public static boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Customer Values (?,?,?,?)");
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());

        return stm.executeUpdate() > 0;
    }

    public static Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * from Customer where id='" + id + "'");
        while (rst.next()) {
            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
        }
        return null;
    }

    public static boolean upadateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Customer set name=?,address=?,salary=? where id=?");
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getSalary());
        stm.setObject(4, customer.getId());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Customer where id='" + id + "'") > 0;
    }

    public static ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> CustomerList=new ArrayList<>();
        ResultSet rst =DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * from Customer");
        while(rst.next()){
            CustomerList.add(new Customer(rst.getString("id"),rst.getString("name"),rst.getString("address"),rst.getDouble("salary")));
        }
        return CustomerList;
    }

    public static Iterable<String> getAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().prepareStatement("SELECT id FROM Customer").executeQuery();
        ArrayList<String> idSet = new ArrayList<>();
        while(rst.next()){
            idSet.add(rst.getString(1));
        }
        return idSet;
    }

}
