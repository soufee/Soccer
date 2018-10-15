<%--
  Created by IntelliJ IDEA.
  User: Ashamaz
  Date: 08.10.2018
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Контактная информация</title>
</head>
<body>
Контактная информация
<nav>
	<ul>
		<li><a href="/">Главная</a></li>
		<li><a href="/kapper">Каппер</a></li>
		<li><a href="/userpage">Пользователь</a></li>
		<li><a href="/admin">Админ</a></li>
		<li><a href="/about">О проекте</a></li>
		<li><a>Контакты</a></li>
		<li><a href="/privatepage">Личный кабинет</a></li>
	</ul>
</nav>

<br>

${userJSP}
${contacts}



</body>
</html>
