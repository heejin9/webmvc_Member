package com.ssg.w2.dao;

import com.ssg.w2.domain.MemberVO;
import lombok.Cleanup;
import lombok.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public List<MemberVO> listMembers() throws Exception {
        String sql = "Select * from mvc_member";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MemberVO> list = new ArrayList<>();

        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .id(rs.getString("id"))
                    .password(rs.getString("password"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .regDate(rs.getDate("regdate").toLocalDate())
                    .build();

            list.add(vo);
        }
        return list;
    }

    public void memberinsert(MemberVO vo) throws Exception {

        String sql = "INSERT INTO mvc_member (id, password, name, email, regdate) VALUES (?, ?, ?, ?, CURRENT_DATE)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, vo.getId());
        pstmt.setString(2, vo.getPassword());
        pstmt.setString(3, vo.getName());
        pstmt.setString(4, vo.getEmail());
//        pstmt.setDate(5, Date.valueOf(vo.getRegDate()));

        pstmt.executeUpdate();
    }

    public void delete(String id) throws Exception {
        String sql = "DELETE from mvc_member WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        pstmt.executeUpdate();
    }

    public void update(MemberVO memberVO) throws Exception {
        String sql = "UPDATE mvc_member SET password = ?, name = ?, email = ?, regdate =? WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberVO.getPassword());
        pstmt.setString(2, memberVO.getName());
        pstmt.setString(3, memberVO.getEmail());
        pstmt.setDate(4, Date.valueOf(memberVO.getRegDate()));
        pstmt.setString(5, memberVO.getId());

        pstmt.executeUpdate();

    }
}