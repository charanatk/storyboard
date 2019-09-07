package com.app.storyboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.app.storyboard.bean.Story;
import com.app.storyboard.repository.StoryRepository;


@Component
public class StoryDao {

	@Autowired
	StoryRepository applicationMetaRepository;

	public Story applicationData(String name) {
		return applicationMetaRepository.findByName(name);

	}

	public Story applicationCreate(Story name) {
		return applicationMetaRepository.save(name);
	}

	public Iterable<Story> apps() {
		return applicationMetaRepository.findAll();
	}

	public Page<Story> getAllStrory(Pageable paging) {
		// TODO Auto-generated method stub
		return applicationMetaRepository.findAll(paging);
	}
}
