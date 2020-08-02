package com.app.storyboard.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.storyboard.bean.Story;
import com.app.storyboard.bean.StoryDTO;
import com.app.storyboard.service.StoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@Api(value = "storyboard", description = "User stories access in Story Board")
@Slf4j
public class StoryController {

	@Autowired
	private StoryService storyService;

	@Lookup
	public StoryDTO getStory() {
		return null;
	}

	@ApiOperation(value = "Search a story with an Name")
	@GetMapping(value = "story/get/{name}")
	public ResponseEntity<Story> findStory(@PathVariable @Size(min = 4) String name) {
		log.info("Start get story");
		StoryDTO storyDTO = getStory();
		Story story = new Story();
		story.setName(name);
		storyDTO.setStory(story);
		log.info("End get story");
		return ResponseEntity.ok().body(storyService.findByStory(storyDTO).getStory());
	}

	@ApiOperation(value = "Add a story")
	@PostMapping(value = "story/add")
	public ResponseEntity<Story> addStory(@Valid @RequestBody Story story) {
		StoryDTO storyDTO = getStory();
		storyDTO.setStory(story);

		return ResponseEntity.ok().body(storyService.storyCreate(storyDTO).getStory());
	}

	@ApiOperation(value = "View a list of storys", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "story/storys")
	public ResponseEntity<Iterable<Story>> apps() {
		return ResponseEntity.ok(storyService.apps());
	}

	@ApiOperation(value = "Search a storys with a by page and sort", response = Iterable.class)
	@GetMapping(value = "story/getstorys/{pageNo}/{pageSize}/{sortBy}")
	public ResponseEntity<List<Story>> getAllStrory(@PathVariable Integer pageNo, @PathVariable Integer pageSize,
			@PathVariable String sortBy) {
		List<Story> list = storyService.getAllStrory(pageNo, pageSize, sortBy);

		return ResponseEntity.ok(list);
	}

}
