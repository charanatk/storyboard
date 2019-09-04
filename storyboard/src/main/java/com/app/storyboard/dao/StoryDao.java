package com.app.storyboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.storyboard.bean.Story;
import com.app.storyboard.repository.StoryRepository;

@Component
public class StoryDao {

	@Autowired
	StoryRepository applicationMetaRepository;

	public Story applicationData(String name) {
		return applicationMetaRepository.findByName(name);

	}

	public Story applicationCreate(@RequestBody Story name) {

		return applicationMetaRepository.save(name);
	}

	public Iterable<Story> apps() {

		return applicationMetaRepository.findAll();
	}
}
