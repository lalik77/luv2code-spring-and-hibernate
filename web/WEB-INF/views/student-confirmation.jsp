

<!DOCTYPE html>

<html>
<head>
    <title>  Confirmation- Page   </title>
</head>



<body>

<p> Student is confirmed  ${student.firstName}  ${student.lastName} </p>

<br>
<br>

Country : ${student.country}

<br>
<br>

Favorite Language : ${student.favoriteLanguage}

<a href="/">Back</a>

<br>
<br>

Operating Systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">


        <li> ${temp}</li>

    </c:forEach>

</ul>



</body>

</html>