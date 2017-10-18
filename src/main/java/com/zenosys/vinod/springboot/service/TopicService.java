/**
 * 
 */
package com.zenosys.vinod.springboot.service;

import java.util.List;

import com.zenosys.vinod.springboot.model.TopicModel;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public interface TopicService {

	public TopicModel addNewTopic(TopicModel topic);
	public TopicModel updateTopic(TopicModel topic);
	public void deleteTopic(int id);
	public TopicModel findTopicById(int id);
	public List<TopicModel> findAllTopics();
	
}
