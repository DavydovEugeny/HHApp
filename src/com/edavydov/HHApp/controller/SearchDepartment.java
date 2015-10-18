package com.edavydov.HHApp.controller;

import com.edavydov.HHApp.domain.Department;
import com.edavydov.HHApp.repository.DataRep;
import com.edavydov.HHApp.utils.DepEmpDTO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchDep")
public class SearchDepartment extends HttpServlet {

    @EJB
    DataRep dataRep;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String namedep = request.getParameter("searchname");
        List<Department> depList = dataRep.searchDep(namedep);
        List<DepEmpDTO> depEmpDTOs = new ArrayList<>();
        for (Department department : depList){
            DepEmpDTO dto = new DepEmpDTO();
            dto.setId(department.getIddep());
            dto.setNamedep(department.getNamedep());
            dto.setBossdep(department.getBossdep());
            dto.setRegion(department.getRegion());
            dto.setEmployees(dataRep.getAllEmp(department.getIddep()));
            depEmpDTOs.add(dto);
        }
        request.setAttribute("departments", depEmpDTOs);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

