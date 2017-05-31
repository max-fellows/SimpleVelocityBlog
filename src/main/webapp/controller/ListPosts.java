package main.webapp.controller;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import main.java.service.PostService;

@WebServlet("/posts")
public class ListPosts extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject private VelocityEngine velocity;
	@Inject private PostService postService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		VelocityContext ctx = new VelocityContext();
		ctx.put("posts", postService.find());
		try {
			Template t = velocity.getTemplate("/post/view_all.vm");
			t.merge(ctx, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
