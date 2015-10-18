<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление отдела</title>
</head>
<body>
<h1>Добавление отдела</h1>
<form action="addDep" method="post">
  <table>
    <tr>
      <td><label for="name">Название отдела</label> </td>
      <td><input id="name" type="text" name="namedep" required/></td>
    </tr>
    <tr>
      <td><label for="boss">Начальник</label> </td>
      <td><input id="boss" type="text" name="bossdep"/></td>
    </tr>
    <tr>
      <td><label for="region">Регион</label> </td>
      <td><input id="region" type="text" name="region" required/></td>
    </tr>
    <tr>
      <td colspan="2"><button type="submit">Добавить отдел</button></td>
    </tr>
  </table>
</form>
</body>
</html>