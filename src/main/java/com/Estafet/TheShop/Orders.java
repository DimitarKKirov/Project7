package com.Estafet.TheShop;

import java.sql.*;

public class Orders {
    private static Connection con;
    private static Connection conUsers;
    private static Connection conItems;
    private static Statement stmt;
    private PreparedStatement prep;
    private String userFirstName;
    private String userLastName;
    private String userCity;
    private String userAddress;
    private String electronMail;
    private String userBasket;
    private double totalPrice;
    private int itemQuantity;
    private static int a;
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

    public String getElectronMail() {
        return electronMail;
    }

    public void setElectronMail(String electronMail) {
        this.electronMail = electronMail;
    }

    public String getUserBasket() {
        return userBasket;
    }

    public void setUserBasket(String userBasket) {
        this.userBasket = userBasket;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private static int getA() {
        return a;
    }

    private static void setA(int a) {
        Orders.a = a;
    }

    public Orders(String userFirstName, String userLastName, String userCity, String userAddress, String electronMail, String userBasket, double totalPrice, int itemQuantity) throws SQLException {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCity = userCity;
        this.userAddress = userAddress;
        this.electronMail = electronMail;
        this.userBasket = userBasket;
        this.totalPrice = totalPrice;
        this.itemQuantity=itemQuantity;
        try {
            String itemInsert = "Insert ignore into usersOrders (UserFirstName,UserLastName,UserCity,UserAddress,UserEMail" +
                    ",UserBasket,ItemTotalPrice,QuantityOfItems) values (?,?,?,?,?,?,?,?)";
            connection();
            prep = con.prepareStatement(itemInsert);
            prep.setString(1, userFirstName);
            prep.setString(2, userLastName);
            prep.setString(3, userCity);
            prep.setString(4, userAddress);
            prep.setString(5, electronMail);
            prep.setString(6, userBasket);
            prep.setDouble(7, totalPrice);
            prep.setInt(8,itemQuantity);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    public static void userBuyingItem(String eMail, String itemName) throws SQLException {
        try {
             String tempUserFirstName="";
             String tempUserLastName="";
             String tempUserCity="";
             String tempUserAddress="";
             String tempElectronMail="";
             String tempUserBasket="";
             double tempTotalPrice=0;
            int tempItemQuantity=0;
            int bothQuantity=1;
            String searchItems = "Select * from Items where ItemName = " + "'" + itemName + "'";
            String searchEMail = "Select * from Users where UserEMAIL = " + "'" + eMail + "'";
            connection();
            stmt = con.createStatement();
            ResultSet setItem = stmt.executeQuery(searchItems);
            while (setItem.next()) {
                for (int i = 0; i < 1; i++) {
                    tempUserBasket=setItem.getString("ItemName");
                    tempTotalPrice=setItem.getDouble("ItemPrice");
                    tempItemQuantity=setItem.getInt("ItemQuantity");

                }

            }
            ResultSet setUser = stmt.executeQuery(searchEMail);
            while (setUser.next()) {
                for (int i = 0; i < 1; i++) {
                    tempUserFirstName=setUser.getString("UserFirstName");
                    tempUserLastName=setUser.getString("UserLastName");
                    tempUserCity=setUser.getString("UserCity");
                    tempUserAddress=setUser.getString("UserAddress");
                    tempElectronMail=setUser.getString("UserEMail");
                }

            }
            Orders order=new Orders(tempUserFirstName,tempUserLastName,tempUserCity,tempUserAddress,tempElectronMail
            ,tempUserBasket,tempTotalPrice,bothQuantity);
            itemQuantitySubtraction(tempItemQuantity);
            connection();
            String subtractQuantity = "Update Items set ItemQuantity= "+ getA() +" where ItemName= " + "'" + itemName + "'";
            stmt = con.createStatement();
            stmt.execute(subtractQuantity);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

private static   void itemQuantitySubtraction(int tempItemQuantity){
        int a=tempItemQuantity-1;
        setA(a);
}
    public static void connection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theshop?serverTimezone=Europe/Sofia", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
