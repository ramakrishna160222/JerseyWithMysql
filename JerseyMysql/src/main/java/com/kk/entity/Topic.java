package com.kk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="topics")
public class Topic  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int topicId;
	@Column(name="title",nullable=false)
	private String title;
	@Column(name="category",nullable=false)
	private String category;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Topic(int topicId, String title, String category) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.category = category;
	}
	public Topic() {
		super();
	}
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", title=" + title + ", category=" + category + "]";
	}
	
	
	
	

}
