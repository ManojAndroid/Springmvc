<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

<title>Spring MVC form submission</title>
</head>
<body>
<center>
    <h2>Fill your form!</h2>

    <form:form method="POST" commandName="form" action="Register">
        <table>
            <tr>
                <td>Enter your name:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssStyle="color: #ff0000;"></form:errors></td>
            </tr>
            <tr>
                <td>Enter your lastname:</td>
                <td><form:input path="lastname" /></td>
                <td><form:errors path="lastname" cssStyle="color: #ff0000;" ></form:errors></td>
            </tr>
            <tr>
                <td>Enter your password:</td>
                <td><form:input path="password" /></td>
                <td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
            </tr>
           <%--  <tr>
                <td>Re-Enter your password:</td>
                <td><form:input path="confirmpassword" /></td>
                <td><form:errors path="confirmpassword" cssStyle="color: #ff0000;" /></td>
            </tr> --%>
            <tr>
                <td>Enter your zip:</td>
              <td><form:input path="zip" /></td>
              <td><form:errors path="zip" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr>
                <td>Enter your email:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr>
                <td>Enter your age:</td>
                <td><form:input path="age" /></td>
                <td><form:errors path="age" cssStyle="color: #ff0000;" /></td>
          </tr>
            <tr>
                <td><input type="submit" name="submit" value="Submit"></td>
            </tr>
            <tr>
        </table>
    </form:form>
    </center>
</body>
</html>
