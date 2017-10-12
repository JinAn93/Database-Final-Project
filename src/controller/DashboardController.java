package com.fasoo.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasoo.spring.model.Post;
import com.fasoo.spring.service.IPostService;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class DashboardController {

	@Autowired
	IPostService postService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String listPosts(ModelMap model) {
		if (model.containsAttribute("user_id")) {
			model.addAttribute("posts", postService.findAllPosts());
			return "dashboard";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String newPost(ModelMap model) {
		if (model.containsAttribute("user_id")) {
			model.addAttribute("post", new Post());
			return "newPost";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "newPost";
		}
		
		postService.savePost(post);
		model.addAttribute("success", "New Post has been saved!");
		return "success";
	}
	
	@RequestMapping(value = { "/edit-{id}-post" }, method = RequestMethod.POST)
	public String updatePost(@Valid Post post, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
			return "newPost";
		}

		postService.updatePost(post);
		model.addAttribute("success", "The post has been successfully editted");
		return "success";
	}

	@RequestMapping(value = { "/delete-{id}-post" }, method = RequestMethod.GET)
	public String deletePost(@PathVariable int id, ModelMap model) {
		if (model.containsAttribute("user_id")) {
			postService.deletePostByID(id);
			return "redirect:/dashboard";
		}
		return "redirect:/login";
	}
}
