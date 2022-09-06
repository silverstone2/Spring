package com.gura.step04.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step04.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		
		return session.selectList("cafe.getList", dto);
	}

	@Override
	public int getCount(CafeDto dto) {
		
		return session.selectOne("cafe.getCount", dto);
	}

	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
	}

	// 검색 기능이 없었을 때 사용하던 메소드(현재 사용 안함)
	@Override
	public CafeDto getData(int num) {
		
		return session.selectOne("cafe.getData", num);
	}

	// 검색 기능 생기고 사용하는 메소드(사용중인 상태)
	@Override
	public CafeDto getData(CafeDto dto) {
		
		return session.selectOne("cafe.getData2", dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("cafe.addViewCount", num);
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete", num);
	}

	@Override
	public void update(CafeDto dto) {
		session.update("cafe.update", dto);
	}

}
