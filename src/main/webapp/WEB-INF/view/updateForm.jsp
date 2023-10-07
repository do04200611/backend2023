<%@page import="cs.dit.board.BoardDao"%>
<%@page import="cs.dit.board.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List, java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <title>게시판</title>
</head>
<body>
<div class="container">
    <h2 class="text-center font-weight-bold">상세보기</h2>
    <br/>
    <form action="update.do" method="post" enctype="multipart/form-data">
        <!-- 게시글의 bcode를 숨겨진 필드로 전달합니다. -->
        <input type="hidden" name="bcode" value="${dto.bcode}">
        <table class="table table-striped table-hover">
            <tr>
                <!-- bcode와 subject 정보를 표시하고 수정할 수 있도록 입력 필드를 제공합니다. -->
                <th>bcode</th>
                <td>${dto.bcode}</td>
                <th>subject</th>
                <td><input type="text" value="${dto.subject}" name="subject"></td>
            </tr>
            <tr>
                <!-- content 정보를 표시하고 수정할 수 있도록 textarea를 제공합니다. -->
                <th>content</th>
                <td colspan="3"><textarea rows="10" cols="80" name="content">${dto.content}</textarea></td>
            </tr>
            <tr>
                <!-- writer 정보를 표시하고 수정할 수 있도록 입력 필드를 제공합니다. -->
                <th>writer</th>
                <td><input type="text" value="${dto.writer}" name="writer"></td>
            </tr>
            <tr>
                <!-- 기존 파일을 다운로드할 수 있는 링크와 변경 파일을 선택할 수 있는 입력 필드를 제공합니다. -->
                <th>기존파일</th>
                <td><a download href="/uploadfiles/${dto.fileName }">${dto.fileName }</a></td>
                <th>변경파일</th>
                <td><input type="file" class="form-control" id="fileName" name="fileName"></td>
            </tr>
            <tr>
                <!-- 게시글 수정, 삭제, 목록, 등록 버튼을 제공합니다. -->
                <td colspan="4">
                    <input type="submit" value="게시글 수정">
                    <input type="button" value="게시글 삭제" onclick="location.href='delete.do?bcode=${dto.bcode}'">
                    <input type="button" value="게시글 목록" onclick="location.href='list.do'">
                    <input type="button" value="게시글 등록" onclick="location.href='insertForm.do'">
                </td>
            </tr>
        </table>
        <br><br>
    </form>
</div>
</body>
</html>
