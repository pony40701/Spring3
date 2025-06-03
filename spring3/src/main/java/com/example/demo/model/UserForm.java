package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {
	@NotBlank(message = "Email 不得為空")
	@Email(message = "輸入有效的 Email")
	private String email;

	@NotBlank(message = "密碼不得為空")
	@Size(min = 6, message = "密碼長度至少 6 碼以上")
	private String passwd;

	@NotBlank(message = "姓名不得為空")
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}