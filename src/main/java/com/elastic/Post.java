package com.elastic;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * This program post and returns the id, title and tags of the database.
 * @author digya
 * @version 1.0
 * @since 2016-11-28
 *
 */

@Document(indexName = "post", type = "post", shards = 1, replicas = 0)
public class Post {
@Id String id;    
private String title;// 
@Field(type= FieldType.Nested)
private List<Tag> tags; 

/**
 * This method is used to get the id.
 * @return String This returns the id no.
 */
 public String getId() {
        return id;
}
 /**
  * This method sets the instance id variable.
  * @param id This method contains only one parameter.
  */

    public void setId(String id) {
        this.id = id;
}
    /**
     * This method is used to get the title.
     * @return title This returns the title.
     */

    public String getTitle() {
        return title;
}
    /**
     * This method sets the instance title variable.
     * @param title This method contains only one parameter.
     */

    public void setTitle(String title) {
        this.title = title;
}
    /**
     * This is the list of type {@link com.elastic.Tag}.
     * @return list This returns the tag id.
     */

    public List<Tag> getTags() {
        return tags;
}
    /**
    * This sets the tag parameters.
    * @param tags This is the list of type {@link com.elastic.Tag}.
    */

    public void setTags(List<Tag> tags) {
        this.tags = tags;}
}
