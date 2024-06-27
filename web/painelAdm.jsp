<%-- 
    Document   : painelAdm
    Created on : 20/06/2024, 18:32:25
    Author     : Root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <link rel="stylesheet" href="painelAdm.css" />
    <title>Painel Adm</title>
</head>

<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="bi bi-person-circle me-2"></i>Acesso Adm</div>
            <div class="list-group list-group-flush my-3">



                <a href="listar_funcionario.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="bi bi-people-fill me-2"></i>Funcionarios</a>

                        <a href="listar_item.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                class="bi bi-basket3-fill me-2"></i>Produtos</a>

                <a href="carrinho.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="bi bi-cart4 me-2"></i>Pedidos</a>

                        <a href="listar_mesa.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-chair me-2"></i>Mesas</a>

                <a href="#" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown"
                                role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-user me-2"></i>adm
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

                                <li><a class="dropdown-item" href="#">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="container-fluid px-4">
                <div class="row g-3 my-2">
                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>

                                <p class="fs-7">Funcionarios</p>
                            </div>
                            <i class="bi bi-people-fill fs-1 primary-text border rounded-full secondary-bg p-0"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>

                                <p class="fs-7">Produtos</p>
                            </div>
                            <i class="bi bi-basket3-fill fs-1 primary-text border rounded-full secondary-bg p-0"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>

                                <p class="fs-7">Pedidos</p>
                            </div>
                            <i class="bi bi-cart4 fs-1 primary-text border rounded-full secondary-bg p-0"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>

                                <p class="fs-7">Mesas</p>
                            </div>
                            <i class="fas fa-chair fs-1 primary-text border rounded-full secondary-bg p-2"></i>
                        </div>
                    </div>


                </div>
                <title>Cadastro de Funcionario</title>
                <style>
                    body {
                        font-family: sans-serif;
                        margin: 20px;
                    }

                    label {
                        display: block;
                        margin-bottom: 5px;
                    }

                    input[type="text"],
                    input[type="date"] {
                        width: 100%;
                        padding: 5px;
                        border: 1px solid #ccc;
                        border-radius: 3px;
                    }

                    button {
                        background-color: #4CAF50;
                        /* Green */
                        color: white;
                        padding: 10px 20px;
                        border: none;
                        border-radius: 4px;
                        cursor: pointer;
                    }
                </style>
                </head>

                <body>
                    <!--Crud-->
            </div>
        </div>
        </form>

    </div>
    </div>
    </div>

    </div>
    <!--JAVA SCRIPT-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };
    </script>
</body>

</html>
