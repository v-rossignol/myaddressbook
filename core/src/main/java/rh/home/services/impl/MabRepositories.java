/**
 * 
 */
package rh.home.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rh.home.repositories.MabEntryRepository;
import rh.home.services.IMabRepositories;

@Service
/**
 * default repositories used by services in My Address Book.
 * @author Vincent ROSSIGNOL
 * @since core version 0.0.1
 * @version 0.0.1
 */
public class MabRepositories implements IMabRepositories {

	/**
	 * My Address Book entries.
	 */
	@Autowired
	private MabEntryRepository entries;
	
	/**
	 * default constructor.
	 */
	public MabRepositories() {
		super();
	}
	
	@Override
	public final MabEntryRepository getEntryRepository() {
		return this.entries;
	}

}
