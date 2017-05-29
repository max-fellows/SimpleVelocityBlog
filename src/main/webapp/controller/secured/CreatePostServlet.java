package main.webapp.controller.secured;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import main.java.entity.Post;

@WebServlet("/post")
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
public class CreatePostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject private VelocityEngine velocity;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VelocityContext ctx = new VelocityContext();
		Post post = new Post();
		ctx.put("post", post);
		try {
			Template t = velocity.getTemplate("/post/new.vm");
			t.merge(ctx, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		try {
			BeanUtils.populate(post, request.getParameterMap());
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		post.setId(1000);
		
		VelocityContext ctx = new VelocityContext();
		ctx.put("post", post);
		try {
			Template t = velocity.getTemplate("/post/new.vm");
			t.merge(ctx, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
