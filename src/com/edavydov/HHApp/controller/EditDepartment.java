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

@WebServlet("/editDep")
public class EditDepartment extends HttpServlet {

    @EJB
    DataRep dataRep;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();
        department.setIddep(Integer.valueOf(request.getParameter("iddep")));
        department.setBossdep(request.getParameter("bossdep"));
        department.setNamedep(request.getParameter("namedep"));
        department.setRegion(request.getParameter("region"));
        dataRep.editDep(department);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/list"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iddep = Integer.valueOf(request.getParameter("id"));
        Department dep = dataRep.getDep(iddep);
        request.setAttribute("department", dep);
        request.getRequestDispatcher("editDepartment.jsp").forward(request, response);
    }
}
