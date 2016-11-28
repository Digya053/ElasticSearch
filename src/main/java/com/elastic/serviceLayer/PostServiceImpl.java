package com.elastic.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.elastic.Post;
import com.elastic.repositories.ElasticRepositories;
import com.elastic.serviceLayer.PostService;

/**
 * This is the implementation class of {@link com.elastic.serviceLayer.PostService}
 * @author digya
 *
 */
@Service 
public class PostServiceImpl implements PostService{
 
@Autowired
private ElasticRepositories es;

/**
 * This method saves the new data given to {@link com.elastic.Post} type.
 * @param post This takes the post of return type Post.
 */

@Override
public Post save(Post post) {
        es.save(post);        
        return post;
       }
/**
 * This method finds the data of the given id.
 * @param id This takes the string of id.
 */
		

    @Override public Post findOne(String id) {
        return es.findOne(id);
   }
    
    /**
     * This method finds all the data.
     * @return list This returns every data.
     */

    @Override public Iterable<Post> findAll() {
        return es.findAll();
   }
    
    /**
     * This method search the data by the tag name.
     * return Page This returns the Page object.
     */

    @Override public Page<Post> findByTagsName(String tagName, PageRequest pageRequest) {
        return es.findByTagsName(tagName, pageRequest);
   }

	
	}

