package spring.controller;

import java.util.Locale;
import javax.validation.Valid;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import spring.model.User;
import spring.service.IUserService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	IUserService userService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(@CookieValue(value="user_name", required=false) String user_name, ModelMap model) {
		if (user_name == null || user_name.length() == 0) {
			model.addAttribute("user", new User());
			return "loginPage";
		}
		return "redirect:/dashboard";
	}


	@RequestMapping(value = {"/login" }, method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, WebRequest request, HttpServletResponse response, ModelMap model) {
		if (userService.isValidUser(user.getUser_name(), user.getPassword())) {
			response.addCookie(new Cookie("user_name", user.getUser_name()));
			return "redirect:/dashboard";
		}
		
		return "loginPage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@CookieValue(value="user_name", required=false) String user_name, HttpServletResponse response, ModelMap model) {
		if (user_name == null || user_name.length() == 0)
			return "redirect:/login";
		response.addCookie(new Cookie("user_name", null));
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("edit", false);
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid User user, BindingResult result, WebRequest request, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		} else if (!userService.isUserIdUnique(user.getUser_name())) {
			result.addError(createError("user_name", "non.unique.user_name", user.getUser_name()));
			return "registration";
		}

		int errorType = userService.isPasswordValid(user.getPassword());

		if (errorType != 0) {
			switch (errorType) {
			case 1:
				result.addError(createError("password", "non.digit.password", user.getPassword()));
				System.out.println(1);
			case 2:
				result.addError(createError("password", "non.lower.password", user.getPassword()));
				System.out.println(2);
			case 3:
				result.addError(createError("password", "non.upper.password", user.getPassword()));
				System.out.println(3);
			case 4:
				result.addError(createError("password", "non.special.password", user.getPassword()));
				System.out.println(4);
			case 5:
				result.addError(createError("password", "non.whitespace.password", user.getPassword()));
			case 6:
				result.addError(createError("password", "non.length.password", user.getPassword()));
			}
			return "registration";
		}

		else {
			userService.saveUser(user);
			model.addAttribute("success", "New account has been created");
			return "success";
		}

	}

	private FieldError createError(String errorProperty, String messageResourceBundle, String data) {
		FieldError error = new FieldError("user", errorProperty, messageSource.getMessage(messageResourceBundle, new String[] { data }, Locale.getDefault()));
		return error;
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String newPassword(ModelMap model) {
		return "forgotPassword";
	}
}