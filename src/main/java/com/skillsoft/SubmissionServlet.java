package com.skillsoft;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/booksubmitconfirm")
public class SubmissionServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String bName = (String)req.getAttribute("updatedBName");

        String author = (String)req.getAttribute("updatedAuthor");

        PrintWriter out = res.getWriter();
        out.println("Information Submitted Successfully");
        out.println("Book Title: " + bName);
        out.println("Book Author: " + author);
    }
}
