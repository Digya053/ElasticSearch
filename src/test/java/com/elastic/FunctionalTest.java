package com.elastic;

import org.testng.annotations.Test;
import com.elastic.serviceLayer.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static com.jayway.restassured.RestAssured.given;
import java.util.Arrays;

/**
 * This is a program created to test the controller and the database of the program.
 * @author digya
 *
 */

@ContextConfiguration(classes = ElasticApplication.class)
public class FunctionalTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	public PostServiceImpl postService;
	
	/**
	 * This method test the url.
	 */
  
	@Test
	public void test(){
		given().when().get("http://localhost:8090/test").then().statusCode(200);
	}
	
	/**
	 * This method sets the id, name and tag parameters in the elastic search.
	 */
	
	@Test
	public void testFindByTagsName(){
		Tag t = new Tag();
		t.setId("7");
		t.setName("Nishan");
		Post p = new Post();
		p.setId("8");
		p.setTitle("Chemistry");
		p.setTags(Arrays.asList(t));
		postService.save(p);
		
		}
}

		
