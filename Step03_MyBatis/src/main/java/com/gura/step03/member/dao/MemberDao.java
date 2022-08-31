package com.gura.step03.member.dao;

import java.util.List;

import com.gura.step03.member.dto.MemberDto;

// 인터페이스를 구현시켜서 만든 이유는 의존관계를 느슨하게 하기 위해서 interface type을 적극 활용해야 하기 때문
public interface MemberDao {
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public MemberDto getData(int num);
	public List<MemberDto> getList();
}
