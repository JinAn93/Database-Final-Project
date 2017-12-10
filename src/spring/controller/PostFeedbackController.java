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

import spring.service.IPostFeedbackService;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class PostFeedbackController {

	@Autowired
	IPostFeedbackService postFeedbackService;
	@RequestMapping(value = { "/view-{post_id}-post" }, method = RequestMethod.GET)
	public String listPostFeedbacksByUserName(@PathVariable String userName, ModelMap model) {
		model.addAttribute("postFeedback", postFeedbackService.findPostFeedbacksByUserName(userName));
		return "detailedPost";
	}
}
