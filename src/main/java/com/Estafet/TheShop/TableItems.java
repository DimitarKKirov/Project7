package com.Estafet.TheShop;

import java.sql.*;
import java.util.ArrayList;

public class TableItems {


    private static Connection con;
    private static Statement stmt;
    private static String name;
    static boolean expl = true;
    private static ArrayList<TheShopDatabase> temporalAr = new ArrayList<>();

    public boolean isExpl() {
        return expl;
    }

    public void setExpl(boolean expl) {
        TableItems.expl = expl;
    }

    public static void setName(String name) {
        TableItems.name = name;
    }

    public String getName() {
        return name;
    }

    public static void searchForItemByName(String name) {
        try {
            String search = "Select * from Items where ItemName =" + " " + "'" + name + "'";
            connection();
            stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(search);
            while (set.next()) {
                setName(set.getString("ItemName"));
                for (int i = 0; i < 1; i++) {
                    TheShopDatabase temp = new TheShopDatabase();
                    temp.setItemID(set.getInt("ItemID"));
                    temp.setItemPrice(set.getDouble("ItemPrice"));
                    temp.setItemQuantity(set.getInt("itemQuantity"));
                    temp.setItemName(set.getString("ItemName"));
                    temporalAr.add(temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void searchByPrice(double price) {
        if (!negativeCheck(price)) {
            System.out.println("Negative numbers are not allowed " + price);
            setExpl(false);
        } else {
            try {
                System.out.println("Searching for " + price);
                TheShopDatabase one = new TheShopDatabase();
                connection();
                stmt = con.createStatement();
                String searchPrice = "Select * from items where itemPrice= " + price;
                ResultSet set = stmt.executeQuery(searchPrice);
                while (set.next()) {
                    for (int i = 0; i < 1; i++) {
                        one.setItemName(set.getString("ItemName"));
                        one.setItemID(set.getInt("ItemID"));
                        one.setItemPrice(set.getDouble("ItemPrice"));
                        one.setItemQuantity(set.getInt("ItemQuantity"));
                        temporalAr.add(one);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
    }


    public void searchingByRangePrice(double a, double b) {
        if (!negativeCheck2(a, b)) {
            System.out.println("Negative numbers are not allowed " + a + ", " + b);
            setExpl(false);
        } else {
            TheShopDatabase one = new TheShopDatabase();
            try {
                System.out.println("\nSearching for item with price range between " + a + " and " + b);
                String range = "Select * from items where ItemPrice between " + a + " and " + b;
                connection();
                stmt = con.createStatement();
                ResultSet set = stmt.executeQuery(range);
                while (set.next()) {
                    for (int i = 0; i < 1; i++) {
                        one.setItemName(set.getString("ItemName"));
                        one.setItemID(set.getInt("ItemID"));
                        one.setItemPrice(set.getDouble("ItemPrice"));
                        one.setItemQuantity(set.getInt("ItemQuantity"));
                        temporalAr.add(one);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean negativeCheck(double price) {
        if (price < 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean negativeCheck2(double a, double b) {
        if (a < 0 && b < 0 || a < 0 && b > 0 || a > 0 && b < 0) {
            return false;
        } else {
            return true;
        }
    }


    public void explanation() {
        if (!isExpl()) {
            System.out.println("In the database table Items," +
                    " prices cannot be entered with negative sign");
        }

    }

    public void searchByNameResult() {
        if (getName() == null) {
            System.out.println("Item not found");
        } else {
            System.out.println(getName() + " is found in table Items");
        }
        setName(null);
    }

    public void itemIsFound() {
        if (temporalAr.isEmpty()) {
            System.out.println("item is not in the table");
        } else {
            System.out.println("Item is found");
        }
    }

    public static void printFoundItem() {
        if (temporalAr.isEmpty()) {
            System.out.println("There is nothing to show");
        } else {
            System.out.println("\nItems are found " + temporalAr);
            temporalAr.clear();
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
    public static void deleteTableItemsContent() throws SQLException {
        try {
            String deleteItemsContent = " Truncate table items";
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
}
