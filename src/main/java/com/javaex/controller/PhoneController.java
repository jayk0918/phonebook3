package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model){
		System.out.println("PhoneController>list()");
		
		List<PersonVo> pList = phoneService.getPersonList();
		
		model.addAttribute("pList" , pList);
		
		return "list";
	}
	
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo/*, @RequestParam("age") int age*/) {
		System.out.println("PhoneController>write()");
		System.out.println(personVo);
		// System.out.println(age);
		// @RequestParam은 반드시 파라미터 값을 받아주어야 하고 값이 없으면 무조건 오류
		// @RequestParam( value = “age“, request=false, defaultValue=“-1”) int age
		// RequestParam이 선택적으로 값을 수용할 경우 위와 같이 강제 값 설정을 해주어야 함
		
		phoneService.personInsert(personVo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name,
						 @RequestParam("hp") String hp,
						 @RequestParam("company") String company) {
		System.out.println("PhoneController>write()");
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		phoneService.personInsert(personVo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		return "writeForm";
	}
	
	@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("PhoneController>test()");
		return "test";
	}
	
	/*
	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("PhoneController>delete()");
		System.out.println(personId);
		
		phoneService.personDelete(personId);
		
		return "redirect:/list";
	}
	*/
	
	@RequestMapping(value="/delete/{personId}", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("personId") int personId) {
		System.out.println("PhoneController>delete()");
		System.out.println(personId);
		
		phoneService.personDelete(personId);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/updateForm", method={RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("personId") int personId) {
		System.out.println("PhoneController>updateForm()");
		
		PersonVo personVo = phoneService.getPerson(personId);
		
		model.addAttribute("personVo", personVo);
		
		return "updateForm";
	}
	
	@RequestMapping(value="/update", method={RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update()");
		
		phoneService.personUpdate(personVo);
		
		return "redirect:/list";
	}
}