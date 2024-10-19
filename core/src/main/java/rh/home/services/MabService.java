/**
 * 
 */
package rh.home.services;

/**
 * base class for My Address Book services.
 * @author Vincent ROSSIGNOL
 * @since core version 0.0.1
 * @version 0.0.1
 */
public class MabService {

	/**
	 * associated repositories.
	 */
	private final IMabRepositories repositories;
	
	/**
	 * constructor
	 * @param repositories a valid {@link IMabRepositories} instance.
	 */
	public MabService( IMabRepositories repositories ) {
		
		super();
		
		assert repositories != null : "invalid repositories: null isn't allowed";
		this.repositories = repositories;
	}

	/**
	 *  associated repositories.
	 * @return a valid {@link IMabRepositories} instance.
	 */
	protected final IMabRepositories getRepositories() {
		return this.repositories;
	}
	
}
