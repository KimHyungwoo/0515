<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="exam.dao.*"%>
<%@ page import="exam.dto.*"%>
   
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String addr = request.getParameter("addr");
	
	MemberDAO dao = new MemberDAO();
	
	Member member = new Member();
	
	member.setId(id);
	member.setPass(pass);
	member.setName(name);
	member.setAge(Integer.parseInt(age));
	member.setGender(gender);
	member.setAddr(addr);
	
	// 3. SQL문 실행
	dao.insertMember(member);


%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>