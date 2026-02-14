package com.example.RMMT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.RMMT.entity.RMMTEntity;
import com.example.RMMT.service.RMMTService;


@Controller
public class RMMTController {
	@Autowired
	private RMMTService service;
	
	@GetMapping("/")
	public String index(Model model) {
		List<RMMTEntity> list = service.findAll();
		model.addAttribute("RMMT",list);
		return "RMMT";
	}
	@PostMapping("/addMusic")
	public String addMusic(@RequestParam("title") String title,@RequestParam("artist") String artist,@RequestParam("url") String url,@RequestParam("friend")String friend) {
		service.addMusic(title,url,artist,friend);
		return "redirect:/";
	}
	@PostMapping("/addReview/{id}")
	public String addReview(@PathVariable("id")Integer id,@RequestParam("comment")String comment,@RequestParam("evaluation")int evaluation) {
		service.addReview(id, comment, evaluation);
		return "redirect:/";
	}
//	@PostMapping("/toggleFlag/{id}")
//	public String toggleFlag(@PathVariable("id")Integer id) {
//		service.toggleFlag(id);
//		return "redirect:/";
//	} 
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id) {
		service.delete(id);
		return "redirect:/";
	}
	
}
