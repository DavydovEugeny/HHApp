<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Редактирование отдела</title>
</head>
<body>
<h1>Редактирование отдела</h1>
<form method="post" action="editDep">
  <table>
    <tr>
      <td><label>ID</label> </td>
      <td> <input type="text" name="iddep" value="${department.iddep}" readonly/></td>
    </tr>
    <tr>
      <td><label>Название отдела</label> </td>
      <td><input type="text" name="namedep" value="${department.namedep}" required/></td>
    </tr>
    <tr>
      <td><label>Начальник</label> </td>
      <td><input type="text" name="bossdep" value="${department.bossdep}"/></td>
    </tr>
    <tr>
      <td><label>Регион</label> </td>
      <td><input type="text" name="region" value="${department.region}" required/></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Сохранить изменения"></td>
    </tr>
  </table>
</form>
</body>
</html>