package com.app.storyboard.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.storyboard.bean.Story;

@Repository
public interface StoryRepository extends PagingAndSortingRepository<Story, String> {

	Story findByName(String name);
}
