<%-- 
    Document   : updatedata
    Created on : Aug 12, 2024, 12:51:59 PM
    Author     : Dell New
--%>

<jsp:useBean class="model.Student" id="e" />
<%@page import="dao.StudentDao" %>
<jsp:setProperty name="e" property="*" />

<%
    StudentDao.updateData(e);
    response.sendRedirect("viewallstudent.jsp");

%>
