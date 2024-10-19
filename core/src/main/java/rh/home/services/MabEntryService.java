/**
 * 
 */
package rh.home.services;

import java.util.List;

import rh.home.data.MabEntry;
import rh.home.repositories.MabEntryRepository;

/**
 * entry service for My Address Book.
 * @author Vincent ROSSIGNOL
 * @since core version 0.0.1
 * @version 0.0.1
 */
public class MabEntryService extends MabService {

	/**
	 * entry repository.
	 */
	private final MabEntryRepository repository; 
	
	/**
	 * constructor.
	 * @param repositories a valid {@link IMabRepositories} instance.
	 */
	public MabEntryService(IMabRepositories repositories) {
		super(repositories);
		this.repository = this.getRepositories().getEntryRepository();
	}
	
	/**
	 * associated entry repository.
	 * @return a valid {@link MabEntryRepository} instance.
	 */
	protected final MabEntryRepository getRepository() {
		return this.repository;
	}
	
	/**
	 * creates a new entry for the given first and last names.
	 * @param firstName a valid {@link String} instance.
	 * @param lastName a valid {@link String} instance.
	 * @return created entry as a valid {@link MabEntry} instance.
	 */
	public MabEntry create( String firstName, String lastName ) {
		
		MabEntry toBeCreated = new MabEntry();
		
		toBeCreated.setFirstName(firstName);
		toBeCreated.setName( lastName );
		toBeCreated.setDisplay( lastName + ", " + firstName );
		
		return this.create( toBeCreated );
	}
	
	/**
	 * creates a new entry in the associated repository.
	 * @param value a valid {@link MabEntry} instance.
	 * @return created entry as a valid {@link MabEntry} instance. 
	 */
	public MabEntry create( MabEntry value ) {
		
		assert value != null : "invalid value: null isn't allowed";
		
		if ( value.getDisplay() == null ) {
			this.setDisplay( value );
		}
		
		return this.getRepository().save( value );
		
	}
	
	/**
	 * deletes an entry from the associated repository.
	 * @param value a nullable {@link MabEntry} instance.
	 */
	public void delete( MabEntry value ) {
		if ( value != null ) {
			this.getRepository().delete(value);
		}
	}
	
	/**
	 * sets default display value for a given entry.
	 * @param value a valid {@link MabEntry} instance.
	 */
	protected void setDisplay( MabEntry value ) {
		
		assert value != null : "invalid entry: null isn't allowed."; 
		
		StringBuilder builder = new StringBuilder();
		
		if ( value.getName() != null ) {
			builder.append( value.getName() );
		}
		
		if ( value.getName() != null && value.getFirstName() != null ) {
			builder.append( ", " );
		}
		
		if ( value.getFirstName() != null ) {
			builder.append( value.getFirstName() );
		}
		
		value.setDisplay( builder.toString() );
		
	}
	
	/**
	 * returns the list of all entries.
	 * @return a valid {@link List} of {@link MabEntry} instances.
	 */
	public List<MabEntry> entries() {
		return this.getRepository().findAll();
	}

}
