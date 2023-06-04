package com.skillsoft;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

@WebServlet(name = "info-servlet", urlPatterns = "/servletinfo")
public class ServletInfo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

        PrintWriter out = response.getWriter();
        out.write("Servlet details:");

        ServletConfig cfg = getServletConfig();
        out.write("\nServlet name: " + cfg.getServletName());

        out.write("\nConfig params: ");
        Iterator paramIterator = cfg.getInitParameterNames().asIterator();
        while (paramIterator.hasNext()) {
            out.write("\n" + paramIterator.next().toString());
        }

        out.write("\n\n****************\n\n");

        ServletContext ctx = getServletContext();
        out.write("Context name: " + ctx.getServletContextName());
        out.write("\nContext path: " + ctx.getContextPath());
        out.write("\nServer info: " + ctx.getServerInfo());

        out.write("\nAttributes: ");
        Iterator attIterator = ctx.getAttributeNames().asIterator();
        while (attIterator.hasNext()) {
            out.write("\n" + attIterator.next().toString());
        }

        out.write("\n\nContext params: ");
        paramIterator = ctx.getInitParameterNames().asIterator();
        while (paramIterator.hasNext()) {
            out.write("\n" + paramIterator.next().toString());
        }

        ctx.setAttribute("rootuser", "myadmin");
        out.write("\nAttribute rootuser: " + ctx.getAttribute("rootuser"));

    }
}
