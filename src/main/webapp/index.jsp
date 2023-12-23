<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>

        <title>Thuler Products</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="assets/styles/style.css">
        <link rel="stylesheet" href="assets/styles/home.css">

    </head>

    <body class="d-flex justify-content-center align-items-center">

        <div class="container text-light p-2 d-flex flex-column align-items-center px-1 py-5">

            <h1 class="fs-1 text-center mb-4">Bem-vindo ao Thuler Products</h1>

            <div class="w-75 cards">

                <div class="justify-content-center row row-cols-3 row-gap-3 column-gap-3">

                    <a href="products" class="col px-4 py-3 border border-light rounded text-decoration-none text-center d-flex flex-column justify-content-center card card-transition">

                        <i class="fa-solid fa-table mb-2 fs-1"></i>

                        <h2>Listar Produtos</h2>

                    </a>

                    <a href="search-product.jsp" class="col px-4 py-3 border border-light rounded text-decoration-none text-center d-flex flex-column justify-content-center card card-transition">

                        <i class="fa-solid fa-magnifying-glass mb-2 fs-1"></i>

                        <h2>Buscar Produto</h2>

                    </a>

                    <a href="create-product.jsp" class="col px-4 py-3 border border-light rounded text-decoration-none text-center d-flex flex-column justify-content-center card card-transition">

                        <i class="fa-solid fa-download mb-2 fs-1"></i>

                        <h2>Criar Novo Produto</h2>

                    </a>

                    <a href="#" class="col px-4 py-3 border border-light rounded text-decoration-none text-center d-flex flex-column justify-content-center card card-transition">

                        <i class="fa-solid fa-pen-to-square mb-2 fs-1"></i>

                        <h2>Editar Produto</h2>

                    </a>

                    <a href="delete-product.jsp" class="col px-4 py-3 border border-light rounded text-decoration-none text-center d-flex flex-column justify-content-center card card-transition">

                        <i class="fa-solid fa-trash mb-2 fs-1"></i>

                        <h2>Excluir Produto</h2>

                    </a>

                    <a href="#" class="col px-4 py-3 border border-light rounded text-decoration-none text-center d-flex flex-column justify-content-center card card-transition">

                        <i class="fa-solid fa-eraser mb-2 fs-1"></i>

                        <h2>Apagar Todos Produtos</h2>

                    </a>

                </div><!--Row-->

            </div>

        </div>

        <%@ include file="./snippets/footer.html"%>

    </body>

</html>
