package com.courseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.domain.Topic;
import com.courseapp.repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	// create a new topic
	public Topic saveTopic(Topic topic) throws Exception {
		return topicRepository.save(topic);
	}

	// get topic by ID
	public Topic getTopicById(Long topicId) throws Exception {
		return topicRepository.findOne(topicId);
	}

	public void deleteTopic(Long topicId) throws Exception {
		Topic topic = topicRepository.findOne(topicId);
		if (topic == null) {
			throw new Exception("Topic not found ");

		}
		topicRepository.delete(topic);
	}

}
