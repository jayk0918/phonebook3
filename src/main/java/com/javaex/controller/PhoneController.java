package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
//@RequestMapping(value="/guest")
public class PhoneController {

	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController>write()");
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.dbInsert(personVo);
		System.out.println(count);
		return "";
	}
	
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST})
	public String test() {
		return "/WEB-INF/views/test.jsp";
	}
	
}