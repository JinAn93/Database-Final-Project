package spring.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.FollowingUser;
import spring.model.Post;
import spring.model.User;
import spring.service.IFollowingCompanyService;
import spring.service.IFollowingUserService;
import spring.service.IPostService;
import spring.service.IUserService;

@Controller
@RequestMapping("/")
public class UserProfileController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IPostService postService;
	
	@Autowired
	IFollowingCompanyService followingCompanyService;
	
	@Autowired
	IFollowingUserService followingUserService;
	
	@RequestMapping(value =  "/profile", method = RequestMethod.GET)
	public String userProfilePage(ModelMap model) {
		//TODO redirect to dashboard if user not logged in
//		if (model.containsAttribute("user_id")) {
//			return "redirect:/dashboard";
//		}
		//TODO link user name
		User user = userService.findById("root");			
		List<Post> postsList = postService.findPostsByUserName(user.getUser_name());
		//TODO Fix dao/model for company and follower; cant cast BigInt to long for follower and sql exception for company since column names not correct
//		List<FollowingCompany> followedCompaniesList = followingCompanyService.findFollowingCompanyByUserName(user.getUser_name());
		List<FollowingUser> followingUsers = followingUserService.findFollowingUserByFollower(user.getUser_name());
//		Long NumFollowers = followingUserService.countFollowingUserByFollowee(user.getUser_name());
		
		Collections.sort(postsList, new Comparator<Post>() {
			@Override
			public int compare(Post o1, Post o2) {
				if (o2.getPost_date() == null || o1.getPost_date() == null) return -1;
				return o2.getPost_date().compareTo(o1.getPost_date());
			}					
		});
		model.addAttribute("User", user);	
		model.addAttribute("Posts", postsList);
//		model.addAttribute("FollowedCompanies", followedCompaniesList);
		model.addAttribute("FollowedUsers", followingUsers);
//		model.addAttribute("NumFollowers", NumFollowers);
		return "profile";
	}
}
