<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Редактирование сотрудника</title>
</head>
<body>
<h1>Редактирование сотрудника</h1>
<form action="editEmp" method="post">
  <table>
    <tr>
      <td><label for="idemp">ID сотрудника</label> </td>
      <td> <input type="text" name="id" id="idemp" value="${employee.id}" readonly/></td>
    </tr>
    <tr>
      <td><label for="lname">Фамилия</label> </td>
      <td><input type="text" name="lastname" id="lname" value="${employee.lastname}" required/></td>
    </tr>
    <tr>
      <td><label for="fname">Имя</label> </td>
      <td><input type="text" name="firstname" id="fname" value="${employee.firstname}" required/></td>
    </tr>
    <tr>
      <td><label for="mname">Отчество</label> </td>
      <td><input type="text" name="middlename" id="mname" value="${employee.middlename}"/></td>
    </tr>
    <tr>
      <td><label for="phoneNumber">Номер телефона</label> </td>
      <td><input type="text" name="phone" id="phoneNumber" value="${employee.phone}" placeholder="+7 (xxx) xxx-xxxx" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$"/></td>
    </tr>
    <tr>
      <td><label for="salary">Зарплата</label> </td>
      <td><input type="text" name="salary" id="salary" value="${employee.salary}" placeholder="xxxxx.xx" pattern="[0-9]+([,.][0-9]{1,2})?"/></td>
    </tr>
    <tr>
      <td><label for="dep_id">Отдел</label></td>
      <td>
        <select id="dep_id" name="department.id" required>
          <option value="">-</option>
          <c:forEach items="${departments}" var="department">
            <option value="${department.iddep}">${department.namedep}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Сохранить изменения"></td>
    </tr>
  </table>
</form>
</body>
</html>