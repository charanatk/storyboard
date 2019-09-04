package com.app.storyboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.storyboard.bean.Story;
import com.app.storyboard.dao.StoryDao;
import com.app.storyboard.exception.MissingHeaderInfoException;
import com.app.storyboard.exception.RecordNotFoundException;

@Service
@Component
public class StoryServiceImpl implements StoryService {
	@Autowired
	StoryDao storyDao;

	@Override
	public Story applicationData(String name) {
		System.out.println(name);
		if (!StringUtils.isEmpty(name.trim())) {
			if (storyDao.applicationData(name) != null) {
				return storyDao.applicationData(name);
			} else {
				throw new RecordNotFoundException("Data not avaliable ");
			}
		} else {
			throw new MissingHeaderInfoException("Input Data Not valid..!");
		}
	}

	@Override
	public Story applicationCreate(Story story) {
		return storyDao.applicationCreate(story);
	}

	@Override
	public Iterable<Story> apps() {
		return storyDao.apps();
	}
}
