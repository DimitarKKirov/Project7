package stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Testing.Class.Class;

import java.sql.*;

public class CreatingTableItems {
    Connection con;
    Statement stm;
    ResultSet set;
    public CreatingTableItems() throws SQLException {
    }

    @Given("Database Shop exists")
    public void connectingToDBTheShop() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia","root","root");

            }

    @When("table Items is created")
    public void creatingTableItems() throws SQLException {
        try{
        String query= "USE [The Shop];\n" +
                "\tcreate table if not exists Items(" +
                "\tItem ID int unsigned not null auto_increment,\n" +
                "\tItem Name varchar(50) not null default '',\n" +
                "\tItem Price int unsigned default 0,\n" +
                "\tItem quantity int unsigned default 0\n )";
        stm=con.createStatement();
        stm.executeQuery(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            stm.close();
            con.close();
        }
    }

    @When("contains columns {string},{string},{string},{string}")
    public void checkingTableColumns(String string, String string2, String string3, String string4) {
        try {
            String query="Select "+string+","+string2+","+string3+","+string4+" from Items";

        stm=con.createStatement();

        set=stm.executeQuery(query);
        set.findColumn(string);
        set.findColumn(string2);
        set.findColumn(string3);
        set.findColumn(string4);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Then("the table is with empty rows")
    public void the_table_is_with_empty_rows() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
