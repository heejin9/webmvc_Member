package com.ssg.w2.controller;

import com.ssg.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberdeleteController", urlPatterns = "/member/delMember.do")
public class DeleteController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            memberService.delete(id);
        } catch (Exception e) {
            throw new ServletException("remove err");
        }

        response.sendRedirect("/member/listMembers.do");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            memberService.delete(id);
        } catch (Exception e) {
            throw new ServletException("remove err");
        }

        response.sendRedirect("/member/listMembers.do");
    }
}
// 왜 여기선 get?