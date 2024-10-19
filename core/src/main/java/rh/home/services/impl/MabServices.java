/**
 * 
 */
package rh.home.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rh.home.services.IMabRepositories;
import rh.home.services.IMabServices;
import rh.home.services.MabEntryService;

/**
 * default implementation for My Address Book services.
 * @author Vincent ROSSIGNOL
 * @since core version 0.0.1
 * @version 0.0.1
 */
@Service
public class MabServices implements IMabServices {

	/**
	 * associated repositories.
	 */
	@Autowired(required = true)
	private MabRepositories repositories;
	
	/**
	 * main instance
	 */
	private static MabServices INSTANCE = null; 
	
	public static synchronized MabServices getInstance() {
		if ( INSTANCE == null ) {
			INSTANCE = new MabServices();
		}
		return INSTANCE;
	}
	
	/**
	 * constructor.
	 */
	public MabServices() {
		super();
	}

	/**
	 * associated service.
	 */
	private MabEntryService entries = null;
	
	@Override
	public MabEntryService getEntryService() {
		if ( this.entries == null ) {
			this.entries = new MabEntryService( this.getRepositories() );
		}
		return this.entries;
	}
	
	/**
	 * associated repositories.
	 * @return a valid {@link IMabRepositories} instance.
	 */
	protected final IMabRepositories getRepositories() {
		return this.repositories;
	}

}
