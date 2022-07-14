<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 09/07/2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JamMaster - Rejestracja</title>

  <!-- Custom fonts for this template-->
  <link href="../vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../css/sb-admin-2.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

  <div class="card o-hidden border-0 shadow-lg my-5">
    <div class="card-body p-0">
      <!-- Nested Row within Card Body -->
      <div class="row">
        <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
        <div class="col-lg-7">
          <div class="p-5">
            <div class="text-center">
              <h1 class="h4 text-gray-900 mb-4">Stwórz Konto!</h1>
            </div>

            <form:form  modelAttribute="user" class="user" method="post" action="/register">
              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <form:input type="text" class="form-control form-control-user" name="firstname"
                         placeholder="Imię" path="name"/>
                </div>

                <div class="col-sm-6 mb-3 mb-sm-0">
                  <form:input type="text" class="form-control form-control-user" name="surname"
                         placeholder="Nazwisko" path="surname"/>
                </div>
              </div>
              <div class="form-group">
                <form:input type="email" class="form-control form-control-user" name="email"
                       placeholder="Adres email" path="email"/>
                <form:errors path="email"/>
              </div>
              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <form:input type="text" class="form-control form-control-user"
                         name="username" placeholder="Login" path="username"/>
                </div>
                <div class="col-sm-6">
                  <form:input type="password" class="form-control form-control-user"
                  name="password" placeholder="Hasło" path="password"/>
                  <form:errors path="password"/>
                </div>
              </div>
              <input type="submit" class="btn btn-primary btn-user btn-block" value="Zarejestruj się!"/>

              <hr>
              <a href="/" class="btn btn-google btn-user btn-block">
                <i class="fab fa-google fa-fw"></i> Zarejestruj przez Google
              </a>
              <a href="/" class="btn btn-facebook btn-user btn-block">
                <i class="fab fa-facebook-f fa-fw"></i> Zarejestruj przez Facebooka
              </a>
            </form:form>
            <hr>
            <div class="text-center">
              <a class="small" href="forgot-password.html">Zapomniałeś hasła?</a>
            </div>
            <div class="text-center">
              <a class="small" href="/login">Masz już konto? Zaloguj się!</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="../vendor/jquery/jquery.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.js"></script>

<!-- Core plugin JavaScript-->
<script src="../vendor/jquery-easing/jquery.easing.js"></script>

<!-- Custom scripts for all pages-->
<script src="../js/sb-admin-2.js"></script>

</body>

</html>