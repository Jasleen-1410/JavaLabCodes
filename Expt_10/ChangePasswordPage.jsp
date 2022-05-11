<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Performed By: Jasleen Minhas / 20BCS6897 -->
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
<title>Jas Change Password Page</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <center>
        <H2>Welcome to Jas Login System</H2>

        <div class="container">
            <H4>CHANGE PASSWORD</H4>
            <form action="ChangePasswordProcess.jsp" method="post">
            
                User Name: <input type="text" name="username" />
                <br><br>
                Current Password: <input type="password" name="current" />
                <br><br>
                New Password: <input type="password" name="newpass" />
                <br><br>
                Confirm Password: <input type="password" name="confirm" />
                <br><br>
                <input type="submit" value="Change Password" class="btn" style="width: 200px;"/>
            </form>
    </center>
    </div>

    <br><br>
</body>

</html>