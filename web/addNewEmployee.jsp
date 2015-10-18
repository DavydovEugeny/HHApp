<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление нового сотрудника</title>
</head>
<body>
<h1>Добавление нового сотрудника</h1>
<form action="addNewEmp" method="post">
  <table>

    <tr>
      <td><label for="lname">Фамилия</label></td>
      <td><input type="text" name="lastname" id="lname" required/></td>
    </tr>

    <tr>
      <td><label for="fname">Имя</label></td>
      <td><input type="text" name="firstname" id="fname" required/></td>
    </tr>

    <tr>
      <td><label for="mname">Отчество</label></td>
      <td><input type="text" name="middlename" id="mname"/></td>
    </tr>

    <tr>
      <td><label for="phoneNumber">Номер телефона</label></td>
      <td><input type="text" name="phone" placeholder="+7 (xxx) xxx-xxxx" id="phoneNumber" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$"/></td>
    </tr>

    <tr>
      <td><label for="sal">Зарплата</label></td>
      <td><input type="text" name="salary"  placeholder="xxxxx.xx" id="sal" pattern="\d*\.?\d+"/></td>
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
      <td colspan="2"><input type="submit" value="Добавить сотрудника"></td>
    </tr>
  </table>

</form>
</body>
</html>