package org.gso.codeassignment.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	String index() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("username: " + auth.getName());

		return "index";
	}

	@RequestMapping("/unauthorized")
	String unAuthorized() {
		return "unauthorized";
	}

}
