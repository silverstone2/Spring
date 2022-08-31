package com.gura.step03.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step03.member.dto.MemberDto;

//MemberDaoImpl 객체도 spring bean container 에서 관리가 되도록한다.
//MemberDao 구현 Implement 클래스
@Repository
public class MemberDaoImpl implements MemberDao{

	// 'Spring Bean Container 에서 SqlSession type 객체를 찾아서 주입해(DI) 주세요' 라는 의미
	@Autowired
	private SqlSession session; // session에는 초기에 null 값이 들어 있기 때문에 어노테이션으로 주입을 해준다. -> autowired때문에 null이 아니게 됨.
	
	@Override
	public void insert(MemberDto dto) {
		/*
		 * Mapper's namespace : member
		 * sql's id : insert
		 * parameterType : MemberDto
		 */
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		// selectOne 은 row가 하나일때 사용 , return type은 row가 어떤 것이냐에 따라 다름
		// selectList return type 은 list로 고정. 단, generic type은 row가 어떤 것이냐에 따라서 그 값은 다르다
		
		/*
		 * Maaper's namespace : member
		 * sql's id : getData
		 * parameterType : int
		 * resultType : MemberDto
		 */
		MemberDto dto = session.selectOne("member.getData", num);
		
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
		
		/*
		 * Maaper's namespace : member
		 * sql's id : getList
		 * parameterType : 없음
		 * resultType : MemberDto
		 */
		List<MemberDto> list = session.selectList("member.getList");
		return list;
	}
	
}
