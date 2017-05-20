package main.webapp.velocity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.velocity.app.VelocityEngine;

public class VelocityEngineProducer {
	
	@Inject ServletContext ctx;
	
	@ApplicationScoped
	@Produces VelocityEngine getVelocityEngine() throws Exception {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setApplicationAttribute("javax.servlet.ServletContext", ctx);

		ClassLoader classLoader = getClass().getClassLoader();
		velocityEngine.init(classLoader.getResource("velocity.properties").getPath());
		
		return velocityEngine;
	}
	
}
