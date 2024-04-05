package com.kk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kk.entity.Topic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class TopicDaoImpl implements TopicDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void deleteTopic(int topicId) {
		em.remove(getTopicById(topicId));
	}

	@Override
	public boolean topicExists(String title, String category) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		String hql="FROM Topic as t ORDER BY t.topicId";
		return (List<Topic>) em.createQuery(hql).getResultList();
	}

	@Override
	public Topic getTopicById(int topicId) {
		return em.find(Topic.class, topicId);
	}

	@Override
	public void addTopic(Topic topic) {
		em.persist(topic);
		
	}

	@Override
	public void updateTopic(Topic topic) {
		Topic dbTopic=getTopicById(topic.getTopicId());
		dbTopic.setTitle(topic.getTitle());
		dbTopic.setCategory(topic.getCategory());
		em.flush();
				
	}

}
