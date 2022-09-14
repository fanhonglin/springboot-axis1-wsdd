package org.github.axis1.ws;

import java.io.File;
import java.io.InputStream;

import javax.servlet.ServletConfig;

import org.apache.axis.AxisProperties;
import org.apache.axis.ConfigurationException;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.EngineConfigurationFactory;
import org.apache.axis.components.logger.LogFactory;
import org.apache.axis.configuration.EngineConfigurationFactoryDefault;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.server.AxisServer;
import org.apache.axis.utils.ClassUtils;
import org.apache.axis.utils.Messages;
import org.apache.commons.logging.Log;

/**
 * This is a default implementation of ServletEngineConfigurationFactory. It is
 * user-overrideable by a system property without affecting the caller. If you
 * decide to override it, use delegation if you want to inherit the behaviour of
 * this class as using class extension will result in tight loops. That is, your
 * class should implement EngineConfigurationFactory and keep an instance of
 * this class in a member field and delegate methods to that instance when the
 * default behaviour is required.
 * 
 * 
 *
 * @author Richard A. Sitze
 * @author Davanum Srinivas (dims@apache.org)
 */
public class SpringBootEngineConfigurationFactoryServlet extends EngineConfigurationFactoryDefault {
	protected static Log log = LogFactory.getLog(SpringBootEngineConfigurationFactoryServlet.class.getName());

	private ServletConfig cfg;

	/**
	 * Creates and returns a new EngineConfigurationFactory. If a factory cannot be
	 * created, return 'null'.
	 * 
	 * The factory may return non-NULL only if: - it knows what to do with the param
	 * (param instanceof ServletContext) - it can find it's configuration
	 * information
	 * 
	 * @see org.apache.axis.configuration.EngineConfigurationFactoryFinder
	 */
	public static EngineConfigurationFactory newFactory(Object param) {
		/**
		 * Default, let this one go through if we find a ServletContext.
		 * 
		 * The REAL reason we are not trying to make any decision here is because it's
		 * impossible (without refactoring FileProvider) to determine if a *.wsdd file
		 * is present or not until the configuration is bound to an engine.
		 * 
		 * FileProvider/EngineConfiguration pretend to be independent, but they are
		 * tightly bound to an engine instance...
		 */
		return (param instanceof ServletConfig) ? new SpringBootEngineConfigurationFactoryServlet((ServletConfig) param) : null;
	}

	/**
	 * Create the default engine configuration and detect whether the user has
	 * overridden this with their own.
	 */
	protected SpringBootEngineConfigurationFactoryServlet(ServletConfig conf) {
		super();
		this.cfg = conf;
	}

	/**
	 * Get a default server engine configuration.
	 *
	 * @return a server EngineConfiguration
	 */
	public EngineConfiguration getServerEngineConfig() {
		return getServerEngineConfig(cfg);
	}

	/**
	 * Get a default server engine configuration in a servlet environment.
	 *
	 * @param ctx
	 *            a ServletContext
	 * @return a server EngineConfiguration
	 */
	private static EngineConfiguration getServerEngineConfig(ServletConfig cfg) {

		
		//ServletContext ctx = cfg.getServletContext();

		// Respect the system property setting for a different config file
		String configFile = cfg.getInitParameter(OPTION_SERVER_CONFIG_FILE);
		if (configFile == null)
			configFile = AxisProperties.getProperty(OPTION_SERVER_CONFIG_FILE);
		if (configFile == null) {
			configFile = SERVER_CONFIG_FILE;
		}

		/**
		 * Flow can be confusing. Here is the logic: 1) Make all attempts to open
		 * resource IF it exists - If it exists as a file, open as file (r/w) - If not a
		 * file, it may still be accessable as a stream (r) (env will handle security
		 * checks). 2) If it doesn't exist, allow it to be opened/created
		 * 
		 * Now, the way this is done below is: a) If the file does NOT exist, attempt to
		 * open as a stream (r) b) Open named file (opens existing file, creates if not
		 * avail).
		 */

		/*
		 * Use the WEB-INF directory (so the config files can't get snooped by a
		 * browser)
		 */
		String appWebInfPath = "/";

		FileProvider config = null;

		//String realWebInfPath = ctx.getRealPath(appWebInfPath);
		
		//String appWebInfPath = "/WEB-INF";
        //由于部署方式变更为jar部署，此处不可以使用改方式获取路径
//        ServletContext ctx = cfg.getServletContext();
//        String realWebInfPath = ctx.getRealPath(appWebInfPath);

       //FileProvider config = null;
        String realWebInfPath = SpringBootEngineConfigurationFactoryServlet.class.getResource(appWebInfPath).getPath();
        
        log.info("支持spring boot jar 启动方式，获取wsdd . realWebInfPath = " + realWebInfPath);
        
		/**
		 * If path/file doesn't exist, it may still be accessible as a resource-stream
		 * (i.e. it may be packaged in a JAR or WAR file).
		 */
		if (realWebInfPath == null || !(new File(realWebInfPath, configFile)).exists()) {
			//修改目录
			String name = appWebInfPath +  configFile;
			
			//修改，读取数据
			InputStream is = ClassUtils.getResourceAsStream(SpringBootEngineConfigurationFactoryServlet.class, name);
			
			if (is != null) {
				// FileProvider assumes responsibility for 'is':
				// do NOT call is.close().
				config = new FileProvider(is);
			}

			if (config == null) {
				log.error(Messages.getMessage("servletEngineWebInfError03", name));
			}
		}

		/**
		 * Couldn't get data OR file does exist. If we have a path, then attempt to
		 * either open the existing file, or create an (empty) file.
		 */
		if (config == null && realWebInfPath != null) {
			try {
				config = new FileProvider(realWebInfPath, configFile);
			} catch (ConfigurationException e) {
				log.error(Messages.getMessage("servletEngineWebInfError00"), e);
			}
		}

		/**
		 * Fall back to config file packaged with AxisEngine
		 */
		if (config == null) {
			log.warn(Messages.getMessage("servletEngineWebInfWarn00"));
			try {
				InputStream is = ClassUtils.getResourceAsStream(AxisServer.class, SERVER_CONFIG_FILE);
				config = new FileProvider(is);
			} catch (Exception e) {
				log.error(Messages.getMessage("servletEngineWebInfError02"), e);
			}
		}

		return config;
	}
}
