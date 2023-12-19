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
            String connectionString = "jdbc:postgresql://ep-small-cake-15698116-pooler.us-east-1.postgres.vercel-storage.com:5432/verceldb?user=default&password=clu5jt8FnsLv&ssl=true&sslmode=require";
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
