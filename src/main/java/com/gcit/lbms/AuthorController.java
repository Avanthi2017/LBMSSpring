package com.gcit.lbms;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcit.lbms.entity.Author;
import com.gcit.lbms.service.AuthorService;


@Controller
@RequestMapping(value="/author")
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAuthor(Locale locale, Model model) {
		return "addAuthor";
	}
	@RequestMapping(value = "/loadEditPage")
	public String editAuthorLoad(@ModelAttribute("author")Author author) {
		return "editauthor";
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateAuthor(@ModelAttribute("author")Author author) {
		authorService.udpateAuthor(author);
		return "editauthor";
	}
	
	@RequestMapping(value = "/loadDeletePage", method = RequestMethod.GET)
	public String deleteAuthorLoad(@ModelAttribute("author")Author author) {
		return "deleteauthor";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAuthor(@ModelAttribute("author")Author author) {
		return "deleteauthor";
	}
	@RequestMapping(value = "/loadViewPage", method = RequestMethod.GET)
	public String viewAuthorsLoad(Locale locale, Model model) {
		return "viewauthor";
	}
	

}
