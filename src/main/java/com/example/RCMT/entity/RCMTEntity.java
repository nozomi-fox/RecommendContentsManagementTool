package com.example.RCMT.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "music")
public class RCMTEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String url;
	@Column(nullable = false)
	private LocalDateTime addDate;
	
	@Column(nullable = false)
	private String recommendFriend;
	
//	private boolean listened;
	private String comment;
	private int evaluation;
	private String artist;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDateTime addDate) {
		this.addDate = addDate;
	}
	public String getRecommendFriend() {
		return recommendFriend;
	}
	public void setRecommendFriend(String recommendFriend) {
		this.recommendFriend = recommendFriend;
	}
//	public boolean isListened() {
//		return listened;
//	}
//	public void setListened(boolean listened) {
//		this.listened = listened;
//	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	

}
