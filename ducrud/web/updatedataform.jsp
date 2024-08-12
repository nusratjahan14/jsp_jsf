<%-- 
    Document   : updatedataform
    Created on : Aug 12, 2024, 12:49:11 PM
    Author     : Dell New
--%>

<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>

<%
    String id =request.getParameter("id");
    Student e =StudentDao.getById(Integer.parseInt(id));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee Update Form</h1>
        
        <form action="updatedata.jsp" method="post">
            <input type="hidden" name="id" value="<%=e.getId() %>">
            
            Name: <input type="text" name="name" value="<%=e.getName() %>"> <br>
            Email: <input type="email" name="email" value="<%=e.getEmail() %>"> <br>
            Address: <input type="text" name="address" value="<%=e.getAddress() %>"> <br>
            Mobile No: <input type="number" name="cellNo" value="<%=e.getCellNo() %>"> <br>
            
            
            <br>
            <input style="background-color: red" type="submit" value="Update">
            
        </form>
    </body>
</html>
