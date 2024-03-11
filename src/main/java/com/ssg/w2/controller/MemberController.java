package com.ssg.w2.controller;

import com.ssg.w2.dto.MemberDTO;
import com.ssg.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "memberRegisterController", urlPatterns = "/member/addMember.do")
public class MemberController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    private final DateTimeFormatter DateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/member/memberForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO memberDTO = MemberDTO.builder()
                .id(request.getParameter("id"))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .email(request.getParameter("email"))
                .regDate(Date.valueOf(LocalDate.now()).toLocalDate()) // 현재 날짜를 사용하여 등록일을 설정
                .build();

        try {
            memberService.register(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Register Exception");
        }

        response.sendRedirect("/member/listMembers.do");
    }

}