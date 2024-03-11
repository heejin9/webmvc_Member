<%--
  Created by IntelliJ IDEA.
  User: heejin
  Date: 2024-03-08
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 400px;
            margin: 100px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-group {
            display: flex;
            justify-content: center;
        }
        .btn-primary, .btn-secondary {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            background-color: #6c757d;
            color: #fff;
            border: none;
        }
        .btn-primary:hover, .btn-secondary:hover {
            background-color: #495057;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">회원가입</h2>
    <form action="/member/addMember.do" method="post">
    <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn btn-primary mr-1">가입하기</button>
            <button type="reset" class="btn btn-secondary ml-1">다시입력</button>
        </div>
    </form>
</div>
</body>
</html>
