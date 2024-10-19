/**
 * 
 */
package rh.home.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rh.home.data.MabEntry;


/**
 * repository for {@link MabEntry} objects.
 * @author Vincent ROSSIGNOL
 * @version 0.0.1
 * @since core version 0.0.1
 */
@Repository
public interface MabEntryRepository extends JpaRepository<MabEntry, Long>{

	/**
	 * retrieves and returns a user. 
	 * @param id a valid long value.
	 * @return a valid {@link RidbUser} instance or <code>null</code> if no user can be found.
	 */
	MabEntry findById( long id );
	
	
	/**
	 * find a user from his email.
	 * @param email a valid {@link String} instance.
	 * @return a valid {@link RidbUser} instance or <code>null</code> if no user can be found.
	 */
	//@SQL( "SELECT u FROM users u WHERE u.email = ?1" )
	//MabEntry findByEmail( String email );

}
