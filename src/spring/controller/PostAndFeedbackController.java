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

import spring.model.Reply;
import spring.service.IPostFeedbackService;
import spring.service.IPostService;
import spring.service.IReplyService;

@Controller
@RequestMapping("/")
@SessionAttributes("user_id")
public class PostAndFeedbackController {

	@Autowired
	IPostService postService;

	@Autowired
	IReplyService replyService;

	@Autowired
	IPostFeedbackService postFeedbackService;

	private static final int VIEW_STATUS = 0;
	private static final int REPLY_STATUS = 1;
	private static final int EDIT_STATUS = 2;
	private int postStatus = 0;

	@RequestMapping(value = { "/view-{post_id}-post" }, method = RequestMethod.GET)
	public String viewPost(@PathVariable int post_id, ModelMap model) {
		model.addAttribute("post", postService.findById(post_id));
		model.addAttribute("postFeedbacks", postFeedbackService.findPostFeedbacksByPostID(post_id));
		return "detailedPost";
	}


	@RequestMapping(value = { "/edit-{id}-post" }, method = RequestMethod.GET)
	public String editPost(@PathVariable int id, ModelMap model) {
		if (model.containsAttribute("user_id")) {
			model.addAttribute("post", postService.findById(id));
			model.addAttribute("edit", true);
			return "newPost";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/edit-{post_id}-{reply_id}-reply" }, method = RequestMethod.GET)
	public String editReply(@PathVariable int post_id, @PathVariable int reply_id, ModelMap model) {
		if (model.containsAttribute("user_id")) {
			model.addAttribute("editReply", replyService.findById(reply_id));
			replyService.setCurrentlyWorkingReply(replyService.findById(reply_id));
			postStatus = EDIT_STATUS;
			return "redirect:/detailedPost";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/delete-{post_id}-{reply_id}-reply" }, method = RequestMethod.GET)
	public String deleteReply(@PathVariable int post_id, @PathVariable int reply_id, ModelMap model) {
		if (model.containsAttribute("user_id")) {
			replyService.deleteReplyByID(reply_id);
			return "redirect:/detailedPost";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/reply-{post_id}-{reply_id}-{reply_depth}-reply" }, method = RequestMethod.GET)
	public String recursiveReply(@PathVariable int post_id, @PathVariable int reply_id, @PathVariable int reply_depth,
			ModelMap model) {
		if (model.containsAttribute("user_id")) {
			replyService.setCurrentlyWorkingReply(replyService.findById(reply_id));
			postStatus = REPLY_STATUS;
			return "redirect:/detailedPost";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/detailedPost" }, method = { RequestMethod.GET })
	public String redirectToDetailedPost(ModelMap model) {
		if (model.containsAttribute("user_id")) {
			model.addAttribute("post", postService.getCurrentPost());
			model.addAttribute("replies", replyService.findSortedReplies(postService.getCurrentPostID()));
			model.addAttribute("reply", new Reply());
			model.addAttribute("recursiveReply", new Reply());
			model.addAttribute("editReply", new Reply());

			if (postStatus == REPLY_STATUS) {
				int newDepth = replyService.getCurrentlyWorkingReply().getDepth() + 1;
				model.addAttribute("recursiveReplyPressed", true);
				model.addAttribute("replyDepth", newDepth);
				model.addAttribute("clickedReplyID", replyService.getCurrentlyWorkingReply().getId());
			}

			if (postStatus == EDIT_STATUS) {
				model.addAttribute("editReplyPressed", true);
				model.addAttribute("clickedReplyID", replyService.getCurrentlyWorkingReply().getId());
			}

			return "detailedPost";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/detailedPost" }, method = RequestMethod.POST)
	public String saveReply(@Valid Reply reply, BindingResult result, ModelMap model) {
		if (model.containsAttribute("user_id")) {

			if (result.hasErrors()) {
				return "detailedPost";
			}

			else if (postStatus == REPLY_STATUS || postStatus == VIEW_STATUS)
				replyService.saveReply(reply);

			else if (postStatus == EDIT_STATUS)
				replyService.updateReply(reply);

			model.addAttribute("replies", replyService.findSortedReplies(reply.getPost_id()));
			model.addAttribute("post", postService.getCurrentPost());
			replyService.setCurrentlyWorkingReply(null);
			postStatus = VIEW_STATUS;
			return "detailedPost";
		}
		return "redirect:/login";
	}

}
