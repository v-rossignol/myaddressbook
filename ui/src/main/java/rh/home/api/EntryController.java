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
 * 
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
