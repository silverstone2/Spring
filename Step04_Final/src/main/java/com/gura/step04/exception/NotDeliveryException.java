package com.gura.step04.exception;

import org.springframework.dao.DataAccessException;
/*
 *  트랜젝션에 영향을 주는 예외 클래스 만들기 
 *  - DataAccessException 클래스를 상속 받아서 만든다.
 */
public class NotDeliveryException extends DataAccessException{

	public NotDeliveryException(String msg) {
		super(msg);
		
	}
	

}
