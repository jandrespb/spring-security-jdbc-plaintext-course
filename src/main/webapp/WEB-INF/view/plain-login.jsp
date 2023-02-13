<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
      .failed {
         color: red;
      }
    </style>
</head>
<body>
   <h3>My Custom Login Page with Styles</h3>
   <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
      <!--
    * /authenticateTheUser === proviene de la clase DemoSecurityConfig.java
    * en las etiquetas input, el name="username" y password="password" deben ir con ese nombre porque es un id propio de spring security
   -->
   
      <!--Check for login error-->
   <c:if test="${param.error != null}">
      <i class="failed">Sorry! You entered invalid username/password.</i>
   </c:if>
   
   <p>User name: <input type="text" name="username" /></p>
   <p>Password:<input type="password" name="password" /></p>

   <input type="submit" value="Login" />
   </form:form>
</body>