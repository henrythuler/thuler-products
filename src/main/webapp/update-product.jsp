<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Thuler Products</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <link rel="stylesheet" href="assets/styles/style.css">

</head>

<body>

<div class="main-container d-flex p-3 column-gap-3">

    <%@ include file="snippets/sidebar.html"%>

    <div class="app-container">

        <%@ include file="snippets/header.html"%>

        <form class="d-flex flex-column justify-content-center align-items-center py-5 w-100" method="POST" action="products">

            <c:if test='${operationMessage != null}'>

                <c:if test="${operationStatus}">

                    <div class="alert alert-success">
                            ${operationMessage}
                    </div>

                </c:if>

                <c:if test="${!operationStatus}">

                    <div class="alert alert-danger">
                            ${operationMessage}
                    </div>

                </c:if>

            </c:if>

            <c:if test="${product != null}">

                <h2 class="text-light mb-4">Editar produto</h2>

                <div class="input-container d-flex flex-column column-gap-3 mb-5 fs-5">

                    <label class="mb-1" for="name">Nome</label>
                    <input required class="form-control" type="text" name="name" id="name" value="${product.getName()}">

                </div>

                <div class="input-container d-flex flex-column column-gap-3 mb-5 fs-5">

                    <label class="mb-1" for="description">Descrição</label>
                    <input required class="form-control" type="text" name="description" id="description" value="${product.getDescription()}">

                </div>

                <div class="input-container d-flex flex-column column-gap-3 mb-5 fs-5">

                    <label class="mb-1" for="value">Valor</label>
                    <input required class="form-control" type="number" step="0.01" name="value" id="value" value="${product.getValue()}">

                </div>

                <!--Request type input-->
                <input type="hidden" name="action" value="update-product">

                <!--Product code input-->
                <input type="hidden" name="code" value="${product.getCode()}">

                <input class="px-5 py-1 form-button border-0 rounded-4 fs-5" value="Editar" type="submit">

            </c:if>

        </form>

    </div>

</div>

<%@ include file="snippets/footer.html"%>

</body>

</html>

