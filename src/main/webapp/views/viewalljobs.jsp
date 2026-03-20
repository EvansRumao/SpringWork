<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Post List</title>

    <!-- Bootstrap CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-warning">
    <div class="container">
        <a class="navbar-brand fs-1 fw-medium" href="#">Job Portal Web App</a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="viewalljobs">All Jobs</a></li>
                <li class="nav-item"><a class="nav-link" href="https://google.com/">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container mt-5">
    <h2 class="mb-4 text-center fw-bold">Job Post List</h2>

    <!-- If jobs exist -->
    <c:if test="${not empty jobPosts}">
        <div class="row row-cols-1 row-cols-md-2 g-4">

            <c:forEach var="jobPost" items="${jobPosts}">

                <div class="col">
                    <div class="card border-dark bg-dark text-white h-100">
                        <div class="card-body">

                            <h5 class="card-title">${jobPost.postProfile}</h5>

                            <p>
                                <strong>Description:</strong><br>
                                ${jobPost.postDesc}
                            </p>

                            <p>
                                <strong>Experience Required:</strong>
                                ${jobPost.reqExperience} years
                            </p>

                            <strong>Tech Stack:</strong>

                            <!-- Tech Stack Safe -->
                            <c:if test="${not empty jobPost.postTechStack}">
                                <ul>
                                    <c:forEach var="tech" items="${jobPost.postTechStack}">
                                        <li>${tech}</li>
                                    </c:forEach>
                                </ul>
                            </c:if>

                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
    </c:if>

    <!-- If no jobs -->
    <c:if test="${empty jobPosts}">
        <h4 class="text-center">No Jobs Available</h4>
    </c:if>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>