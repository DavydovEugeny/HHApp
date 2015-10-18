package com.edavydov.HHApp.controller;

import com.edavydov.HHApp.domain.Department;
import com.edavydov.HHApp.repository.DataRep;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDep")
public class AddDepartment extends HttpServlet {

    @EJB
    DataRep dataRep;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Department department = new Department();
        department.setBossdep(request.getParameter("bossdep"));
        department.setNamedep(request.getParameter("namedep"));
        department.setRegion(request.getParameter("region"));
        dataRep.addDep(department);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/list"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("department", new Department());
        request.getRequestDispatcher("addDepartment.jsp").forward(request, response);
    }
}
