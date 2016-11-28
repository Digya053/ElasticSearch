package com.elastic.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.elastic.Post;

/**
 * This interface is to be implemented by PostServiceImpl class 
 * @author digya
 *
 */
public interface ElasticRepositories extends ElasticsearchRepository<Post, String>{

    Page<Post> findByTagsName(String name, Pageable pageable);
}
