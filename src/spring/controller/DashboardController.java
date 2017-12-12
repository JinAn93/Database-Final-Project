package spring.controller;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.model.Company;
import spring.model.FollowingCompany;
import spring.model.FollowingUser;
import spring.model.Post;
import spring.model.User;
import spring.service.EmailService;
import spring.service.ICompanyService;
import spring.service.IFollowingCompanyService;
import spring.service.IFollowingUserService;
import spring.service.IPostService;
import spring.service.IUserService;
import spring.util.Utils;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class DashboardController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IPostService postService;
	
	@Autowired
	ICompanyService companyService;
	
	@Autowired
	IFollowingCompanyService followingCompanyService;
	
	@Autowired
	IFollowingUserService followingUserService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String listPosts(@CookieValue("user_name") String user_name, ModelMap model) {
		// Add Login Logic (Spring security / Adding Cookies?) 
		model.addAttribute("posts", postService.findAllPosts());
		return "dashboard";
	}
	
//	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//	public String listUsers(ModelMap model) {
//		model.addAttribute("feedbacks", userService.findAllUsers());
//		return "dashboard";
//	}

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
		
		// if company does not exist in DB, normalize name and add Company to DB
		String company_name_normalized = Utils.normalizeString(post.getCompany_name());
		
		if (companyService.findById(company_name_normalized) == null) {
			companyService.saveCompany(new Company().setCompany_name(company_name_normalized));
			post.setCompany_name(company_name_normalized);
			postService.savePost(post);
		}
		// else, send email to users who follow the company / user
		else {
			post.setCompany_name(company_name_normalized);
			postService.savePost(post);
			List<String> emails_followingCompany = followingCompanyService.findFollowingCompanyByCompanyName(post.getCompany_name())
					.stream()
					.map(FollowingCompany::getUser_name)
					.map(user_name -> userService.findById(user_name))
					.map(User::getEmail)
					.collect(Collectors.toList());
			List<String> emails_followingUser = followingUserService.findFollowingUserByFollowee(post.getUser_name())
					.stream()
					.map(FollowingUser::getFollower)
					.map(follower -> userService.findById(follower))
					.map(User::getEmail)
					.collect(Collectors.toList());
			EmailService emailService = new EmailService();
			if (!(emails_followingCompany == null || emails_followingCompany.size() == 0)) {
				try {
					emailService.sendFollowingCompanyNotificationEmail(post, emails_followingCompany);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(emails_followingUser == null || emails_followingUser.size() == 0)) {
				try {
					emailService.sendFollowingUserNotificationEmail(post, emails_followingUser);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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
