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

@WebServlet("/addEmp")
public class AddEmployee extends HttpServlet {

    @EJB
    DataRep dataRep;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setDepartment(dataRep.getDep(Integer.valueOf(request.getParameter("department"))));
        employee.setLastname(request.getParameter("lastname"));
        employee.setFirstname(request.getParameter("firstname"));
        employee.setMiddlename(request.getParameter("middlename"));
        employee.setPhone(request.getParameter("phone"));
        employee.setSalary(request.getParameter("salary"));
        dataRep.addEmp(employee);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/list"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iddep = Integer.valueOf(request.getParameter("id_dep"));
        Department department = dataRep.getDep(iddep);
        Employee employee = new Employee();
        employee.setDepartment(department);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
    }
}
