<!-- Performed By: Jasleen Minhas / 20BCS6897 -->
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Jas Signup Success</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <center>
        <H2>Welcome to Jas Login System</H2>

        <div class="container">
            
            <h1> Welcome <%String username =request.getParameter("username"); out.println(username); %> </h1>
            
            <H4>You Successfully Logged In!!!</H4>
            <Br>

           <h5>Change Password?
                <a href="ChangePasswordPage.jsp">Click Here to Change Password</a>
            </h5>
            <h5>Want to Log out?
                <a href="LoginPage.html">Click Here to Log Out</a>
            </h5>
    </center>
    </div>

    <br><br>
</body>

</html>