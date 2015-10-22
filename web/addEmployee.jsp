<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление сотрудника</title>
</head>
<body>
<h1>Добавление сотрудника в отдел</h1>
<form action="addEmp" method="post">
  <table>

    <tr>
      <td><label for="iddep">ID отдела</label> </td>
      <td><input type="text" name="department" id="iddep" value="${employee.department.iddep}" readonly/></td>
    </tr>

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
      <td><input type="text" name="salary"  placeholder="xxxxx.xx" id="sal" pattern="[0-9]+([,.][0-9]{1,2})?"/></td>
    </tr>

    <tr>
      <td colspan="2"><input type="submit" value="Добавить сотрудника"></td>
    </tr>
  </table>

</form>
</body>
</html>