<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 01/07/2022
  Time: 12:15
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

    <title>JamMaster - Strona główna</title>

    <!-- Custom fonts for this template-->
    <link href="../vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin-2.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-guitar"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Jam Master</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-home"></i>
                <span>Strona główna</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">



        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-table"></i>
                <span>Listy</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Wybierz listę:</h6>
                    <a class="collapse-item" href="/author/list">Lista Autorów</a>
                    <a class="collapse-item" href="/set/list">Gotowe Sety</a>
                    <a class="collapse-item" href="/song/list">Lista piosenek</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-plus"></i>
                <span>Dodaj coś od siebie</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Narzędzia użytkownika:</h6>
                    <a class="collapse-item" href="/song/add">Dodaj piosenkę</a>
                    <a class="collapse-item" href="/set/add">Stwórz set</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href="/about">
                <i class="fas fa-fw fa-tablet-alt"></i>
                <span>O aplikacji</span>
            </a>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="/session/">
                <i class="fas fa-fw fa-video"></i>
                <span>Tryb Sesji</span></a>
        </li>

        <!-- Nav Item - Tables -->


        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

        <!-- Sidebar Message -->
        <div class="sidebar-card d-none d-lg-flex">
            <img class="sidebar-card-illustration mb-2" src="../img/undraw_rocket.svg" alt="...">
            <p class="text-center mb-2">Korzystasz z podstawowej wersji JamMaster.</p>
            <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Ulepsz do wersji Pro!</a>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->


                <!-- Topbar Search -->
                <jsp:include page="topbar.jsp"/>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Strona Główna</h1>
                </div>

                <!-- Content Row -->
                <div class="row">

                    <!-- Songs counter -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-primary shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Liczba dodanych piosenek</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">${liczbaPiosenek}</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-headphones fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Users songs counter -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            Liczba piosenek dodanych przez Ciebie</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">${usersSongs}</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-music fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Added authors counter -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-info shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Dodani autorzy
                                        </div>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col-auto">
                                                <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${authorsNumber}</div>
                                            </div>
                                            <div class="col">
                                                <div class=" progress-sm mr-2">
                                                    <div class="bg-info">
                                                         </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-male fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Added users sets counter -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-warning shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                            Twoje sety</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">${usersSets}</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Content Row -->

                <div class="row">

                <!-- Content Row -->
                <div class="row">

                    <!-- Content Column -->
                    <div class="col-lg-6 mb-4">

                        <!-- Last added song -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Ostatnio dodana piosenka</h6>
                            </div>
                            <div class="card-body">
                                <h4 class="medium font-weight-bold">Tytuł: ${title}</h4>
                                <h4 class="small font-weight-bold">Autor: ${author}</h4>
                                <h4 class="small font-weight-bold">Tempo: ${tempo} BPM</h4>
                                <h4 class="small font-weight-bold">Tonacja: ${songKey}</h4>
                            </div>
                        </div>
                        <!-- Shortcuts -->
                        <h4>Na skróty:</h4>
                        <div class="row">
                            <div class="col-lg-6 mb-4">
                                <a href="/song/list" class="btn-primary">
                                <div class="card bg-primary text-white shadow">
                                    <div class="card-body">
                                        Lista piosenek
                                        <div class="text-white-50 small"> &rarr;</div>
                                    </div>
                                </div>
                                </a>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <a href="/song/add" class="btn-primary">
                                <div class="card bg-success text-white shadow">
                                    <div class="card-body">
                                        Dodaj piosenkę
                                        <div class="text-white-50 small"> &rarr;</div>
                                    </div>
                                </div>
                                </a>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <a href="/author/list" class="btn-primary">
                                <div class="card bg-info text-white shadow">
                                    <div class="card-body">
                                        Lista autorów
                                        <div class="text-white-50 "> &rarr;</div>
                                    </div>
                                </div>
                                </a>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <a href="/set/add" class=" btn-primary">
                                <div class="card bg-warning text-white shadow">
                                    <div class="card-body">
                                        Stwórz set
                                        <div class="text-white-50"> &rarr;</div>
                                    </div>
                                </div>
                                </a>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-6 mb-4">

                        <!-- About us -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">O aplikacji</h6>
                            </div>
                            <div class="card-body">
                                <div class="text-center">
                                    <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                         src="../img/undraw_posting_photo.svg" alt="...">
                                </div>
                                <p>Naszą misją jest ułatwienie życia jak największej liczbie muzyków. W tym celu stworzyliśmy
                                tę aplikację. Staramy się na bieżąco dodawać do niej nowe funkcjonalności oraz poprawiać już istniejące...</p>
                                <a rel="nofollow" href="/about">Więcej o aplikacji &rarr;</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Na pewno chcesz wyjść?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Jeśli chcesz się wylogować kliknij "Wyloguj". Jeśli się rozmyśliłeś wciśnij anuluj.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Anuluj</button>
                <a class="btn btn-primary" href="/login">Wyloguj</a>
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

<!-- Page level plugins -->
<script src="../vendor/chart.js/Chart.js"></script>

<!-- Page level custom scripts -->
<script src="../js/demo/chart-area-demo.js"></script>
<script src="../js/demo/chart-pie-demo.js"></script>

</body>

</html>
