package com.Estafet.TheShop;

import com.Estafet.TheShop.PropertiReader.PropertiesReader;

import java.sql.*;
import java.util.ArrayList;

import static com.Estafet.TheShop.PropertiReader.PropertiesReader.readerConnector;

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
            con.close();
        }
    }

    public static void createTableUsers() throws SQLException {
        try {
            String createTableUsers = " Create table if not exists Users\n" + "(" +
                    "\tUserID int unsigned not null auto_increment, \n" +
                    "\tUserFirstName varchar(50) not null default 'First Name', \n" +
                    "\tUserLastName varchar(50) not null default 'Last Name',\n " +
                    "\tUserCity varchar(50) not null default 'Enter City',\n" +
                    "\tUserAddress varchar(150) not null default 'Enter address',\n" +
                    "\tUserEMail varchar(50) not null UNIQUE,\n " +
                    "\tprimary key (UserID)" +
                    ");";
            connection();
            stmt = con.createStatement();
            stmt.execute(createTableUsers);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();
        }


    }

    public static void createOrdersTable() throws SQLException {
        try {
            String createTableUsers = " Create table if not exists usersOrders\n" + "(" +
                    "\tOrderID int unsigned not null auto_increment, \n" +
                    "\tUserFirstName varchar(50) not null default 'First Name', \n" +
                    "\tUserLastName varchar(50) not null default 'Last Name',\n " +
                    "\tUserCity varchar(50) not null default 'Enter City',\n" +
                    "\tUserAddress varchar(150) not null default 'Enter address',\n" +
                    "\tUserEMail varchar(50) not null default '',\n " +
                    "\tUserBasket varchar(500) not null default 'Enter address',\n" +
                    "\tItemTotalPrice double not null default 0,\n" +
                    "\tprimary key (OrderID)" +
                    ");";
            connection();
            stmt = con.createStatement();
            stmt.execute(createTableUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();
        }
    }

    public static void updateOrdersColumn(String column,String type){
        try{
            String addColumn="Alter table usersOrders add column  "+column+" "+type;
            connection();
            stmt=con.createStatement();
            stmt.execute(addColumn);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateUsersColumn(String column,String type){
        try{
            String addColumn="Alter table Users add column "+column+" "+type;
            connection();
            stmt=con.createStatement();
            stmt.execute(addColumn);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void connection() {
        con=readerConnector("C:\\Users\\Admin\\IdeaProjects\\Git Project7\\Poject7\\src\\test\\props\\SQLTheShop.properties");
    }
    public static void connectionGiven() {
       con= readerConnector("C:\\Users\\Admin\\IdeaProjects\\Git Project7\\Poject7\\src\\test\\props\\SQLTheShop.properties");

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
                "\n\nitemName: " + itemName +
                        ",\n itemID: " + itemID +
                        ",\n itemPrice: " + itemPrice +
                        ",\n itemQuantity: " + itemQuantity
                ;
    }
}
