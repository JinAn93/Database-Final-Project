package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.model.Post;
import spring.model.User;
import spring.service.IPostService;
import spring.service.IUserService;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class UserProfileController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IPostService postService;
	
	@RequestMapping(value =  "/profile", method = RequestMethod.GET)
	public String userProfilePage(ModelMap model) {
//		if (model.containsAttribute("user_id")) {
//			return "redirect:/dashboard";
//		}
		
		User user = userService.findById("root");	//some username		
		//TODO check if user is null
		System.out.println("UName: " + user.getUser_name());
		System.out.println("FName: " + user.getFirst_name());
		System.out.println("LName: " + user.getLast_name());
		System.out.println("Pass: " + user.getPassword());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Comp: " + user.getCurrent_company());
		
		List<Post> postsList = postService.findPostsByUserName("root");
		System.out.println("PostsList: " + postsList);
		for (Post post : postsList) {			
			System.out.println("PostsList: " + post.getPost_id());
			System.out.println("PostsList: " + post.getCompany_name());
			System.out.println("PostsList: " + post.getUser_name());
			System.out.println("PostsList: " + post.getContent());
		}
		
		
		model.addAttribute("test", user);		
		return "profile";
	}
}
