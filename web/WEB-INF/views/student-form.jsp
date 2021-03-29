<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>  Student - Input Form    </title>
</head>



<body>

<form:form action="processform" modelAttribute="student" >

    First name: <form:input path="firstName"/>
    <br>
    <br>
    Last name : <form:input path="lastName"/>
    <br>
    <br>

    Country :
    <form:select path="country" >

        <form:options items="${student.countryOptions}"/>


    </form:select>

    <br>
    <br>

    Favorite Language :
    Java<form:radiobutton path="favoriteLanguage" value="Java"/>
    C#<form:radiobutton path="favoriteLanguage" value="C#"/>
    PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
    Python<form:radiobutton path="favoriteLanguage" value="Python"/>
    Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>

    <br>
    <br>

    Operating Systems :
    <br>
    Linux      <form:checkbox path="operatingSystems"  value="Linux"/>
    Mac OS     <form:checkbox path="operatingSystems"  value="Mac"/>
    MS Windows <form:checkbox path="operatingSystems"  value="MS Windwos"/>


    <input type="submit" value="Submit">


</form:form>


</body>

</html>