package com.kk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.dao.TopicDao;
import com.kk.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	TopicDao dao;
	
	@Override
	public List<Topic> getAllTopics() {
		return dao.getAllTopics();
	}

	@Override
	public Topic getTopicById(int topicId) {
		Topic topic=dao.getTopicById(topicId);
		return topic;
	}

	@Override
	public boolean addTopic(Topic topic) {
		if(dao.topicExists(topic.getTitle(), topic.getCategory())) {
			return false;
		}else {
			dao.addTopic(topic);
			return true;
		}
		
	}

	@Override
	public void updateTopic(Topic topic) {
		dao.updateTopic(topic);
		
	}

	@Override
	public void deleteTopic(int topicId) {
		dao.deleteTopic(topicId);
		
	}

}
