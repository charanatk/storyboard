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
	StoryRepository storyRep;

	public Story applicationData(String name) {
		return storyRep.findByName(name);

	}

	public Story storyCreate(Story story) {
		return storyRep.save(story);
	}

	public Iterable<Story> apps() {
		return storyRep.findAll();
	}

	public Page<Story> getAllStrory(Pageable paging) {
		return storyRep.findAll(paging);
	}
}
