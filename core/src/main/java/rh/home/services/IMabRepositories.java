/**
 * 
 */
package rh.home.services;

import rh.home.repositories.MabEntryRepository;

/**
 * general interface for My Address Book repositories.
 * @author Vincent ROSSIGNOL
 * @since core version 0.0.1
 * @version 0.0.1
 */
public interface IMabRepositories {

	/**
	 * repository used for My Address Book entries.
	 * @return a valid {@link MabEntryRepository} instance.
	 */
	MabEntryRepository getEntryRepository();
}
