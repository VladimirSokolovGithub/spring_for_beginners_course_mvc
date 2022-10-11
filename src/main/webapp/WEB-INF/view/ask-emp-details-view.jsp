<!DOCTYPE html>
<html>

<body>

<h2>Dear Employee? please enter your details</h2>

<br>
<br>

<form action="${pageContext.request.contextPath}/showDetails" method="get">
    <input type="text" name="employeeName"
    placeholder="Write your name"/>

    <input type="submit"/>
</form>

</body>

</html>