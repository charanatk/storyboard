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
import com.app.storyboard.bean.StoryDTO;
import com.app.storyboard.dao.StoryDao;
import com.app.storyboard.exception.MissingHeaderInfoException;
import com.app.storyboard.exception.RecordNotFoundException;

@Service
@Component
public class StoryServiceImpl implements StoryService {
	@Autowired
	StoryDao storyDao;

	@Override
	public StoryDTO findByStory(StoryDTO storyDTO) {
		Story story = storyDTO.getStory();
		if (!StringUtils.isEmpty(story.getName().trim())) {
			 story = storyDao.applicationData(story.getName());
			storyDTO.setStory(story);
			if ( story!= null) {
				return storyDTO;
			} else {
				throw new RecordNotFoundException("Data not avaliable ");
			}
		} else {
			throw new MissingHeaderInfoException("Input Data Not valid..!");
		}
	}

	@Override
	public Story storyCreate(Story story) {
		return storyDao.storyCreate(story);
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
