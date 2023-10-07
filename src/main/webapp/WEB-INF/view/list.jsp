<%@page import="cs.dit.board.BoardDto"%>
<%@page import="cs.dit.board.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <!-- 필요한 CSS 및 JavaScript 라이브러리를 가져옵니다. -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <!-- 컨테이너를 정의합니다. -->
    <div class="container"><br>    
    <h2 class="text-center font-weight-bold">게시판 목록</h2>
    <br>
    <table class="table table-hover">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>파일명</th>
        </tr>

        <!-- 게시글 목록을 반복하여 출력합니다. -->
        <c:forEach var='dto' items='${dtos}'>
            <tr>
                <td>${dto.bcode}</td>
                <td><a href="updateForm.do?bcode=${dto.bcode}">${dto.subject}</a></td>
                <td>${dto.writer}</td>
                <td><fmt:formatDate value="${dto.regDate}"/></td>
                <td><a download href="/uploadfiles/${dto.fileName}">${dto.fileName}</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <!-- 홈으로 이동 및 게시글 등록 버튼을 생성합니다. -->
    <input type="button" value="홈으로" onclick="location.href='index.do'">
    <input type="button" value="게시글 등록" onclick="location.href='insertForm.do'">
    </div>  
    <div class="d-flex justify-content-center">
        <ul class="pagination">
            <!-- 이전 페이지로 이동하는 버튼을 생성합니다. -->
            <c:if test="${startNum > 1}">
                <li class="page-item"><a class="page-link" href="list.do?p=${startNum-1}">Prev</a></li>
            </c:if>
            <c:if test="${startNum <= 1}">
                <li class="page-item"><a class="page-link" style="color:gray" onclick="alert('이전 페이지가 없습니다!')" href="#">Prev</a></li>
            </c:if>
            <!-- 페이지 번호를 출력하고 현재 페이지를 강조합니다. -->
            <c:forEach var="i" begin="0" end="4" step="1">
                <c:if test="${startNum + i <= lastNum}">
                    <c:if test="${startNum + i == p}">
                        <li class="page-item active"><a class="page-link" href="list.do?p=${startNum + i}">${startNum + i}</a></li>
                    </c:if>
                    <c:if test="${startNum + i != p}">
                        <li class="page-item"><a class="page-link" href="list.do?p=${startNum + i}">${startNum + i}</a></li>
                    </c:if>
                </c:if>
            </c:forEach>
            <!-- 다음 페이지로 이동하는 버튼을 생성합니다. -->
            <c:if test="${startNum + 5 <= lastNum}">
                <li class="page-item"><a class="page-link" href="list.do?p=${startNum+5}">Next</a></li>
            </c:if>
            <c:if test="${startNum + 5 > lastNum}">
                <li class="page-item"><a class="page-link" style="color:gray" onclick="alert('다음 페이지가 없습니다!')" href="#">Next</a></li>
            </c:if>
        </ul>
    </div>
</body>
</html>
