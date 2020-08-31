package com.Estafet.TheShop;

import java.sql.*;

public class TableUsers {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userCity;
    private String userAddress;
    private String electronMail;
    private static Connection con;
    private static Statement stmt;
    private PreparedStatement prep;

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public TableUsers() {

    }

    public TableUsers(String userFirstName, String userLastName, String userCity, String userAddress, String electronMail) throws SQLException {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCity = userCity;
        this.userAddress = userAddress;
        this.electronMail = electronMail;

        try {
            String itemInsert = "Insert ignore into Users (UserFirstName,UserLastName,UserCity,UserAddress,UserEmail) values (?,?,?,?,?)";
            connection();
            prep = con.prepareStatement(itemInsert);
            prep.setString(1, userFirstName);
            prep.setString(2, userLastName);
            prep.setString(3, userCity);
            prep.setString(4, userAddress);
            prep.setString(5, electronMail);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    public static void deleteUsersContent() throws SQLException {
        try {
            String deleteItemsContent = "Truncate table users";
            connection();
            stmt = con.createStatement();
            stmt.execute(deleteItemsContent);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();

        }
    }

    public static void updateZipOrPostalCode(String column,String mail, String postalZipCode) throws SQLException {
        try{
            String updatePrice="update ignore Users set "+column+"= "+"'"+postalZipCode+"'"+" where UserEMail= "+"'"+mail+"'";
            connection();
            stmt=con.createStatement();
            stmt.execute(updatePrice);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
            con.close();
        }
    }

    public static void connection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theshop?serverTimezone=Europe/Sofia", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
