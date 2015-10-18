package com.edavydov.HHApp.controller;

import com.edavydov.HHApp.repository.DataRep;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delEmp")
public class DeleteEmployee extends HttpServlet {

    @EJB
    DataRep dataRep;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idemp = Integer.valueOf(request.getParameter("id_emp"));
        dataRep.removeEmp(idemp);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/list"));
    }
}
