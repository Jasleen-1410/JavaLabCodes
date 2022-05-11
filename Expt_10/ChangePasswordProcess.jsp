<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>

<%
String username =request.getParameter("username");
String currentPassword=request.getParameter("current");
String newpass =request.getParameter("newpass");
String confirmpass =request.getParameter("confirm");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jas_LoginSystem",
                "root", "12345");
Statement st = con.createStatement();

String password="";

try{
	ResultSet rs = st.executeQuery("Select * from User where UserName='" + username + "' and Password='" + currentPassword + "'");

	while(rs.next()){
		password=rs.getString("password");
	}
	
	if(password.equals(currentPassword)){
		if(newpass.equals(confirmpass)){
		    Statement st1=con.createStatement();
			int i=st1.executeUpdate("Update User set Password='"+newpass+"' where UserName='"+username+"'");
			response.sendRedirect("PasswordChanged.html");
			st1.close();
			con.close();
		}
		else{
			out.println("Invalid Confirm Password");
		}
	}
	else{
		out.println("Invalid Current Password");
	}
}
catch(Exception e){
	out.println(e);
}
%>