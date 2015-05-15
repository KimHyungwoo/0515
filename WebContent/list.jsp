<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="exam.dao.*"%>
<%@ page import="exam.dto.*"%>
<%@ page import="exam.dao.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원리스트</h1>
<hr>
<%

	MemberDAO dao = new MemberDAO();
	List<Member> list = dao.listMember();	
%>

	<table border="1">
	  <tr>
	  	 <th>아이디</th>
	  	 <th>이름</th>
	  </tr>
	  <%
	  	 for(int i=0; i<list.size(); i++) {
	  
	  		Member m = list.get(i);
	  %>
	  	 <tr>
	  	 	<td><%= m.getId() %></td>
	  	 	<td><%= m.getName() %></td>
	  	 </tr>
	  <% 
	  	 }
	  
	  %>
	  	 
	</table>
</body>
</html>