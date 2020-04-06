package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


//Initial Commit

public class Reporter {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public Reporter() throws Exception {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connect = DriverManager.getConnection("jdbc:derby://localhost/C:/Users/flavien.girard/IdeaProjects/IFP_better/db");
            PreparedStatement statement = connect.prepareStatement("SELECT * from REPORTER where id=?");

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String pseudo = resultSet.getString("pseudo");
                String credit = resultSet.getString("credit");
                System.out.println("ID: " + ID);
                System.out.println("Pseudo: " + pseudo);
                System.out.println("Credit: " + credit);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    private static void createNewReporter()
    {

    }
}
