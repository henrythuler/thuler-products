<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pt-br">

    <head>

        <title>Thuler Products</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

        <link rel="stylesheet" href="assets/styles/style.css">
        <link rel="stylesheet" href="assets/styles/table.css">
        <link rel="stylesheet" href="assets/styles/app.css">

    </head>

    <body>

        <div class="main-container d-flex p-3 column-gap-3">

            <%@ include file="snippets/sidebar.html"%>

            <div class="table-responsive-xl app-container">

                <%@ include file="snippets/header.html"%>

                <table class="products-table w-100">

                    <thead>

                        <tr class="text-center border-bottom border-light fw-bold fs-4">
                            <td class="p-1">Código</td>
                            <td class="p-1">Nome</td>
                            <td class="p-1">Descrição</td>
                            <td class="p-1">Valor</td>
                        </tr>

                    </thead>

                    <tbody>

                    <c:forEach var="p" items="${products}">

                        <tr class="text-center border-bottom border-light fs-5">
                            <td>${p.getCode()}</td>
                            <td class="p-4">${p.getName()}</td>
                            <td class="p-4">${p.getDescription()}</td>
                            <td class="p-4">R$${p.getValue()}</td>
                        </tr>

                    </c:forEach>

                    </tbody>

                </table>

            </div>

        </div>

        <%@ include file="snippets/footer.html"%>

    </body>

</html>
