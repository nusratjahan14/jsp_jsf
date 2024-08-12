<%-- 
    Document   : savestudent
    Created on : Aug 12, 2024, 12:02:44 PM
    Author     : Dell New
--%>

<jsp:useBean class="model.Student" id="s" />
<%@page import="dao.StudentDao" %>
<jsp:setProperty name="s" property="*" />


<%
    int i = StudentDao.saveData(s);
    
    if(i>0){
        response.sendRedirect("success.jsp");
    }
    else{
        response.sendRedirect("error.jsp");
    }

%>
