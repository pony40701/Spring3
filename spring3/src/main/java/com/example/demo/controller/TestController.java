package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.MemberForm;
import com.example.demo.model.User;

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
		model.addAttribute("companyTel", "04-12345678");

		User user = new User();
		user.setName("Brad");
		user.setAge(18);
		user.setGender(false);

		model.addAttribute("user", user);

		String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

		model.addAttribute("now", now);

		return "page3";
	}

	@GetMapping("/register")
	public String m4(Model model) {
		MemberForm form = new MemberForm();
		form.setAccount("Account");
		model.addAttribute("memberForm", form);

		return "register";
	}

	@PostMapping("/register")
	public String m5(@ModelAttribute MemberForm memberForm, Model model) {
		System.out.println(memberForm.getAccount());
		System.out.println(memberForm.getPasswd());
		System.out.println(memberForm.getCname());
		model.addAttribute("msg","註冊成功");
		return "register";
	}
}
