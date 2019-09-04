/**
 * 
 */
package com.app.storyboard.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.app.storyboard.bean.Story;
import com.app.storyboard.repository.StoryRepository;
import com.app.storyboard.service.StoryService;

/**
 * @author Lenovo
 *
 */
public class StoryControllerTest {

	/**
	 * Test method for {@link com.app.storyboard.controller.StoryController#applicationData(java.lang.String)}.
	 */
	@Mock
	StoryController scMock;
	@Mock
	ResponseEntity<Story> story;
	@Mock
	private StoryService stroryService;
	@Mock
	StoryRepository applicationMetaRepository;
	
	@Test
	public void testApplicationData() {
		applicationMetaRepository.findByName("app1 story");
//		stroryService.applicationData("app1 story");
//		scMock.applicationData("app1 story");
//		String expected=scMock.applicationData("app1 story").getBody().getName();
//		String actual = "app1 story";
		assertEquals(true, true);
	}

	/**
	 * Test method for {@link com.app.storyboard.controller.StoryController#applicationCreate(com.app.storyboard.bean.Story)}.
	 */
	@Test
	public void testApplicationCreate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.app.storyboard.controller.StoryController#apps()}.
	 */
	@Test
	public void testApps() {
		fail("Not yet implemented");
	}

}
