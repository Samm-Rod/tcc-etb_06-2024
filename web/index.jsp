<%-- 
    Document   : index
    Created on : 20/06/2024, 15:59:34
    Author     : Root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pizzaria São Paulo</title>
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Open+Sans:wght@400;700&display=swap"
    rel="stylesheet">
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome para ícones -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="index.css">
</head>

<body>
  <img src="imgs/mapa-sao-paulo-em-branco.jpg" alt="Logo da Pizzaria São Paulo" class="logo">
  <div class="container mt-4">
    <div class="jumbotron text-center">
      <h1 class="display-4">Pizzaria São Paulo</h1>
      <p class="lead">Bem-vindo à nossa pizzaria, onde tradição e sabor se encontram!</p>
      <div class="social-icons">
        <a href="https://www.facebook.com/SaoPauloRestaurante/?locale=pt_BR"><i class="fab fa-facebook-square"></i></a>
        <a href="https://www.instagram.com/saopaulopizzariagama/"><i class="fab fa-instagram"></i></a>
        <a href="https://x.com/sao_df"><i class="fab fa-twitter"></i></a>
      </div>
      <a class="btn btn-acesso btn-lg mt-3" href="card_pizza.jsp" role="button">Acesse ao Cardápio</a>
    </div>

    <div class="row">
      <div class="col-md-4">
        <div class="card mb-4">
            <img src="imgs/m.jpg" class="card-img-top" alt="Pizza Margherita">
          <div class="card-body">
            <h5 class="card-title">Pizza Margherita</h5>
            <p class="card-text">A clássica receita napolitana com molho de tomate, mozzarella fresca e manjericão.</p>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4">
          <img src="imgs/c.jpg" class="card-img-top" alt="Pizza Calabresa">
          <div class="card-body">
            <h5 class="card-title">Pizza Calabresa</h5>
            <p class="card-text">Generosas fatias de calabresa, cebola, pimentões e queijo derretido.</p>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4">
          <img src="imgs/4queijo.jpg" class="card-img-top" alt="Pizza Quatro Queijos">
          <div class="card-body">
            <h5 class="card-title">Pizza Quatro Queijos</h5>
            <p class="card-text">Combinação perfeita de mozzarella, parmesão, gorgonzola e provolone.</p>
          </div>
        </div>
      </div>
    </div>

    <div class="info-section text-center">
      <div class="row">
        <div class="col-md-4">
          <h5 class="text-black">Endereço</h5>
          <p class="text-black">St. Central 1 - Gama, Brasília - DF, 72405-550</p>
        </div>
        <div class="col-md-4">
          <h5 class="text-black">Telefone</h5>
          <p class="text-black">(061)3550-6691</p>
        </div>
        <div class="col-md-4">
          <h5 class="text-black">Localização</h5>
          <div class="map-responsive">
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.9358395264708!2d-48.066839025267925!3d-16.016855128471388!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9359800c409b097f%3A0xcd94faf451ddc01a!2sS%C3%A3o%20Paulo%20Pizzaria%20e%20Restaurante!5e0!3m2!1spt-BR!2sbr!4v1718568200815!5m2!1spt-BR!2sbr"
              width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
              referrerpolicy="no-referrer-when-downgrade"></iframe>
            <p><a href="#" class="card-link text-black">Ver no Mapa</a></p>
          </div>
        </div>
      </div>
    </div>

    <hr>

    <footer class="text-center">
      <p>&copy; 2024 Pizzaria São Paulo. Todos os direitos reservados.</p>
    </footer>
  </div>

  <!-- Bootstrap JS, Popper.js, and jQuery -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
