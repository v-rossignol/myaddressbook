/**
 * 
 */
package rh.home;

import java.awt.EventQueue;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import rh.home.ui.MabMainWindow;

/**
 * main application.
 * <p>
 * as we use both <b>Spring Boot</b> and <b>Swing</b> frameworks, we need to do some synchronization
 * between both (they're not really compatible).
 * </p>
 * @author Vincent ROSSIGNOL
 * @version 0.0.1
 * @since ui version 0.0.1
 */
@SpringBootApplication( scanBasePackages = "rh.home" )
public class MyAddressBook {
	
	/**
	 * application entry point.
	 * @param args command line arguments as an array of {@link String} instances.
	 */
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(MyAddressBook.class).headless(false).run(args);
		
	    EventQueue.invokeLater(() -> {
	        MabMainWindow window = context.getBean(MabMainWindow.class);
	        window.refresh();
	        window.setVisible(true);
	    });
	}
	
}
