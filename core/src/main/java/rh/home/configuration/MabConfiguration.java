/**
 * 
 */
package rh.home.configuration;

/**
 * Trivial configuration for My Address Book.
 * @author Vincent ROSSIGNOL
 * @since core version 0.0.1
 * @version 0.0.1 
 */
public class MabConfiguration {

	/**
	 * application name (with default value)
	 */
	private String application = "My Address Book";
	
	/**
	 * main instance.
	 */
	private static final MabConfiguration INSTANCE = new MabConfiguration();
	
	/**
	 * main instance.
	 * @return a valid {@link MabConfiguration} instance.
	 */
	public static MabConfiguration getInstance() {
		return INSTANCE;
	}
	
	/**
	 * default constructor.
	 */
	protected MabConfiguration() {
		super();
	}
	
	public String getApplicationName() {
		return this.application;
	}
	
}
