package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.spring.dao.SearchMemberDAO;
import com.spring.exception.NotMatchSearchCriteria;
import com.spring.vo.Criteria;
import com.spring.vo.MemberVO;
import com.spring.vo.PageMaker;
import com.spring.vo.SearchCriteria;


public class SearchMemberServiceImpl extends MemberServiceImpl {

	private SqlSessionFactory sqlSessionFactory;
	private SearchMemberDAO memberDAO;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;

	}

	public void setMemberDAO(SearchMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public Map<String, Object> getMemberListForPage(Criteria cri) throws Exception {

		if (cri instanceof SearchCriteria) {
			SearchCriteria searchCri = (SearchCriteria) cri;

			SqlSession session = sqlSessionFactory.openSession(false);
			Map<String, Object> dataMap = null;

			try {

				// 처리.......
				List<MemberVO> memberList = memberDAO.selectSearchMemberList(session, searchCri);

				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(memberDAO.selectSearchMemberListCount(session, searchCri));

				dataMap = new HashMap<String, Object>();
				dataMap.put("memberList", memberList);
				dataMap.put("pageMaker", pageMaker);

				session.commit();

			} catch (Exception e) {
				session.rollback();
				e.printStackTrace();
				throw e;
			} finally {
				if (session != null)
					session.close();
			}
			return dataMap;

		} else {
			throw new NotMatchSearchCriteria();
		}

	}

}
