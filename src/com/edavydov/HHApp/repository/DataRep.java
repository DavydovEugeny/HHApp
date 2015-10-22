package com.edavydov.HHApp.repository;

import com.edavydov.HHApp.domain.Department;
import com.edavydov.HHApp.domain.Employee;
import com.edavydov.HHApp.utils.ConnectionJDBC;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DataRep {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String query;

    public List<Department> listAllDep(){
        List<Department> departments = new ArrayList<Department>();
        try {
            query = "SELECT * FROM hr.departments";
            connection = ConnectionJDBC.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Department department = new Department();
                department.setIddep(resultSet.getInt("id_dep"));
                department.setBossdep(resultSet.getString("bossdep"));
                department.setNamedep(resultSet.getString("namedep"));
                department.setRegion(resultSet.getString("region"));
                departments.add(department);
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                resultSet = null;
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                statement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
        return departments;
    }

    public void removeDep(Integer id){
        try {
            query = "DELETE FROM hr.departments WHERE id_dep=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public void editDep(Department department){
        try {
            query = "UPDATE hr.departments SET bossdep=?, namedep=?, region=? WHERE id_dep=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getBossdep());
            preparedStatement.setString(2, department.getNamedep());
            preparedStatement.setString(3, department.getRegion());
            preparedStatement.setInt(4, department.getIddep());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }  finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public void addDep(Department department){
        try {
            query = "INSERT INTO hr.departments VALUES (NULL, ?,?,?)";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getBossdep());
            preparedStatement.setString(2, department.getNamedep());
            preparedStatement.setString(3, department.getRegion());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public Department getDep(Integer id){
        Department department = new Department();
        try {
            query = "SELECT * FROM hr.departments WHERE id_dep=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                department.setIddep(resultSet.getInt("id_dep"));
                department.setBossdep(resultSet.getString("bossdep"));
                department.setNamedep(resultSet.getString("namedep"));
                department.setRegion(resultSet.getString("region"));
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                resultSet = null;
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
        return department;
    }

    public List<Employee> getAllEmp(Integer departmentId){
        List<Employee> employees = new ArrayList<>();
        try {
            query = "SELECT * FROM hr.employees WHERE id_dep=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, departmentId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id_em"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                employee.setMiddlename(resultSet.getString("middlename"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setSalary(resultSet.getString("salary"));
                employees.add(employee);
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                resultSet = null;
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
        return employees;
    }

    public List<Employee> getAllEmp(){
        List<Employee> employees = new ArrayList<>();
        try {
            query = "SELECT * FROM hr.employees";
            connection = ConnectionJDBC.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id_em"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                employee.setMiddlename(resultSet.getString("middlename"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setSalary(resultSet.getString("salary"));
                employee.setDepartment(getDep(resultSet.getInt("department_id")));
                employees.add(employee);
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                resultSet = null;
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                statement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
        return employees;
    }

    public Employee getEmp(Integer id){
        Employee employee = new Employee();
        try {
            query = "SELECT * FROM hr.employees WHERE id_em=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employee.setId(resultSet.getInt("id_em"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                employee.setMiddlename(resultSet.getString("middlename"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setSalary(resultSet.getString("salary"));
                employee.setDepartment(getDep(resultSet.getInt("department_id")));
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                resultSet = null;
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
        return employee;
    }

    public void addEmp(Employee employee){
        try {
            query = "INSERT INTO hr.employees VALUES (NULL, ?,?,?,?,?,?)";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getMiddlename());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getDepartment().getIddep());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public void removeEmp(Integer id){
        try {
            query = "DELETE FROM hr.employees WHERE id_em=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public void removeAllEmp(Integer idDep){
        try {
            query = "DELETE FROM hr.employees WHERE id_dep=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idDep);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public void editEmp(Employee employee){
        try {
            query = "UPDATE hr.employees SET firstname=?, lastname=?, middlename=?, phone=?, salary=?, id_dep=? WHERE id_em=?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getMiddlename());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getDepartment().getIddep());
            preparedStatement.setInt(7, employee.getId());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public List<Department> searchDep(String name){
        List<Department> departments = new ArrayList<>();
        try {
            query = "SELECT * FROM hr.departments WHERE namedep LIKE ?";
            connection = ConnectionJDBC.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+name+"%");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Department department = new Department();
                department.setIddep(resultSet.getInt("id_dep"));
                department.setBossdep(resultSet.getString("bossdep"));
                department.setNamedep(resultSet.getString("namedep"));
                department.setRegion(resultSet.getString("region"));
                departments.add(department);
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                resultSet = null;
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                preparedStatement = null;
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
                connection = null;
            }
        }
        return departments;
    }
}
