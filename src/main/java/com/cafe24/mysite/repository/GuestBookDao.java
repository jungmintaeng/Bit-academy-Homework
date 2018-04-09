package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getList(){
		return sqlSession.selectList("guestbook.getList");
	}
	
	public List<GuestBookVo> getLimitedList(Long lastNo){
		return sqlSession.selectList("guestbook.getLimitedList", lastNo);
	}
	
	public GuestBookVo getByNo(GuestBookVo vo) {
		return sqlSession.selectOne("guestbook.getByNo", vo);
	}

	public boolean insert(GuestBookVo vo) {
		return sqlSession.insert("guestbook.insert", vo) > 0;
	}

	public boolean delete(GuestBookVo vo) {
		return sqlSession.delete("guestbook.delete", vo) > 0;
	}
}
