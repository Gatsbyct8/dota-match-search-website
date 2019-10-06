package com.bigname.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigname.demo03.core.Member;
import com.bigname.demo03.function.IMemberFunction;
import com.bigname.demo03.function.MemberFunctionImpl;

@Controller
public class LoginController {
	@Autowired
	IMemberFunction iMemberFunc;
	
	@RequestMapping(value = "/hello")
	public String hello(){
		System.out.println("���յ����� ��Hello");
		return "hi";
	}
	
	@RequestMapping(value = "/login")
	public String login(String name, String password){
		try {
			Member member = iMemberFunc.login(name, password);
			if(member == null){
				System.out.println("��½ʧ��");
			}else {
				System.out.println("��½�ɹ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("��¼ʧ��");
		}
		return null;
	}
}
