<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 관리</title>
    <!-- Bootstrap 스타일 및 JavaScript 라이브러리를 가져옵니다. -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- 페이지 상단의 제목 및 설명 부분입니다. -->
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>게시판 관리</h1>
        <p>게시판 관리 프로그램</p>
    </div>
    
    <!-- 네비게이션 바를 정의합니다. -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="#">Navbar</a>
        <!-- 네비게이션 바의 버튼을 작성합니다. -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- 네비게이션 바의 메뉴 목록을 작성합니다. -->
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>
        </div>  
    </nav>
    <br><br>
    <!-- 페이지 내용 중앙 부분입니다. -->
    <div class="text-center">
        <!-- 게시판 목록과 게시글 입력 버튼을 생성합니다. -->
        <button type="button" class="btn btn-primary" onclick="location.href='list.do'">게시판 목록</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-primary" onclick="location.href='insertForm.do'">게시글 입력</button>
    </div>
</body>
</html>
