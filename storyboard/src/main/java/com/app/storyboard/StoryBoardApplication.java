package com.app.storyboard;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.storyboard.bean.Story;
import com.app.storyboard.bean.SubStory;
import com.app.storyboard.repository.StoryRepository;
import com.app.storyboard.repository.SubStoryRepository;

@SpringBootApplication
public class StoryBoardApplication implements  CommandLineRunner  {

//	@Autowired
//	private ApplicationMetaRepository applicationMetaRepository;
//	
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	SubStoryRepository subStoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoryBoardApplication.class, args);
	}

	public void run(String... strings) throws Exception {
//		ApplicationMeta applicationMeta = new ApplicationMeta();
//		applicationMeta.setName("MyNewApp");
//		applicationMeta.setDescription("This is a completely new application");
//		applicationMetaRepository.save(applicationMeta);
//
//		ApplicationMeta applicationMeta1 = new ApplicationMeta();
//		applicationMeta1.setName("CoolApp");
//		applicationMeta1.setDescription("This is cool application!");
//		applicationMetaRepository.save(applicationMeta1);
		
		Story strory = new Story();
		strory.setAdvId("makeID");
		strory.setAssignedBy("charan");
		strory.setCreatedBy("ravi");
		strory.setDescription("this is make app fast..!!");
		strory.setName("app1 story");
		strory.setTastStatus("Active");
		strory.setCredatedDate(LocalDateTime.now());
		strory.setModifiedDate(LocalDateTime.now());
		
		Set<SubStory> subStory = new HashSet<SubStory>();
		SubStory ss= new SubStory();
		ss.setAssignedBy("Raju");
		ss.setCreatedBy("Ajay");
		ss.setDescription("ss of some thing this is make app fast..!!");
		ss.setName("ss story");
		ss.setTastStatus("Active");
		ss.setCredatedDate(LocalDateTime.now());
		ss.setModifiedDate(LocalDateTime.now());
		SubStory ss1= new SubStory();
		
		ss1.setAssignedBy("vikram");
		ss1.setCreatedBy("Aditya");
		ss1.setDescription("ss of some thing this is make app 2nd..!!");
		ss1.setName("ss 2nd story");
		ss1.setTastStatus("Active");
		ss1.setCredatedDate(LocalDateTime.now());
		ss1.setModifiedDate(LocalDateTime.now());
		
		subStory.add(ss);
		subStory.add(ss1);
		strory.setSubStory(subStory );
		storyRepository.save(strory);
		subStoryRepository.save(ss);
	}

}
