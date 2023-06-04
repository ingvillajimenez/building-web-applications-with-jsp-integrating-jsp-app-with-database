package com.skillsoft;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/bookinfo")
public class BookInfoServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {

        String bname = req.getParameter("bname");

        String author = req.getParameter("author");

        req.setAttribute("updatedBName", bname.trim().toUpperCase());
        req.setAttribute("updatedAuthor", author.trim());

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/booksubmitconfirm.jsp");
        rd.forward(req, res);
    }
}
