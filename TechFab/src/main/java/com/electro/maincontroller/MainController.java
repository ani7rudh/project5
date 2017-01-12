package com.electro.maincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.electro.model.Category;
import com.electro.service.CategoryService;


@Controller
public class MainController {

	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("category",new Category());
	model.addAttribute("cList",categoryService.getCategoryList());


		return "index";
	}
}
