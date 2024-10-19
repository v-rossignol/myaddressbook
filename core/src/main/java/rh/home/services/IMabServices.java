/**
 * 
 */
package rh.home.services;

/**
 * general interface for My Address Book.
 * @author Vincent ROSSIGNOL
 * @version 0.0.1
 * @since core version 0.0.1
 */
public interface IMabServices {

	/**
	 * associated entry service.
	 * @return a valid {@link MabEntryService} instance.
	 */
	MabEntryService getEntryService();
	
}
