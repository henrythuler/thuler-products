<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>

        <title>Thuler Products</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="assets/styles/style.css">
        <link rel="stylesheet" href="assets/styles/table.css">

    </head>

    <body class="d-flex justify-content-center align-items-center">

        <div class="container">

            <table class="products-table">

                <thead>

                    <tr>
                        <td>Código</td>
                        <td>Nome</td>
                        <td>Descrição</td>
                        <td>Valor</td>
                    </tr>

                </thead>

                <tbody>

                    <c:forEach var="p" items="${products}">

                        <tr>
                            <td>${p.getCode()}</td>
                            <td>${p.getName()}</td>
                            <td>${p.getDescription()}</td>
                            <td>R$${p.getValue()}</td>
                        </tr>

                    </c:forEach>

                </tbody>

            </table>

        </div>

    </body>

</html>
