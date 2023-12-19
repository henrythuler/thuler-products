package com.thulerproducts.dao;

import com.thulerproducts.db.ConnectionManager;
import com.thulerproducts.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements DAO<Product>{

    private Connection connection;
    private PreparedStatement pstmt = null;

    @Override
    public ArrayList<Product> getAll() {

        ArrayList<Product> products = new ArrayList<>();

        try{

            connection = ConnectionManager.getInstance().getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM products");
            ResultSet result = pstmt.executeQuery();

            while(result.next()){

                Product product = new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getBigDecimal(4)
                );

                products.add(product);

            }

        }catch(SQLException e){

            e.printStackTrace();
            System.err.println("DB Error: " + e.getMessage());

        }finally{

            try{

                pstmt.close();
                connection.close();

            }catch(SQLException e){

                e.printStackTrace();
                System.err.println("Closing DB Connection Error: " + e.getMessage());

            }

        }

        return products;

    }

    @Override
    public Product getByCode(int code) {

        Product product = null;

        try{

            connection = ConnectionManager.getInstance().getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM products WHERE cd_product = ?");
            pstmt.setInt(1, code);
            ResultSet result = pstmt.executeQuery();

            while(result.next()){

                product = new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getBigDecimal(4)
                );

            }

        }catch(SQLException e){

            e.printStackTrace();
            System.err.println("DB Error: " + e.getMessage());

        }finally {

            try{

                pstmt.close();
                connection.close();

            }catch(SQLException e){

                e.printStackTrace();
                System.err.println("Closing DB Connection Error: " + e.getMessage());

            }

        }

        return product;

    }

    @Override
    public boolean insert(Product p) {

        //It will be > 0 if the product was inserted.
        int productInserted = 0;

        try{

            connection = ConnectionManager.getInstance().getConnection();
            pstmt = connection.prepareStatement("INSERT INTO products (cd_product, nm_product, ds_product, vl_product) " +
                    "VALUES (DEFAULT, ?, ?, ?)");

            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getDescription());
            pstmt.setBigDecimal(3, p.getValue());

            productInserted = pstmt.executeUpdate();

        }catch(SQLException e){

            e.printStackTrace();
            System.err.println("DB Error: " + e.getMessage());

        }finally {

            try{

                pstmt.close();
                connection.close();

            }catch(SQLException e){

                e.printStackTrace();
                System.err.println("Closing DB Connection Error: " + e.getMessage());

            }

        }

        //Returning true if the product was inserted.
        return productInserted > 0;

    }

    @Override
    public boolean update(Product p) {

        //It will be > 0 if the product was updated.
        int productUpdated = 0;

        boolean existsInDB = getByCode(p.getCode()) != null;

        //Verifying if this product exists in the DB
        if(existsInDB){

            try {

                connection = ConnectionManager.getInstance().getConnection();
                pstmt = connection.prepareStatement("UPDATE products SET nm_product = ?, ds_product = ?, vl_product = ? WHERE cd_product = ?");
                pstmt.setString(1, p.getName());
                pstmt.setString(2, p.getDescription());
                pstmt.setBigDecimal(3, p.getValue());
                pstmt.setInt(4, p.getCode());

                productUpdated = pstmt.executeUpdate();

            }catch(SQLException e){

                e.printStackTrace();
                System.err.println("DB Error: " + e.getMessage());

            }finally {

                try{

                    pstmt.close();
                    connection.close();

                }catch(SQLException e){

                    e.printStackTrace();
                    System.err.println("Closing DB Error: " + e.getMessage());

                }

            }

        }else{

            throw new RuntimeException("This product does not exist in the DB.");

        }

        return productUpdated > 0;

    }

    @Override
    public boolean deleteByCode(int code) {

        //It will be > 0 if the product was deleted.
        int productDeleted = 0;

        boolean existsInDB = getByCode(code) != null;

        if(existsInDB){

            try{

                connection = ConnectionManager.getInstance().getConnection();
                pstmt = connection.prepareStatement("DELETE FROM products WHERE cd_product = ?");
                pstmt.setInt(1, code);

                productDeleted = pstmt.executeUpdate();

            }catch(SQLException e){

                e.printStackTrace();
                System.err.println("DB Error: " + e.getMessage());

            }finally {

                try{

                    pstmt.close();
                    connection.close();

                }catch(SQLException e){

                    e.printStackTrace();
                    System.err.println("Closing DB Error: " + e.getMessage());

                }

            }

        }else{

            throw new RuntimeException("This product does not exist in the DB.");

        }

        return productDeleted > 0;

    }

    @Override
    public boolean deleteAll() {

        //It will be > 0 if all the products were deleted.
        int productsDeleted = 0;

        boolean existsInDB = getAll() != null;

        if(existsInDB){

            try{

                connection = ConnectionManager.getInstance().getConnection();
                pstmt = connection.prepareStatement("DELETE FROM products");

                productsDeleted = pstmt.executeUpdate();

            }catch(SQLException e){

                e.printStackTrace();
                System.err.println("DB Error: " + e.getMessage());

            }

        }else{

            throw new RuntimeException("There's no products in the DB.");

        }

        return productsDeleted > 0;

    }

}
