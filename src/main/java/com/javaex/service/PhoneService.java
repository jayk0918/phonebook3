package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneDao phoneDao;
	
	public List<PersonVo> getPersonList(){
		return phoneDao.dbSelect();
	}
	
	public int personInsert(PersonVo personVo) {
		return phoneDao.dbInsert(personVo);
	}
	
	public int personDelete(int personId) {
		return phoneDao.dbDelete(personId);
	}
	
	public PersonVo getPerson(int personId) {
		return phoneDao.getPerson(personId);
	}
	
	public int personUpdate(PersonVo personVo) {
		return phoneDao.dbUpdate(personVo);
	}
	
	
	
	
}
