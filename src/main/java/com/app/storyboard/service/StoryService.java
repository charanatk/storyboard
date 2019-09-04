package com.app.storyboard.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.storyboard.bean.Story;

@Component
@Service
public interface StoryService {

	public Story applicationData(@PathVariable String name);

	public Story applicationCreate(@RequestBody Story name);

	public Iterable<Story> apps();

}
