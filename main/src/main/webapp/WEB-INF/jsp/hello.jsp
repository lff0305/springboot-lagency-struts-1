<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is a simple jsp page.</title>
</head>
<body>

    Struts Bean value = <bean:write name="testForm" property="value"/> </br>
    Test &lt;%= ... %&gt; Tag: </br>
    System currentMillis = <%= System.currentTimeMillis()  %> </br>

    Test &lt;% ... %&gt; Tag: </br>
    <%
        response.getWriter().flush();
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            out.println(key + " - " + Arrays.toString(map.get(key)));
        }
    %>
</body>
</html>
