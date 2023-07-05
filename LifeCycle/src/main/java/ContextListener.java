import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger( ContextListener.class.getName());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		LOG.log(Level.INFO, "================  Context Started ===================");
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		LOG.log(Level.INFO, "================  Context Destroyed ===================");

	}
}
