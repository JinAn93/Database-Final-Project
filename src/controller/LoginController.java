package com.fasoo.spring.controller;

import java.util.Locale;

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

import com.fasoo.spring.model.User;
import com.fasoo.spring.service.IUserService;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class LoginController {

	@Autowired
	IUserService userService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		if (model.containsAttribute("user_id"))
			return "redirect:/dashboard";
		return "loginPage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		if (model.containsAttribute("user_id"))
			return "logout";
		return "redirect:/login";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		else if (!userService.isUserIdUnique(user.getUser_id())) {
			result.addError(createError("user_id", "non.unique.user_id", user.getUser_id()));
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

	@RequestMapping(value = { "/edit-{user_id}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String user_id, ModelMap model) {
		if (model.containsAttribute("user_id")) {
			model.addAttribute("user", userService.findById(user_id));
			model.addAttribute("edit", true);
			return "registration";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/edit-{user_id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String user_id) {
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
}
