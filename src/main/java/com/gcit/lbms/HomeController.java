package com.gcit.lbms;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "Welcome";
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "admin";
	}
	@RequestMapping(value = "/borrower", method = RequestMethod.GET)
	public String borrower(Locale locale, Model model) {
		return "borrower";
	}
	@RequestMapping(value = "/librarian", method = RequestMethod.GET)
	public String librarain(Locale locale, Model model) {
		return "librarian";
	}
	
}
