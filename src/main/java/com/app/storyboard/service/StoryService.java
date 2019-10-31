package com.app.storyboard.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.storyboard.bean.Story;
import com.app.storyboard.bean.StoryDTO;

@Component
@Service
public interface StoryService {

	public StoryDTO findByStory(StoryDTO storyDTO);

	public Story storyCreate(Story story);

	public Iterable<Story> apps();

	public List<Story> getAllStrory(Integer pageNo, Integer pageSize, String sortBy);

}
