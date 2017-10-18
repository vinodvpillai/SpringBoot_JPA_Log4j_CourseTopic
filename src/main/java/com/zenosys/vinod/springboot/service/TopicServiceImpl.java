/**
 * 
 */
package com.zenosys.vinod.springboot.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenosys.vinod.springboot.model.TopicModel;
import com.zenosys.vinod.springboot.repository.TopicRepository;

/**
 * This class represents TopicsService Implementation Class
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	private static final Logger logger = LogManager
			.getLogger(TopicServiceImpl.class);

	@Override
	public TopicModel addNewTopic(TopicModel topic) {

		TopicModel topicModel = topicRepository.save(topic);
		logger.debug("Inside the addNewTopic() result is: " + topicModel);
		return topicModel;
	}

	@Override
	public TopicModel updateTopic(TopicModel topic) {

		TopicModel topicModel = topicRepository.save(topic);
		logger.debug("Inside the updateTopic() result is: " + topicModel);
		return topicModel;
	}

	@Override
	public void deleteTopic(int id) {

		logger.debug("Inside the deleteTopic() the ID is:" + id);
		topicRepository.delete(id);
	}

	@Override
	public TopicModel findTopicById(int id) {

		TopicModel topicModel = topicRepository.findOne(id);
		logger.debug("Inside the findTopicById() result is: " + topicModel);
		return topicModel;
	}

	@Override
	public List<TopicModel> findAllTopics() {

		List<TopicModel> topiclist = topicRepository.findAll();
		logger.debug("Inside the findAllTopics() total objects found are: "
				+ topiclist.size());
		return topiclist;
	}

}
