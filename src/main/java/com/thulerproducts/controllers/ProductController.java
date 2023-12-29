package com.thulerproducts.controllers;

import com.thulerproducts.dao.DAO;
import com.thulerproducts.dao.ProductDAO;
import com.thulerproducts.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        DAO<Product> dao = new ProductDAO();

        String code = req.getParameter("code");

        if(code == null){
            code = "";
        }

        //Verifying if this is a search request
        if(!code.isEmpty()){

            Product p = dao.getByCode(Integer.parseInt(req.getParameter("code")));

            //Verifying if there's a product that corresponds the passed code in the request parameter
            if (p == null) req.setAttribute("error", true);
            else req.setAttribute("product", p);

            //Verifying if there's an action parameter in the request
            String action = req.getParameter("action");
            if(action == null){
                action = "";
            }

            //Verifying if this is a common "search request" or a "get-product-for-update request"
            if(action.equals("get-product-for-update")) req.getRequestDispatcher("update-product.jsp").forward(req, res);
            else req.getRequestDispatcher("search-product.jsp").forward(req, res);

        }else{

            HttpSession session = req.getSession();
            session.setAttribute("products", dao.getAll());
            req.getRequestDispatcher("products.jsp").forward(req, res);

        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        DAO<Product> dao = new ProductDAO();

        String code = req.getParameter("code");
        String message;

        String action = req.getParameter("action");

        //Verifying which request is it
        switch(action){

            case "create-product":

                //Getting the input values
                String productName = req.getParameter("name");
                String productDescription = req.getParameter("description");
                BigDecimal productValue = BigDecimal.valueOf(Double.parseDouble(req.getParameter("value")));

                Product p = new Product();

                p.setName(productName);
                p.setDescription(productDescription);
                p.setValue(productValue);

                //Verifying if it was succeeded or not
                boolean productCreated = dao.insert(p);

                if(productCreated) message = "Produto criado com sucesso!";
                else message = "Ocorreu um erro ao criar o produto...";

                req.setAttribute("operationStatus", productCreated);
                req.setAttribute("operationMessage", message);

                req.getRequestDispatcher("create-product.jsp").forward(req, res);
                break;

            case "update-product":

                //Getting the product before update
                int productCode = Integer.parseInt(code);
                boolean productUpdated;

                //Getting the input values
                String newProductName = req.getParameter("name");
                String newProductDescription = req.getParameter("description");
                BigDecimal newProductValue = BigDecimal.valueOf(Double.parseDouble(req.getParameter("value")));

                //Verifying if there's any empty inputs
                if(newProductName.isEmpty() || newProductDescription.isEmpty() || newProductValue.equals(BigDecimal.ZERO)){
                    productUpdated = false;
                    message = "Todos os campos devem estar preenchidos!";

                    req.setAttribute("operationStatus", productUpdated);
                    req.setAttribute("operationMessage", message);

                    req.getRequestDispatcher("update-product.jsp").forward(req, res);
                }

                Product productForUpdate = new Product(productCode, newProductName, newProductDescription, newProductValue);

                productUpdated = dao.update(productForUpdate);

                if(productUpdated) message = "Produto atualizado com sucesso!";
                else message = "Ocorreu um erro ao atualizar o produto...";

                req.setAttribute("operationStatus", productUpdated);
                req.setAttribute("operationMessage", message);

                req.getRequestDispatcher("update-product.jsp").forward(req, res);
                break;

            case "delete-product":

                int codeNumber = Integer.parseInt(code);

                //Verifying if this is a "delete all" or a "delete by code" request
                //It will be a "delete all" request if the codeNumber is 0
                if(codeNumber == 0){

                    boolean productsDeleted = dao.deleteAll();

                    //Verifying if the operation succeeded
                    if(productsDeleted) message = "Produtos excluídos com sucesso!";
                    else message = "Ocorreu um erro ao excluir os produtos...";

                    req.setAttribute("operationStatus", productsDeleted);
                    req.setAttribute("operationMessage", message);

                    req.getRequestDispatcher("delete-product.jsp").forward(req, res);

                }else{

                    boolean productDeleted = dao.deleteByCode(codeNumber);

                    //Verifying if the operation succeeded
                    if(productDeleted) message = "Produto excluído com sucesso!";
                    else message = "Ocorreu um erro ao excluir o produto...";

                    req.setAttribute("operationStatus", productDeleted);
                    req.setAttribute("operationMessage", message);

                    req.getRequestDispatcher("delete-product.jsp").forward(req, res);

                }

                break;

        }

    }

}
