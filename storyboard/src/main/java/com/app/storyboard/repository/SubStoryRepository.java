package com.app.storyboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.storyboard.bean.Story;
import com.app.storyboard.bean.SubStory;

@Repository
public interface SubStoryRepository extends JpaRepository<SubStory, String> {

	Story findByName(String name);
}
