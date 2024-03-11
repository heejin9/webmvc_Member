package com.ssg.w2.controller;

import com.ssg.w2.dto.MemberDTO;
import com.ssg.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberModifyController", urlPatterns = "/member/modMember.do")
public class ModifyController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        try {
            memberService.modify(MemberDTO.builder()
                    .id(id)
                    .password(password)
                    .name(name)
                    .email(email)
                    .build());

            response.sendRedirect("/member/listMembers.do");
        } catch (Exception e) {
            throw new ServletException("modify err");
        }
    }
}


