<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 등록</title>
    <!-- Bootstrap 스타일 및 JavaScript 라이브러리를 가져옵니다. -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- 컨테이너를 정의합니다. -->
    <div class="container">
        <br>
        <h2 class="text-center font-weight-bold">게시글 등록</h2>
        <hr/>
        <!-- 게시글 등록을 위한 폼을 작성합니다. -->
        <form action="insert.do" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="subject">제목 :</label>
                <input type="text" class="form-control" id="subject" name="subject">
            </div>
            <div class="form-group">
                <label for="content">내용 :</label><br>
                <textarea rows="10" cols="80" name="content" id="content"></textarea>
            </div>
            <div class="form-group">
                <label for="writer">작성자 :</label>
                <input type="text" class="form-control" id="writer" name="writer">
            </div>
            <div class="form-group">
                <label for="fileName">파일 첨부 :</label>
                <input type="file" class="form-control" id="fileName" name="fileName">
            </div>

            <div class="text-center">
                <!-- 게시글을 등록하는 버튼을 생성합니다. -->
                <button type="submit" class="btn btn-secondary">등록</button>
            </div>
        </form>
    </div>
</body>
</html>
