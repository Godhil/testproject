<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Пользователи</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
        body {
            background-color: #eee;
            font: helvetica;
        }

        #container {
            width: 70%;
            background-color: #fff;
            margin: 30px auto;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 5px;
        }

        label {
            width: 70px;
            display: inline-block;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<div id="container">

    <button id="newUser"> Новый пользователь</button>
    <br/>

    <h1>Пользователи</h1>

    <h2>Список пользователей</h2>

    <table id="users">
        <thead>
        <tr>
            <th>Id</th>
            <th>Логин</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Роль</th>
            <th>Муниципальное образование</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <hr/>
</div>


<script type="text/javascript">
    $(document).ready(function () {

        $.getJSON('${pageContext.request.contextPath}/api/userlist', function (user) {

            $.each(user, function (i, item) {
                var $tr = $('<tr>').append(
                        $('<td>').text(item.id),
                        $('<td>').text(item.login),
                        $('<td>').text(item.surname),
                        $('<td>').text(item.firstName),
                        $('<td>').text(item.secondName),
                        $('<td>').text(item.role),
                        $('<td>').text(item.municipality.name),
                        $('<td>')
                                .text('Редактировать')
                                .css("color", "blue")
                                .click(function (e) {
                                    location.href = '/user/edit/' + item.id;
                                }),
                        $('<td>')
                                .text('Удалить')
                                .css("color", "blue")
                                .click(function (e) {
                                    $.get('${pageContext.request.contextPath}/api/user/delete/' + item.id, function () {
                                        alert('Пользователь: ' +
                                                'id: ' + item.id +
                                                'Логин: ' + item.login +
                                                ' удален');
                                        location.reload();
                                    });
                                })
                ).appendTo('#users');
            });
        });

        $('#newUser').click(function () {
            location.href = '/newuser'
        });

    });

</script>

</body>
</html>
