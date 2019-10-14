package com.app.storyboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		if (!StringUtils.isEmpty(name.trim())) {
			Story story = storyDao.applicationData(name);
			if ( story!= null) {
				return story;
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

	@Override
	public List<Story> getAllStrory(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Story> pagedResult = storyDao.getAllStrory(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<>();
		}
	}
}
