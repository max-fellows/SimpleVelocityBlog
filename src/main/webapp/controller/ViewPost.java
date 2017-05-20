package main.webapp.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

@WebServlet("/posts/*")
public class ViewPost extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject private VelocityEngine velocity;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VelocityContext ctx = new VelocityContext();
		ctx.put("blogpost", request.getPathInfo());
		try {
			Template t = velocity.getTemplate("/post/view.vm");
			t.merge(ctx, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
