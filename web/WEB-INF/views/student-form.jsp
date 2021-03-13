<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>  Hello world - Input Form    </title>
</head>



<body>

<<form:form action="processform" modelAttribute="student" >

    First name: <form:input path="firstName"/>
    <br>
    <br>
    Last name : <form:input path="lastName"/>
    <br>
    <br>
    <input type="submit" value="Submit">


</form:form>


</body>

</html>