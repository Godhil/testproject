
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новый пользователь</title>
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
            width: 170px;
            display: inline-block;
        }

        .green { font-weight: bold; color: green; }
    </style>
</head>
<body>
<h2>Новый пользователь</h2>
<div id="container">
    <button id="returnToUserList">Список пользователей</button>
    <br/>
    <br/>
    <form id="userForm">
        <label for="loginInput">Логин: </label>
        <input type="text" name="login" id="loginInput" required="true"/>
        <br/>
        <label for="passInput">Пароль: </label>
        <input type="text" name="password" id="passInput" required="true"/>
        <br/>
        <label for="surnameInput">Фамилия: </label>
        <input type="text" name="surname" id="surnameInput" required="true"/>
        <br/>
        <label for="firstNameInput">Имя: </label>
        <input type="text" name="firstName" id="firstNameInput" required="true"/>
        <br/>
        <label for="secondNameInput">Отчество: </label>
        <input type="text" name="secondName" id="secondNameInput" required="true"/>
        <br/>
        <label for="roleInput">Роль: </label>
        <select id="roleInput" name="role">
            <option value="1">User</option>
            <option value="2">User2</option>
        </select>
        <br/>

        <div name="municipality">
            <label for="municipalityInput">Муниципальное образование: </label>
            <select name="municipality.id" id="municipalityInput"></select>
        </div>

        <br/>
        <input type="submit" value="Сохранить пользователя"/><br/><br/>
        <div id="formResponse" class="green"> </div>
    </form>
</div>
<script type="text/javascript">

    $(document).ready(function () {

        $.getJSON('${pageContext.request.contextPath}/api/municipalitylist', function (municipality) {
            $.each(municipality, function (i, municipality) {
                $('#municipalityInput')
                        .append($("<option></option>")
                                .attr("municipality",i)
                                .text(municipality.id));
            });
        });

        $('#userForm').submit(function (e) {
            $.post('${pageContext.request.contextPath}/api/user', $(this).serialize(), function (response) {
                $('#formResponse').text('Пользователь создан')
            });
            e.preventDefault();
        });

        $('#returnToUserList').click(function () {
            location.href = '/user';
        });
    });
</script>
</body>
</html>


