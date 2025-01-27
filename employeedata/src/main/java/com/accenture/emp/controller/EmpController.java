package com.accenture.emp.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.emp.beans.EmployeeBean;
import com.accenture.emp.beans.EmployeeDataExistsException;
import com.accenture.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	
	@RequestMapping(value="/employeeform")
	ModelAndView goToAddEmployee() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/addemployee.jsp");
		
		mv.addObject("emp", new EmployeeBean());

		return mv;
		
	}
	
	// ABOVE EMP object is used to get the values entered by user in the browser.
	
	@RequestMapping(value="/saveEmployee", method= RequestMethod.POST)
	ModelAndView addEmployee(@ModelAttribute("emp") @Valid EmployeeBean employeeBean, BindingResult br) {
		
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			mv.setViewName("/WEB-INF/views/addemployee.jsp");
		}
		
		System.out.println(employeeBean);
		empService.addEmployeeDetails(employeeBean);
		
		mv.setViewName("/WEB-INF/views/index.jsp");
		
		return mv;
	
	}
	
	
	@RequestMapping(value="/showemployee")
	ModelAndView showEmployee() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/WEB-INF/views/viewemployee.jsp");
		
		List<EmployeeBean> empList = empService.viewEmployeeDetails();
		mv.addObject("eList", empList);
		
		return mv;
		
	}
	
	@RequestMapping(value="/remove")
	String removeEmployeeData(@RequestParam("eId") int employeeId) {
		
		empService.removeEmployeeDetails(employeeId);
		
		return "redirect:showemployee";
	}
	
	
	@ExceptionHandler(value=EmployeeDataExistsException.class)
	String errorHandlingPage(EmployeeDataExistsException empEx) {
		
		return "/WEB-INF/views/errorhandle.jsp";
	}
	
	
	@ModelAttribute(value="EmpMap")
	public Map<Integer, String> getAllRoles() {
		
		Map<Integer, String> map = empService.getAllEmps();
		
		return map;
		
	}
	

}
