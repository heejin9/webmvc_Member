package com.ssg.w2.service;

import com.ssg.w2.dao.MemberDAO;
import com.ssg.w2.domain.MemberVO;
import com.ssg.w2.dto.MemberDTO;
import com.ssg.w2.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    //객체 참조를 위한 변수 선언
    private MemberDAO memberDAO;

    private ModelMapper modelMapper;

    //객체 생성 및 초기화
    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<MemberDTO> listAll() throws Exception {
        List<MemberVO> voList = memberDAO.listMembers();
        List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    public void register(MemberDTO memberDTO) throws Exception {
        MemberVO vo = modelMapper.map(memberDTO, MemberVO.class);
        log.info(vo);
        memberDAO.memberinsert(vo);
    }

    public void modify(MemberDTO memberDTO) throws Exception {
        System.out.println("modify service" + memberDTO);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.update(memberVO);
    }

    public void delete(String id) throws Exception {
        System.out.println("delete service method " + id);
        memberDAO.delete(id);
    }

}
