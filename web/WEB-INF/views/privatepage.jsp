<%--
  Created by IntelliJ IDEA.
  User: Ashamaz
  Date: 05.10.2018
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Личный кабинет</title>
</head>
<body>
Личный кабинет
<nav>
	<ul>
		<li><a href="/">Главная</a></li>
		<li><a href="/kapper">Каппер</a></li>
		<li><a href="/userpage">Пользователь</a></li>
		<li><a href="/admin">Админ</a></li>
		<li><a href="/about">О проекте</a></li>
		<li><a href="/contacts">Контакты</a></li>
		<li><a>Личный кабинет</a></li>
	</ul>
</nav>

<br>

${userJSP}

</body>
</html>
