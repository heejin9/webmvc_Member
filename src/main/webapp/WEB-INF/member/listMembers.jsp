<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 800px;
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

        .btn-primary {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            background-color: #6c757d;
            color: #fff;
            border: none;
        }

        .btn-primary:hover {
            background-color: #495057;
        }

        .info-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }

        .info-table th, .info-table td {
            border: 1px solid #dee2e6;
            padding: 10px;
            text-align: center;
        }

        .info-table th {
            background-color: #6c757d;
            color: #fff;
        }

        .register-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">회원정보</h2>
    <table class="info-table">
        <thead>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <!-- 여기에 회원 정보를 동적으로 추가 -->
        <c:forEach items="${dtoList}" var="dto">
            <tr>
                <td>${dto.id}</td>
                <td>${dto.password}</td>
                <td>${dto.name}</td>
                <td>${dto.email}</td>
                <td>${dto.regDate}</td>
                <td><a href="#" class="modifyBtn" data-id="${dto.id}" data-toggle="modal"
                       data-target="#modifyModal">수정</a></td>
                <td><a href="/member/delMember.do?id=${dto.id}">삭제</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="btn-group text-center">
        <a href="/member/addMember.do" class="btn btn-primary">회원 가입하기</a>
    </div>
</div>

<!-- 모달 창 -->
<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modifyModalLabel">회원 정보 수정</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- 수정할 정보 입력 폼 -->
                <form id="modifyForm" action="/member/modifyMember.do" method="post">
                    <input type="hidden" id="modifyId" name="id" value="">
                    <div class="form-group">
                        <label for="modifyPassword">비밀번호</label>
                        <input type="password" class="form-control" id="modifyPassword" name="password" required>
                    </div>
                    <div class="form-group">
                        <label for="modifyName">이름</label>
                        <input type="text" class="form-control" id="modifyName" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="modifyEmail">이메일</label>
                        <input type="email" class="form-control" id="modifyEmail" name="email" required>
                    </div>
                    <div class="btn-group text-center">
                        <a href="/member/listMembers.do" class="btn btn-primary">수정 완료</a>
                    </div>
                    <%--                    <button type="submit" class="btn btn-primary">수정 완료</button>--%>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        // 수정 폼 제출 시
        $('#modifyForm').on('submit', function (event) {
            // 기본 이벤트 제거
            event.preventDefault();

            // 폼 데이터 가져오기
            var formData = $(this).serialize();

            // AJAX 요청 보내기
            $.ajax({
                type: 'POST',
                url: '/member/modifyMember.do', // ModifyController URL
                data: formData,
                success: function (response) {
                    // 회원 목록 페이지로 리다이렉트
                    window.location.href = '/member/listMembers.do';
                },
                error: function (xhr, status, error) {
                    // 오류 처리
                    console.error(error);
                    alert('수정에 실패했습니다.');
                }
            });
        });
    });
</script>
</body>
</html>
