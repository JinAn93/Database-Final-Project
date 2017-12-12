package spring.controller;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String listPosts(@CookieValue(value="user_name", required=false) String user_name, ModelMap model) {
		System.out.println(user_name);
		if (user_name == null || user_name.length() == 0)
			return "redirect:/login";
		
		model.addAttribute("posts", postService.findAllPosts());
		return "dashboard";
	}
	
	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String newPost(@CookieValue(value="user_name", required=false) String user_name, ModelMap model) {
		if (user_name == null || user_name.length() == 0)
			return "redirect:/login";
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
		return "successNewPost";
	}
}
