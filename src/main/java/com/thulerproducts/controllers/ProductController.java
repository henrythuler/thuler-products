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

@WebServlet("/products")
public class ProductController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        DAO<Product> dao = new ProductDAO();

        HttpSession session = req.getSession();

        session.setAttribute("products", dao.getAll());

        req.getRequestDispatcher("pages/products.jsp").forward(req, res);

    }

}
