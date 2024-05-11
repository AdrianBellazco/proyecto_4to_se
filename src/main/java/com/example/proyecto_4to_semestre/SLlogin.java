package com.example.proyecto_4to_semestre;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/login")
public class SLlogin extends HttpServlet {
    private String message;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        if(user.equals("admin") && pass.equals("123")){
            String pagina = "HTML/system.xhtml";
            request.getRequestDispatcher(pagina).forward(request, response);

        }else {
            response.sendRedirect("index.xhtml");
        }
    }

    public void destroy() {
    }
}