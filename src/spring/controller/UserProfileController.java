package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String userProfilePage(ModelMap model, @ModelAttribute User user) {
//		if (model.containsAttribute("user_id")) {
//			return "redirect:/dashboard";
//		}
		user = new User();
		user.setFirst_name("first");
		user.setLast_name("last");
		model.addAttribute("test", user);		
		return "profile";
	}
}
