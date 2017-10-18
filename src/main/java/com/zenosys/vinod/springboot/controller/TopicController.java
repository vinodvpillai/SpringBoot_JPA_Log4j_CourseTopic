/**
 * 
 */
package com.zenosys.vinod.springboot.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zenosys.vinod.springboot.model.TopicModel;
import com.zenosys.vinod.springboot.service.TopicService;

/**
 * This class represents Topic Controller
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */

@Controller
public class TopicController {

	@Autowired
	private TopicService topicService;
	private static final Logger logger = LogManager
			.getLogger(TopicController.class);

	@GetMapping("/topics")
	public String getAllTopics(Model model) {

		logger.debug("Entered into - getAllTopics()");
		List<TopicModel> topicList = topicService.findAllTopics();
		if (topicList != null && topicList.size() > 0) {

			logger.debug("Topics found - getAllTopics() total topics are:"
					+ topicList.size());
			model.addAttribute("topicslist", topicList);
		} else {
			logger.error("Topics Not found - getAllTopics()");
			model.addAttribute("errormsg", "No record found!");
		}
		return "topics";
	}

	@GetMapping("/topics/{id}")
	public String getTopicById(@PathVariable int id, Model model,
			RedirectAttributes redirect) {

		logger.debug("Entered into - getTopicById()");
		TopicModel topicModel = topicService.findTopicById(id);
		if (topicModel != null) {
			logger.debug("Found the Topic :" + topicModel);
			model.addAttribute("topic", topicModel);
			return "view-topic";
		}
		logger.error("Invalid Id - getTopicsById()");
		redirect.addFlashAttribute("errormsg", "Invalid ID");
		return "redirect:/topics";
	}

	@GetMapping("/topics/create")
	public String addTopic(Model model) {
		logger.debug("Entered into - addTopic()");
		model.addAttribute("topic", new TopicModel());
		return "create-topic";
	}

	@PostMapping("/topics/save")
	public String saveTopic(@ModelAttribute TopicModel topic,
			RedirectAttributes redirect, Model model) {
		logger.debug("Entered into - saveTopic()");

		TopicModel topicModel = topicService.addNewTopic(topic);
		if (topicModel != null) {
			redirect.addFlashAttribute("successmsg", "Topic added sucessfully");
			return "redirect:/topics";
		}
		model.addAttribute("topic", topic);
		model.addAttribute("errormsg",
				"Error in adding the topic. Please try again");
		return "add-topic";
	}

	@GetMapping("/topics/edit/{id}")
	public String getTopicForEdit(Model model, @PathVariable int id,
			RedirectAttributes redirect) {
		logger.debug("Entered into - editTopic()");
		TopicModel topic = topicService.findTopicById(id);
		if (topic != null) {
			logger.debug("Topic found - editTopic() :" + topic);
			model.addAttribute("topic", topic);
			return "edit-topic";
		}
		logger.error("Topic Not found Invalid ID - editTopic() :" + id);
		redirect.addFlashAttribute("errormsg", "Invalid ID");
		return "redirect:/topics";
	}

	@PostMapping("/topics/update")
	public String updateTopic(@ModelAttribute TopicModel topic,
			RedirectAttributes redirect, Model model) {
		logger.debug("Entered into - editTopic()");
		TopicModel topicModel = topicService.updateTopic(topic);
		if (topicModel != null) {
			logger.debug("Topic Successfully Editied - updateTopic() :"
					+ topicModel);
			redirect.addFlashAttribute("errormsg", "Invalid ID");
			return "redirect:/topics";

		}
		logger.error("Error in - updateTopic() :" + topic.getId());
		model.addAttribute("topic", topic);
		return "edit-topic";
	}

	@GetMapping(value = "/topics/delete/{id}")
	public String deleteTopic(@PathVariable int id) {
		logger.debug("Entered into - deleteTopic()");
		topicService.deleteTopic(id);
		return "redirect:/topics";
	}

}
