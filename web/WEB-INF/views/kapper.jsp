<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Kapper page</title>
</head>

<body>
<h1>Страница каппера</h1>
<nav>
    <ul>
        <li><a href="/">Главная</a></li>
        <li><a>Каппер</a></li>
        <li><a href="/userpage">Пользователь</a></li>
        <li><a href="/admin">Админ</a></li>
        <li><a href="/about">О проекте</a></li>
        <li><a href="/contacts">Контакты</a></li>
        <li><a href="/privatepage">Личный кабинет</a></li>
    </ul>
</nav>

<br>

${userJSP}


</body>

</html>
