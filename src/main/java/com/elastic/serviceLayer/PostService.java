package com.elastic.serviceLayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.elastic.Post;

public interface PostService {
	Post save(Post post);
    Post findOne(String id);
    Iterable<Post> findAll();
    Page<Post> findByTagsName(String tagName, PageRequest pageRequest);

}
