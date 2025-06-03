package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.MemberForm;
import com.example.demo.model.User;
import com.example.demo.model.UserForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping("/m1")
	public String m1() {
		return "page1";
	}
	
	@GetMapping("/dir1.page2")
	public String m2() {
		return "dir1/page2";
	}

	@GetMapping("/m3")
	public String m3(Model model) {
		model.addAttribute("companyName", "Brad Big Company");
		model.addAttribute("companyTel", "04-23121234");
		
		User user = new User();
		user.setName("Brad");
		user.setAge(17);
		user.setGender(false);
		
		model.addAttribute("user", user);
		
		String now = LocalDateTime.now().format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		model.addAttribute("now", now);
		
		return "page3";
	}
	
	@GetMapping("/register")
	public String m4(Model model) {
		MemberForm form = new MemberForm();
		//form.setAccount("Account");
		model.addAttribute("memberForm", form);
		
		//List<String> areas = List.of("北屯區","南屯區","西屯區");
		List<Map<String,String>> areas = List.of(
			Map.of("zipcode","401","name","北屯區"),
			Map.of("zipcode","402","name","南屯區"),
			Map.of("zipcode","403","name","西屯區")
		);
		
		model.addAttribute("areas", areas);
		
		
		
		return "register";
	}
	
	@PostMapping("/register")
	public String m5(
			@ModelAttribute MemberForm memberForm, 
			Model model) {
		System.out.println(memberForm.getAccount());
		System.out.println(memberForm.getPasswd());
		System.out.println(memberForm.getCname());
		System.out.println(memberForm.getArea());
		model.addAttribute("msg", "註冊成功");
		
		return "register";
	}
	
	@GetMapping("/m6")
	public String m6(Model model) {
		model.addAttribute("status", "s7");	// s1, s2, s3
		return "m6";
	}
	
	@GetMapping("/m7")
	public String m7(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "m7";
	}
	
	@PostMapping("/m7")
	public String m7(
			Model model,
			@ModelAttribute("userForm") @Valid UserForm userForm,
			BindingResult bindResult
			) {
		if (bindResult.hasErrors()) {
			return "m7";
		}
		
		return "m8";
	}
	
	@GetMapping("/m9")
	public String m9(Model model) {
		List<String> names = List.of(
				"Brad","Andy","Kevin","Peter","Mary","Vivian","Tony");
		model.addAttribute("names", names);
		return "m9";
	}
	
	
	
	
}
