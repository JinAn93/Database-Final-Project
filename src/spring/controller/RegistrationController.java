package spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import spring.model.User;
import spring.service.IUserService;


public class RegistrationController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, ModelMap model) {
		User user = new User();
	    model.addAttribute("user", user);
	    return "registration";
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
		}

		else if (!userService.isUserIdUnique(user.getUser_name())) {
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
	
	private FieldError createError(String errorProperty, String messageResourceBundle, String data) {
		FieldError error = new FieldError("user", errorProperty, messageSource.getMessage(messageResourceBundle, new String[] { data }, Locale.getDefault()));
		return error;
	}
}

