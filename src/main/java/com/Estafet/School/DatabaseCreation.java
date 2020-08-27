package com.Estafet.School;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreation {
    Connection con;
    Statement stmt;

    public void createTableStudents() throws SQLException {
        try {
            String createTableStudents = " Create table if not exists Students\n" + "(" +
                    "\tName varchar(50) not null default 'No Name'\n" +
                    "\tYear int not nul default 1\n" + ")";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cucumber?serverTimezone=Europe/Sofia", "root", "root");
            stmt = con.createStatement();
            stmt.execute(createTableStudents);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }

    public void createTableGrades() throws SQLException {
        try {
            String createTableGrades = " Create table if not exists Grades\n" + "(" +
                    "\tStudentID int unsigned not null auto_increment \n" +
                    "\tSubjectID int \n" +
                    "\tGrade int not null default 2" + ")";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cucumber?serverTimezone=Europe/Sofia", "root", "root");
            stmt = con.createStatement();
            stmt.execute(createTableGrades);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }


    }

    public void createTableSubjects() throws SQLException {
        try {
            String createTableStudents = " Create table if not exists Subjects\n" + "(" +
                    "\tName varchar(50) not null default 'No Name'\n" +
                    "\tYear int not nul default 1\n" + ")";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cucumber?serverTimezone=Europe/Sofia", "root", "root");
            stmt = con.createStatement();
            stmt.execute(createTableStudents);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();
        }
    }

}
