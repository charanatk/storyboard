package com.app.storyboard.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class StoryDTO {
	private Story story;
	private SubStory subStory;

}
