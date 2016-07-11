<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Employee</title>
	  
  <link href="<c:url value="/resources/css/employee-css.css"/>" rel="stylesheet" type="text/css">
	  
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.0.0.js"/>"></script>
  
 </head>
 <body>
 
 <div class="employeeForm">
 <c:if test="${empty employee.id}">
 	<h2>Add Employee</h2>
 </c:if>
 <c:if test="${!empty employee.id}">
 	<h2>Update Employee</h2>
 </c:if>
  
  <c:url var="employeeAction" value ="/saveOrUpdateEmployee"/>
  <form:form method="POST" action="${employeeAction}" commandName="employee">
      <table align="center">
      <c:if test="${!empty employee.id}">
       <tr>
           <td><form:label path="id">Employee ID:</form:label></td>
           <td><form:input path="id" readonly="true"/></td>
       </tr>
       </c:if>
       <tr>
           <td><form:label path="firstName">First Name:</form:label></td>
           <td><form:input path="firstName"/></td>
       </tr>
       <tr>
           <td><form:label path="lastName">Last Name:</form:label></td>
           <td><form:input path="lastName" /></td>
       </tr>
       <tr>
           <td><form:label path="designation">Designation:</form:label></td>
           <td><form:input path="designation" /></td>
       </tr>
       
       <tr>
           <td><form:label path="companyName">Company:</form:label></td>
                    <td><form:input path="companyName"/></td>
       </tr>
          <tr>
          <c:if test="${empty employee.id}">
          	<td colspan="2"><input type="submit" value="Submit" id="addEmployee"/></td>
          </c:if>
          <c:if test="${!empty employee.id}">
          	<td colspan="2"><input type="submit" value="Update" id="updateEmployee"/></td>
          </c:if>
        </tr>
   </table> 
  </form:form>
  
  <c:if test="${!empty employeeList}">
  <h2>Employees List</h2>
 <table border="1" align="center" >
  <tr>
   <th>Employee ID</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Designation</th>
   <th>Company</th>
   <th>Actions</th>
  </tr>

  <c:forEach items="${employeeList}" var="employee">
   <tr>
    <td><c:out value="${employee.id}"/></td>
    <td><c:out value="${employee.firstName}"/></td>
    <td><c:out value="${employee.lastName}"/></td>
    <td><c:out value="${employee.designation}"/></td>
    <td><c:out value="${employee.companyName}"/></td>
    <td align="center"><a href="updateEmployee/${employee.id}">Edit</a> | <a href="deleteEmployee/${employee.id}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
</div>

<script type="text/javascript">
$(document).ready(function(){

});

</script>

 </body>
</html>