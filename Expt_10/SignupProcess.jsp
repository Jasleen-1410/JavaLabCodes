<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@page import="java.sql.*,java.util.*"%>

<%
String name = request.getParameter("name");
String age = request.getParameter("age");
String occ = request.getParameter("occ");
String add = request.getParameter("add");
String username = request.getParameter("username");
String password = request.getParameter("password");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jas_LoginSystem",
                    "root", "12345");
    Statement st = con.createStatement();
    
	 int i = st.executeUpdate("Insert into User Values('" + name + "','" +age + "','" + 
	 	occ + "','" + add + "','" + username + "','" + password + "')");
	 
	 response.sendRedirect("SignupSuccess.html");
	} 

catch (Exception e) {
	 System.out.print(e);
	 e.printStackTrace();
	}
%>