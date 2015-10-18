package com.edavydov.HHApp.controller;

import com.edavydov.HHApp.domain.Department;
import com.edavydov.HHApp.domain.Employee;
import com.edavydov.HHApp.repository.DataRep;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addNewEmp")
public class AddNewEmployee extends HttpServlet {

    @EJB
    DataRep dataRep;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setDepartment(dataRep.getDep(Integer.valueOf(request.getParameter("department.id"))));
        employee.setLastname(request.getParameter("lastname"));
        employee.setFirstname(request.getParameter("firstname"));
        employee.setMiddlename(request.getParameter("middlename"));
        employee.setPhone(request.getParameter("phone"));
        employee.setSalary(request.getParameter("salary"));
        dataRep.addEmp(employee);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/list"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = dataRep.listAllDep();
        request.setAttribute("employee", new Employee());
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("addNewEmployee.jsp").forward(request, response);
    }
}
