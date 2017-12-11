package spring.controller;

import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import spring.model.User;
import spring.service.IUserService;

@Controller
@RequestMapping("/")
@SessionAttributes("user_name")
public class LoginController {

	@Autowired
	IUserService userService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		if (model.containsAttribute("user_name"))
			return "redirect:/dashboard";
		model.addAttribute("user", new User());
		return "loginPage";
	}


	@RequestMapping(value = {"/login" }, method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, WebRequest request, ModelMap model) {
		if (userService.isValidUser(user.getUser_name(), user.getPassword())) {
			return "redirect:/dashboard";
		}
		
		return "loginPage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		if (model.containsAttribute("user_name"))
			return "logout";
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

			case 2:
				result.addError(createError("password", "non.lower.password", user.getPassword()));

			case 3:
				result.addError(createError("password", "non.upper.password", user.getPassword()));

			case 4:
				result.addError(createError("password", "non.special.password", user.getPassword()));
				
			case 5:
				result.addError(createError("password", "non.whitespace.password", user.getPassword()));
			}
			return "registration";
		}

		else {
			userService.saveUser(user);
			model.addAttribute("success", "New account has been created");
			return "success";
		}

	}
	
	@RequestMapping(value = { "/edit-{user_name}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String user_name, ModelMap model) {
		if (model.containsAttribute("user_name")) {
			model.addAttribute("user", userService.findById(user_name));
			model.addAttribute("edit", true);
			return "registration";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/edit-{user_name}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String user_name) {
		if (result.hasErrors()) {
			return "registration";
		}

		userService.updateUser(user);
		model.addAttribute("success", "Your account has been successfully modified");
		return "success";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public String loginAttempt(ModelMap model) {
		return "validate";
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