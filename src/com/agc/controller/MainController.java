package com.agc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agc.database.Transaction;
import com.agc.entity.Producer;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}
	
	@RequestMapping("/producers")
	public String showProducers(Model model) {
		
		List<Producer> producerList = (List<Producer>) Transaction.getEntities("Producer");
		model.addAttribute("producers", producerList);
		return "producers";
	}
	
}
