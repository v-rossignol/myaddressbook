/**
 * 
 */
package rh.home.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rh.home.data.MabEntry;
import rh.home.repositories.MabEntryRepository;

/**
 * REST API controller for My Address Book
 * @author Vincent ROSSIGNOL
 * @since ui version 0.0.1
 * @version 0.0.1 
 */
@RestController
public class EntryController {

	/**
	 * associated entry repository.
	 */
	private final MabEntryRepository entries;
	
	/**
	 * constructor.
	 */
	public EntryController( MabEntryRepository entries ) {
		super();
		this.entries = entries;
	}
	
	/**
	 * associated entries.
	 * @return a valid {@link MabEntryRepository} instance.
	 */
	protected MabEntryRepository entries() {
		return this.entries;
	}
	
	@GetMapping( "/entries" )
	List<MabEntry> all() {
		return this.entries().findAll();
	}

}
