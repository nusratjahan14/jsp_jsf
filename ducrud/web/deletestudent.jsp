<%-- 
    Document   : deletestudent
    Created on : Aug 12, 2024, 12:41:21 PM
    Author     : Dell New
--%>

<jsp:useBean class="model.Student" id="e" />
<%@page import="dao.StudentDao" %>
<jsp:setProperty name="e" property="*" />

<%
    StudentDao.deleteData(e);
    response.sendRedirect("viewallstudent.jsp");

%>
