package com.app.storyboard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.storyboard.bean.Story;
import com.app.storyboard.service.StoryService;

@RestController
public class StoryController {

	@Autowired
	private StoryService stroryService;

	@GetMapping(value = "/get/{name}")
	public ResponseEntity<Story> applicationData(@PathVariable String name) {
		return ResponseEntity.ok().body(stroryService.applicationData(name));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Story> applicationCreate(@Valid @RequestBody Story story) {
		return ResponseEntity.ok().body(stroryService.applicationCreate(story));
	}

	@GetMapping(value = "/storys")
	public ResponseEntity<Iterable<Story>> apps() {
		return ResponseEntity.ok(stroryService.apps());
	}
	
	@GetMapping(value = "/getstorys/{pageNo}/{pageSize}/{sortBy}")
	public ResponseEntity<List<Story>> getAllStrory(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @PathVariable String sortBy) {
		List<Story> list = stroryService.getAllStrory(pageNo, pageSize, sortBy);

		return ResponseEntity.ok(list);
	}

}
