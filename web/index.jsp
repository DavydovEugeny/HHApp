<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Отдел кадров</title>
</head>
<body>
<p>
  <c:url var="addImgUrl" value="/resources/img/add.png" />
  <c:url var="editImgUrl" value="/resources/img/edit.png" />
  <c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<h1><a href="${pageContext.servletContext.contextPath}/list">Отдел кадров</a></h1>
<c:if test="${!empty departments}">
  <table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#87CEEB">
    <tr>
      <th>ID отдела</th>
      <th>Название отдела</th>
      <th>Начальник</th>
      <th>Регион</th>
      <th colspan="3"></th>
      <th>Фамилия</th>
      <th>Имя</th>
      <th>Отчество</th>
      <th>Номер телефона</th>
      <th>Зарплата</th>
      <th colspan="2"></th>
    </tr>
    </thead>
    <tbody style="background:#ADD8E6">
    <c:forEach items="${departments}" var="department">
      <c:if test="${!empty department.employees}">
        <c:forEach items="${department.employees}" var="employee">
          <tr>
            <td>${department.id}</td>
            <td><a href="editDep?id=${department.id}">${department.namedep}</a></td>
            <td>${department.bossdep}</td>
            <td>${department.region}</td>
            <td><a href="editDep?id=${department.id}"><img src="${editImgUrl}"/></a></td>
            <td><a href="delDep?id=${department.id}"><img src="${deleteImgUrl}"/></a></td>
            <td><a href="addEmp?id_dep=${department.id}"><img src="${addImgUrl}"/></a></td>
            <td><a href="editEmp?id_emp=${employee.id}">${employee.lastname}</a></td>
            <td>${employee.firstname}</td>
            <td>${employee.middlename}</td>
            <td>${employee.phone}</td>
            <td>${employee.salary}</td>
            <td><a href="editEmp?id_emp=${employee.id}"><img src="${editImgUrl}"/></a></td>
            <td><a href="delEmp?id_emp=${employee.id}"><img src="${deleteImgUrl}"/></a></td>
          </tr>
        </c:forEach>
      </c:if>
      <c:if test="${empty department.employees}">
        <tr>
          <td>${department.id}</td>
          <td><a href="editDep?id=${department.id}">${department.namedep}</a></td>
          <td>${department.bossdep}</td>
          <td>${department.region}</td>
          <td><a href="editDep?id=${department.id}"><img src="${editImgUrl}"/></a></td>
          <td><a href="delDep?id=${department.id}"><img src="${deleteImgUrl}"/></a></td>
          <td><a href="addEmp?id_dep=${department.id}"><img src="${addImgUrl}"/></a></td>
          <td>N/A</td>
          <td>N/A</td>
          <td>N/A</td>
          <td>N/A</td>
          <td>N/A</td>
          <td></td>
          <td></td>
        </tr>
      </c:if>
    </c:forEach>
    </tbody>
  </table>
</c:if>
<p><a href="addDep">Добавить отдел</a></p>
<p><a href="addNewEmp">Добавить сотрудника</a></p>
<form action="searchDep">
  <p><label>Поиск по названию отдела</label>&nbsp;<input type="text" name="searchname">&nbsp;<input type="submit" value="Поиск"></p>
</form>
</body>
</html>

