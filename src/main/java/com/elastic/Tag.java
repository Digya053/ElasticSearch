package com.elastic;

/**
 * This is the nested database within Post.
 * @author digya
 *
 */

public class Tag {
	 private String id;   
	 private String name; 
	 
	 /**
	  * This method is used to get the id.
	  * @return String This method returns the id no.
	  */
	 
	 public String getId() {
	        return id;
	    }
	 
	 /**
	  *This method sets the id no. 
	  * @param id The id of the tag.
	  */
	 
	    public void setId(String id) {
	        this.id = id;
	    }
	    
	    /**
	     * This method is used to get the name.
	     * @return String This method returns the name.
	     */
	    
	    public String getName() {
	        return name;
	    }
	    
	    /**
	     * This method sets the name.
	     * @param name The name to be set within the nested database tag.
	     */

	    public void setName(String name) {
	        this.name = name;
	  }
	}
