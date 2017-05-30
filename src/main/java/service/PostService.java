package main.java.service;

import javax.ejb.Stateless;

import main.java.entity.Post;

@Stateless
public class PostService extends PersistenceService<Post> {
	
	public Post find(Integer id) {
		return entityManager.find(Post.class, id);
	}

}
