package com.example.RCMT.service;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RCMT.entity.RCMTEntity;
import com.example.RCMT.repository.RCMTRepository;

@Service
public class RCMTService {
	@Autowired
	private RCMTRepository repository;
	
	public List<RCMTEntity> findAll(){
		return repository.findAll();
	}
	
	@Transactional 
//	この処理をトランザクションにする（途中で失敗したらもとに戻す）
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@Transactional 
	public void addMusic(String title,String url,String friend,String artist) {
		RCMTEntity entity = new RCMTEntity();
		entity.setTitle(title);
		entity.setUrl(url);
		entity.setArtist(artist);
		entity.setRecommendFriend(friend);
		entity.setAddDate(LocalDateTime.now());
		repository.save(entity);
	}	
	
	@Transactional 
	public void addReview(Integer id, String comment, int evaluation) {
		RCMTEntity entity = repository.findById(id).orElseThrow();
		entity.setComment(comment);
		entity.setEvaluation(evaluation);
		repository.save(entity);
	}
	
//	@Transactional 
//	public void toggleFlag(Integer id) {
//		RCMTEntity entity = repository.findById(id).orElseThrow();
//		entity.setListened(!entity.isListened());
//		repository.save(entity);
//	}
	
}
