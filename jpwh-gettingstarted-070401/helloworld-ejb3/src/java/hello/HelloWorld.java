package hello;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import javax.naming.InitialContext;
import java.io.File;

public class HelloWorld {

    public static void main(String[] args) throws Exception {

        // Boot the JBoss Microcontainer with EJB3 settings, automatically
        // loads ejb3-interceptors-aop.xml and embedded-jboss-beans.xml
        EJB3StandaloneBootstrap.boot(null);

        // Deploy custom stateless beans (datasource, mostly)
        EJB3StandaloneBootstrap.deployXmlResource("META-INF/helloworld-beans.xml");

        // Deploy all EJBs found on classpath (slow, scans all)
        //EJB3StandaloneBootstrap.scanClasspath();

        // Deploy all EJBs found on classpath (fast, scans only build directory)
        // This is a relative location, matching the substring end of one of java.class.path locations!
        // Print out System.getProperty("java.class.path") to understand this...
        EJB3StandaloneBootstrap.scanClasspath("helloworld-ejb3/build".replace("/", File.separator));

        // Create InitialContext from jndi.properties
        InitialContext initialContext = new InitialContext();

        // Lookup MessageHandler EJB
        MessageHandler msgHandler =
                (MessageHandler) initialContext.lookup("MessageHandlerBean/local");

        // Call EJB
        msgHandler.saveMessages();
        msgHandler.showMessages();

        // Shutdown EJB container
        EJB3StandaloneBootstrap.shutdown();
    }

}