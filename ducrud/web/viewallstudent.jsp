<%-- 
    Document   : viewallstudent
    Created on : Aug 12, 2024, 12:30:04 PM
    Author     : Dell New
--%>

<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>

<%
    List<Student> list = StudentDao.viewAllData();
    request.setAttribute("vaList", list);

%>

<table border="1" style="width:70%; font-size: 20px; margin-left: auto; margin-right: auto">
    <caption>Employee Details</caption>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Mobile</th>
            
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <e:forEach var="l" items="${vaList}">
            <tr>
                <td>${l.getId()}</td>
                <td>${l.getName()}</td>
                <td>${l.getEmail()}</td>
                <td>${l.getAddress()}</td>
                <td>${l.getCellNo()}</td>
                
                <td>
                    <a href="updatedataform.jsp?id=${l.getId()}">Edit</a>
                    <a href="deletestudent.jsp?id=${l.getId()}">Delete</a>
                </td>
            </tr>
        </e:forEach>
    </tbody>
</table>

<a href="home.jsp">Back to Home Page</a>