package com.Estafet.TheShop;

import java.sql.SQLException;

public class Main {
public static void main(String[] args) {

    try {
        TheShopDatabase databaseCreation= new TheShopDatabase();
        databaseCreation.createTableItems();
        databaseCreation.createTableUsers();
        
    }catch (SQLException e){
        e.printStackTrace();
    }


//    try{
//        TheShopDatabase newData= new TheShopDatabase("Cougar Keyboard",99.99,10);
//        TheShopDatabase User1=new TheShopDatabase("Dimitar","Kirov","Sofia","LeftCorner Street Number 123 ");
//    }catch (SQLException e){
//        e.printStackTrace();
//    }
//
}


}
