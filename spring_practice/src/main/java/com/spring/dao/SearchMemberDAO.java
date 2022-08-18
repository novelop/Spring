package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.vo.MemberVO;
import com.spring.vo.SearchCriteria;


public interface SearchMemberDAO extends MemberDAO {

	// 회원리스트 조회
	List<MemberVO> selectSearchMemberList(SqlSession session, SearchCriteria cri) throws Exception;

	int selectSearchMemberListCount(SqlSession session, SearchCriteria cri) throws Exception;

}
