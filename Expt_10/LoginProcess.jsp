<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@page import="java.sql.*,java.util.*"%>

<%
String username = request.getParameter("username");
session.putValue("username", username);
String password = request.getParameter("password");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jas_LoginSystem",
                "root", "12345");
Statement st = con.createStatement();

ResultSet rs = st.executeQuery("Select * from User where UserName='" + username + "' and Password='" + password + "'");

try {
	 rs.next();
	 if (rs.getString("password").equals(password) && rs.getString("username").equals(username)) {
		 
		 RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");  
	     rd.forward(request, response);  
	 } else {
		 out.println("Invalid password or username.");
	 }
} 
catch (Exception e) {
 	e.printStackTrace();
}
%>

