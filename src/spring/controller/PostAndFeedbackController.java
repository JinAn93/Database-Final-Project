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

import spring.model.Post;
import spring.model.PostFeedback;
import spring.model.Reply;
import spring.service.IPostFeedbackService;
import spring.service.IPostService;
import spring.service.IReplyService;

@Controller
@RequestMapping("/")
public class PostAndFeedbackController {

	@Autowired
	IPostService postService;

	@Autowired
	IReplyService replyService;

	@Autowired
	IPostFeedbackService postFeedbackService;

	@RequestMapping(value = { "/view-{post_id}-post" }, method = RequestMethod.GET)
	public String viewPost(@PathVariable int post_id, ModelMap model) {
		model.addAttribute("post", postService.findById(post_id));
		model.addAttribute("postFeedback", new PostFeedback());
		model.addAttribute("postFeedbacks", postFeedbackService.findPostFeedbacksByPostID(post_id));
		return "detailedPost";
	}

	@RequestMapping(value = { "/view-{post_id}-post" }, method = RequestMethod.POST)
	public String savePost(@PathVariable int post_id, @Valid PostFeedback postFeedback, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("post", postService.findById(post_id));
			model.addAttribute("postFeedback", new PostFeedback());
			model.addAttribute("postFeedbacks", postFeedbackService.findPostFeedbacksByPostID(post_id));
			return "detailedPost";
		}

		postFeedbackService.savePostFeedback(postFeedback);

		model.addAttribute("post", postService.findById(post_id));
		model.addAttribute("postFeedback", new PostFeedback());
		model.addAttribute("postFeedbacks", postFeedbackService.findPostFeedbacksByPostID(post_id));

		return "detailedPost";
	}

	@RequestMapping(value = { "/edit-{post_id}-post" }, method = RequestMethod.GET)
	public String editPost(@PathVariable int post_id, ModelMap model) {
		model.addAttribute("post", postService.findById(post_id));
		return "editPost";
	}
	
	@RequestMapping(value = { "/edit-{post_id}-post" }, method = RequestMethod.POST)
	public String saveEditPost(@PathVariable int post_id, @Valid Post post, BindingResult result,
			ModelMap model) {	
		if (result.hasErrors()) {
			model.addAttribute("post", postService.findById(post_id));
			return "editPost";
		}
		postService.updatePost(post);
		model.addAttribute("post", postService.findById(post_id));
		
		return "view-"+post.getPost_id()+"-post";
	}
	
	@RequestMapping(value = { "/delete-{post_id}-post"}, method = RequestMethod.GET)
	public String deletePost(@PathVariable int post_id, ModelMap model) {
		postService.deletePostByID(post_id);
		return "dashboard";
	}
}
