package com.Estafet.TheShop;

import java.sql.*;
import java.util.ArrayList;

public class TheShopDatabase {

    private static Connection con;
    private static Statement stmt;
    private PreparedStatement prep;
    private String itemName;
    private int itemID;
    private double itemPrice;
    private int itemQuantity;

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userCity;
    private String userAddress;
    private static String name;
    static boolean  expl=true;
    private static ArrayList<TheShopDatabase> temporalAr = new ArrayList<>();

    public boolean isExpl() {
        return expl;
    }

    public void setExpl(boolean expl) {
        this.expl = expl;
    }

    public void setName(String name) {
        TheShopDatabase.name = name;
    }

    public String getName() {
        return name;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public PreparedStatement getPrep() {
        return prep;
    }

    public void setPrep(PreparedStatement prep) {
        this.prep = prep;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public TheShopDatabase() {

    }

    public TheShopDatabase(Connection con, Statement stmt, String itemName, int itemID, long itemPrice,
                           int itemQuantity, int userId, String userFirstName, String userLastName,
                           String userCity, String userAddress) {
        this.con = con;
        this.stmt = stmt;
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCity = userCity;
        this.userAddress = userAddress;
    }

    public TheShopDatabase(String itemName, double itemPrice, int itemQuantity) throws SQLException {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        try {
            String itemInsert = "Insert ignore into Items (ItemName,ItemPrice,ItemQuantity) values (?,?,?)";
            connection();
            prep = con.prepareStatement(itemInsert);
            prep.setString(1, itemName);
            prep.setDouble(2, itemPrice);
            prep.setInt(3, itemQuantity);
            prep.execute();
            System.out.println("Inserting ItemsData");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    public TheShopDatabase(String userFirstName, String userLastName, String userCity, String userAddress) throws SQLException {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCity = userCity;
        this.userAddress = userAddress;

        try {
            String itemInsert = "Insert into Users (UserFirstName,UserLastName,UserCity,UserAddress) values (?,?,?,?)";
            connection();
            prep = con.prepareStatement(itemInsert);
            prep.setString(1, userFirstName);
            prep.setString(2, userLastName);
            prep.setString(3, userCity);
            prep.setString(4, userAddress);
            prep.execute();
            System.out.println("Inserting UserData");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    public static void createTableItems() throws SQLException {
        try {
            String createTableItems = " Create table if not exists Items\n" +
                    "(" +
                    "\tItemName varchar(50) not null UNIQUE,\n" +
                    "\tItemID int unsigned not null auto_increment,\n" +
                    "\tItemPrice double unsigned not null default 1.99,\n" +
                    "\tItemQuantity int not null default 0,\n" +
                    "\tconstraint ItemsPK primary key (ItemID,ItemName)" +
                    ");";
            connection();
            stmt = con.createStatement();
            stmt.execute(createTableItems);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }

    public void createTableUsers() throws SQLException {
        try {
            String createTableUsers = " Create table if not exists Users\n" + "(" +
                    "\tUserID int unsigned not null auto_increment, \n" +
                    "\tUserFirstName varchar(50) not null default 'First Name', \n" +
                    "\tUserLastName varchar(50) not null default 'Last Name',\n " +
                    "\tUserCity varchar(50) not null default 'Enter City',\n" +
                    "\tUserAddress varchar(150) not null default 'Enter address',\n" +
                    "\tprimary key (UserID)" +
                    ");";
            connection();
            stmt = con.createStatement();
            stmt.execute(createTableUsers);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            System.out.println("Table is created");
            closeConnection();
        }


    }

    public static void connection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theshop?serverTimezone=Europe/Sofia", "root", "root");
            System.out.println("Connection successful");
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



    @Override
    public String toString() {
        return
                "itemName= " + itemName +
                        ", itemID= " + itemID +
                        ", itemPrice= " + itemPrice +
                        ", itemQuantity= " + itemQuantity
                ;
    }
}
