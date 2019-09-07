package com.app.storyboard.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.storyboard.bean.Story;

@Component
@Service
public interface StoryService {

	public Story applicationData(String name);

	public Story applicationCreate(Story name);

	public Iterable<Story> apps();

	public List<Story> getAllStrory(Integer pageNo, Integer pageSize, String sortBy);

}
