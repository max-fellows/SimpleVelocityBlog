package main.java.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import main.java.entity.Post;

@Stateless
public class PostService extends PersistenceService<Post> {
	
	public Post find(Integer id) {
		return entityManager.find(Post.class, id);
	}
	
	public List<Post> find() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
		Root<Post> root = criteria.from(Post.class);
		criteria.select(root);
		List<Post> posts = entityManager.createQuery(criteria).getResultList();
		
		return posts;
	}

}
