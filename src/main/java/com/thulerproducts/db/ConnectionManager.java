package com.thulerproducts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance;

    private ConnectionManager(){}

    public static ConnectionManager getInstance(){
        if(instance == null) instance = new ConnectionManager();
        return instance;
    }

    public Connection getConnection(){

        Connection connection = null;

        try{

            Class.forName("org.postgresql.Driver");
            String host = System.getenv("POSTGRES_HOST");
            String user = System.getenv("POSTGRES_USER");
            String password = System.getenv("POSTGRES_PASSWORD");
            String db = System.getenv("POSTGRES_DATABASE");
            String connectionString = String.format("jdbc:postgresql://%s:5432/%s?user=%s&password=%s&ssl=true&sslmode=require", host, db, user, password);
            connection = DriverManager.getConnection(connectionString);

        }catch(ClassNotFoundException e){

            e.printStackTrace();
            System.err.println("Driver Error: " + e.getMessage());

        }catch(SQLException e){

            e.printStackTrace();
            System.err.println("DB Error: " + e.getMessage());

        }

        return connection;

    }

}
