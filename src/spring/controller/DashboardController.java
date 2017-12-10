package spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.model.Company;
import spring.model.Post;
import spring.service.ICompanyService;
import spring.service.IPostService;
import spring.util.Utils;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class DashboardController {

	@Autowired
	IPostService postService;
	
	@Autowired
	ICompanyService companyService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String listPosts(ModelMap model) {
		// Add Login Logic (Spring security / Adding Cookies?) 
		model.addAttribute("posts", postService.findAllPosts());
		return "dashboard";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String newPost(ModelMap model) {
		model.addAttribute("post", new Post());
		return "newPost";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "newPost";
		}
		
		// if company exists in the database
		String company_name_normalized = Utils.normalizeString(post.getCompany_name());
		if (companyService.findById(company_name_normalized) == null)
			companyService.saveCompany(new Company().setCompany_name(company_name_normalized));
		post.setCompany_name(company_name_normalized);
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
