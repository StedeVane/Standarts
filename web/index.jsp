<%@ page import="ru.mzema.standards.DataBase" %>
<%@ page import="ru.mzema.standards.Document" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.print.Doc" %><%--
  Created by IntelliJ IDEA.
  User: Крочак
  Date: 08.12.2017
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>



  <table>
    <%--<jsp:useBean id="listResults" class="java.util.ArrayList" scope="request"/>--%>
    <%
//      request.setAttribute("listResult", DataBase.getDocumentList());
      List<Document> list = DataBase.getDocumentList();
      for (Document doc : list) {
        out.println("<tr>");
        out.println("<td>"+doc.id+"</td>");
        out.println("<td>"+"<a href=http://192.168.0.30:8080/download?id="+doc.id+">" + doc.name+"</a>"+"</td>");
        out.println("</tr>");
      }
    %>

  </table>

  </body>
</html>
