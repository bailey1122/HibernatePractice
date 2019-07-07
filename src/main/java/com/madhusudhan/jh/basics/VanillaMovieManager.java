package com.madhusudhan.jh.basics;

import com.madhusudhan.jh.domain.Movie;

import java.sql.*;

public class VanillaMovieManager {
    private Connection connection = null;

    // Database properties
    private String url = "jdbc:mysql://localhost:3306/JH";
    private String driverClass = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "1234";

//    private String tableSql = "create table MOVIES (ID integer not null, TITLE varchar(255), DIRECTOR varchar(255), SYNOPSIS varchar(255), primary key (ID))";

    private Connection getConnection() {
        try {
            Class.forName(driverClass).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.err.println("Exception:" + ex.getMessage());
        }
        return connection;
    }


    private String insertSql = "INSERT INTO MOVIES VALUES (?,?,?,?)";


    private void persistMovie() {
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertSql);
            pst.setInt(1, 2);
            pst.setString(2, "Top Gun");
            pst.setString(3, "Action Film");
            pst.setString(4, "Tony Scott");

            // Execute the statement
            pst.execute();
            System.out.println("Movie12m persisted successfully");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void queryMovies() {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MOVIES");
            while (rs.next()) {
                System.out.println("Movie12m Found: "
                        + rs.getInt("ID")
                        + ", Title: "
                        + rs.getString("TITLE"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        VanillaMovieManager movieManager = new VanillaMovieManager();
        movieManager.getConnection();
        movieManager.persistMovie();
        movieManager.queryMovies();
    }
}
