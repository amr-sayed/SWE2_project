<%@page import="com.FCI.SWE.ServicesModels.UserEntity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.FCI.SWE.Services.UserServices"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<String>a=UserServices.requsts;
%>

<%
for(int i=0;i<a.size();i++){
	out.println(a.get(i));
}
   %>
   
 <form action="/social/acceptRqust" method="post">
  Name : <input type="text" name="fname" /> <br>
   
  <input type="submit" value="Confirm">
  
  </form>
  
  
       
</body>
</html>